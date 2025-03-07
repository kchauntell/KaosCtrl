package com.kchauntell.KaosCtrl_Backend.DAO;

import com.kchauntell.KaosCtrl_Backend.Entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Cards, Integer> {
    Optional<Cards> findById(int card_id);
    Optional<Cards> findByTitle(String title);
}
