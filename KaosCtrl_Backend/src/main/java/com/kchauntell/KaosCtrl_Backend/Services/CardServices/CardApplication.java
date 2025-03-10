package com.kchauntell.KaosCtrl_Backend.Services.CardServices;

import com.kchauntell.KaosCtrl_Backend.Entity.Cards;
import com.kchauntell.KaosCtrl_Backend.Entity.Card_Priority;
import com.kchauntell.KaosCtrl_Backend.Entity.Card_Status;
import com.kchauntell.KaosCtrl_Backend.Entity.GeneralStatus;

import java.util.List;
import java.util.Optional;

public interface CardApplication {
    public List<Cards> getCards();
    public Optional<Cards> getCardById(int card_id);
    public Optional<Cards> findCardByTitle(String title);
    public GeneralStatus createCard(Cards newCard) throws Exception;
    public Cards updateCard(Cards card) throws Exception;
    public void deleteCard(Cards card) throws Exception;
}
