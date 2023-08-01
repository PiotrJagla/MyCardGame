package com.example.demo.Duel;

import com.example.demo.CardsServices.Cards.Card;
import com.example.demo.CardsServices.Cards.CardsFactory;
import com.example.demo.CardsServices.CardsEffects.RowStatus;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private List<Card> cards;
    private RowStatus status;

    public Row() {
        cards = new ArrayList<>();
        status = RowStatus.NoStatus;
    }

    public void clearRow(){

        boolean spawnChort = false;
        for (Card card : cards) {
            if(card.getDisplay().equals(CardsFactory.cow)) {
                spawnChort = true;
            }
        }
        cards.clear();
        if(spawnChort)
            cards.add(Card.createCard(CardsFactory.chort));
    }


    public void play(Card aCard){
        if(aCard.getPoints() > 0)
            cards.add(aCard);
    }

    public void boostCardBy(Card aCard, int boostAmount){
        int cardIndex = cards.indexOf(aCard);
        if(cardIndex == -1) return;
        cards.get(cardIndex).boostPointsBy(boostAmount);
    }

    public void strikeCardBy(Card aCard, int strikeAmount){
        int cardIndex = cards.indexOf(aCard);
        if(cardIndex == -1) return;
        if(cards.get(cardIndex).getPoints() - strikeAmount < 1) {
            cards.remove(cardIndex);

            if(aCard.getDisplay().equals(CardsFactory.cow)) {
                cards.add(Card.createCard(CardsFactory.chort));
            }
        }
        else {
            cards.get(cardIndex).strikeBy(strikeAmount);
        }
    }

    public int getRowPoints(){
        int result = 0;
        for(int i = 0 ; i < cards.size() ; ++i){
            result += cards.get(i).getPoints();
        }
        return result;
    }

    public void burnCard(Card card){
        cards.remove(card);
    }


    public List<Card> getCards() {
        return cards;
    }

    public Card get(int cardId){
        return cards.get(cardId);
    }

    public void setStatus(RowStatus status) {
        this.status = status;
    }

    public void updateRow() {
        if(status == RowStatus.Rain) {
            int maxPoints = 0;
            Card maxPointsCard = Card.createEmptyCard();
            for (int i = 0; i < cards.size(); i++) {
               if(cards.get(i).getPoints() > maxPoints) {
                   maxPoints = cards.get(i).getPoints();
                   maxPointsCard = cards.get(i);
               }
            }
            strikeCardBy(maxPointsCard, CardsFactory.rainStrikeAmount);
        }
    }

    public String getStatusName() {
        return status.toString();
    }

    public void clearStatus() {
        status= RowStatus.NoStatus;
    }
}
