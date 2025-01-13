package com.kchauntell.KaosCtrl_Backend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kchauntell.KaosCtrl_Backend.Entity.Boards;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Boards, Integer> {
    Optional<Boards> findById(int board_id);
    Optional<Boards> findByName(String name);
}
