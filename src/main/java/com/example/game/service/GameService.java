package com.example.game.service;

import com.example.game.model.GameItems;
import com.example.game.model.ResponseModel;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    public ResponseModel getResult(String roundChoes) {
        var result = new ResponseModel();
        var v = GameItems.getItem(roundChoes);
        var  c = compareItems(v, GameItems.getRandomItem());

        return result;

    }
    private boolean compareItems(GameItems v, GameItems v1) {
        return false; // if else release
    }



}
