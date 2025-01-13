package com.kchauntell.KaosCtrl_Backend.Controller;

import jakarta.validation.Valid;
import com.kchauntell.KaosCtrl_Backend.DAO.UserRepository;
import com.kchauntell.KaosCtrl_Backend.Entity.Users;
import com.kchauntell.KaosCtrl_Backend.Entity.Status;
import com.kchauntell.KaosCtrl_Backend.Services.UserServices.UserApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController()
@CrossOrigin(origins = {"http://localhost:3000/"})
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserApplication userApplication;

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/registerUser")
    public Status registerUser(@Valid @RequestBody Users user) throws Exception {
        return this.userApplication.registerUser(user);
    }

    @PutMapping("/updateUser")
    public Users updateUser(@Valid @RequestBody Users user) throws Exception {
        return this.userApplication.updateUser(user);
    }

    @DeleteMapping("deleteUser")
    public void deleteUser(@Valid @RequestBody Users user) throws Exception {
        this.userApplication.deleteUserByUsername(user);
    }
}
