package com.example.game.controller;

import com.example.game.model.ResponseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/game")
public class MyGameController {
    @GetMapping("/easy")
    public ResponseModel getEasyResult() {

        return new ResponseModel();
    }
    @GetMapping("/medium")
    public ResponseModel getMediumResult() {

        return new ResponseModel();
    }
    @GetMapping("/hard")
    public ResponseModel getHardResult() {

        return new ResponseModel();
    }

}
