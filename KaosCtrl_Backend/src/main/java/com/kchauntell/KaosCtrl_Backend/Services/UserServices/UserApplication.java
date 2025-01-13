package com.kchauntell.KaosCtrl_Backend.Services.UserServices;

import com.kchauntell.KaosCtrl_Backend.Entity.Users;
import com.kchauntell.KaosCtrl_Backend.Entity.UserStatus;
import java.util.List;
import java.util.Optional;

public interface UserApplication {
    public List<Users> findAllUsers();
    public String getUserRole(Users user);
    public Optional<Users> findByUsername(String username);
    public Optional<Users> findByEmail(String email);
    public UserStatus registerUser(Users user) throws Exception;
    public Users updateUser(Users user) throws Exception;
    public void deleteUserByUsername(Users user) throws Exception;
//    public void deleteUserByEmail(Users user) throws Exception;
}
