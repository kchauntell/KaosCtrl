package com.kchauntell.KaosCtrl_Backend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kchauntell.KaosCtrl_Backend.Entity.Lists;
import java.util.Optional;

public interface ListRepository extends JpaRepository<Lists, Integer> {
    Optional<Lists> findById(Integer id);
    Optional<Lists> findByCategory(String category);
}
