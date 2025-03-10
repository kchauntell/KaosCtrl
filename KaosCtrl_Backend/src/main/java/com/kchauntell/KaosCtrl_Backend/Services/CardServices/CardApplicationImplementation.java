package com.kchauntell.KaosCtrl_Backend.Services.CardServices;

import com.kchauntell.KaosCtrl_Backend.DAO.CardRepository;
import com.kchauntell.KaosCtrl_Backend.Entity.Cards;
import com.kchauntell.KaosCtrl_Backend.Entity.GeneralStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@Service
public class CardApplicationImplementation implements CardApplication {

    @Autowired
    public CardRepository cardRepository;

    public CardApplicationImplementation(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Cards> getCards () {
        return cardRepository.findAll();
    }

    @Override
    public Optional<Cards> getCardById (int id) {
        return this.cardRepository.findById(id);
    }

    @Override
    public Optional<Cards> findCardByTitle(String title) {
        return this.cardRepository.findByTitle(title);
    }

    @Override
    public GeneralStatus createCard (Cards newCard) {
        Optional<Cards> cardToCreate = this.getCardById(newCard.getCard_id());
        if (cardToCreate.isPresent()) {
            System.out.println("Card Already Exists");
            return GeneralStatus.ALREADY_EXISTS;
        }
        this.cardRepository.save(newCard);
        return GeneralStatus.SUCCESS;
    }

    @Override
    public Cards updateCard (Cards card) {
        Optional<Cards> cardToUpdateOptional = this.getCardById(card.getCard_id());
        if (cardToUpdateOptional.isEmpty()) {
            return null;
        }

        Cards cardToUpdate = cardToUpdateOptional.get();

        /*
        The only updates needed for a card (story || task) is for title, description,
        who it is assigned to, due date, priority changes, or status changes). There
        is no need to touch card_id, list_id, user_id
        */
        if (card.getTitle() != null) { cardToUpdate.setTitle(card.getTitle()); }
        if (card.getDescription() != null) { cardToUpdate.setDescription(card.getDescription()); }
        if (card.getAssigned_user() != cardToUpdate.getAssigned_user() ) {
            cardToUpdate.setAssigned_user(card.getAssigned_user());
        }
        if (card.getDueDate() != null) { cardToUpdate.setDueDate(card.getDueDate()); }
        if (card.getCard_priority() != null) { cardToUpdate.setCard_priority(card.getCard_priority()); }
        if (card.getCard_status() != null) { cardToUpdate.setCard_status(card.getCard_status()); }

        cardToUpdate.setUpdatedAt(LocalDateTime.now());
        return this.cardRepository.save(cardToUpdate);
    }

    @Override
    public void deleteCard (Cards card) throws Exception {
        int card_id = card.getCard_id();

        Optional<Cards> cardToDeleteOptional = this.cardRepository.findById(card_id);
        if (cardToDeleteOptional.isEmpty()) {
            throw new Exception("Card does not exist");
        }
        Cards cardToDelete = cardToDeleteOptional.get();
        this.cardRepository.delete(cardToDelete);
    }

}
