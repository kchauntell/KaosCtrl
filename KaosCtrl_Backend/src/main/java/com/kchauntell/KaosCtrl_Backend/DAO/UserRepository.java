package com.kchauntell.KaosCtrl_Backend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kchauntell.KaosCtrl_Backend.Entity.Users;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String email);
}
