package com.kchauntell.KaosCtrl_Backend.Services.UserServices;

import com.kchauntell.KaosCtrl_Backend.DAO.UserRepository;
import com.kchauntell.KaosCtrl_Backend.Entity.Users;
import com.kchauntell.KaosCtrl_Backend.Entity.UserStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserApplicationImplementation implements UserApplication {
    @Autowired
    public UserRepository userRepository;

    public UserApplicationImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> findAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public String getUserRole(Users user) {
        return user.getRole();
    }

    @Override
    public UserStatus registerUser(Users newUser) {
        List<Users> users = this.userRepository.findAll();

        for (Users user : users) {
            if(user.getUsername().equals(newUser.getUsername())) {
                System.out.println("User already exists");
                return UserStatus.USER_ALREADY_EXIST;
            }
        }
        this.userRepository.save(newUser);
        return UserStatus.USER_SUCCESS;
    }

    @Override
    public Users updateUser(Users user) {
        Optional<Users> userToUpdateOptional = this.findByUsername(user.getUsername());
        if(userToUpdateOptional.isEmpty()) {
            return null;
        }

        Users userToUpdate = userToUpdateOptional.get();
        if(user.getFirstname() != null) {
            userToUpdate.setFirstname(user.getFirstname());
        }
        if(user.getLastname() != null) {
            userToUpdate.setLastname(user.getLastname());
        }
        if(user.getUsername() != null) {
            userToUpdate.setUsername(user.getUsername());
        }
        if(user.getEmail() != null) {
            userToUpdate.setEmail(user.getEmail());
        }
        if(user.getPasswordHash() != null) {
            userToUpdate.setPasswordHash(user.getPasswordHash());
        }
        if(user.getRole() != null) {
            userToUpdate.setRole(user.getRole());
        }
        return this.userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUserByUsername(Users user) throws Exception {
        String username = user.getUsername();

        Optional<Users> userToDeleteOptional = this.findByUsername(username);
        if (userToDeleteOptional.isEmpty()) {
            throw new Exception("User does not exist");
        }
        Users userToDelete = userToDeleteOptional.get();
        this.userRepository.delete(userToDelete);

    }
}
