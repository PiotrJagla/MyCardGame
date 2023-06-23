package com.example.demo.CardsServices.CardTargetStrattegies;

import com.example.demo.CardsServices.CardDisplay;

import java.util.List;

public class NoCardTargetable implements CardTargeting{
    @Override
    public List<CardDisplay> getPossibleTargets(List<CardDisplay> playerBoard, List<CardDisplay> enemyBoard) {
        return List.of();
    }
}
