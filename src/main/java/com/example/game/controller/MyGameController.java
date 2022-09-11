package com.example.game.controller;

import com.example.game.model.ResponseModel;
import com.example.game.model.User;
import com.example.game.repository.UserRepository;
import com.example.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/game")
public class MyGameController {

    private final GameService gameService;
    private final UserRepository userRepository;

    @Autowired
    public MyGameController(GameService gameService, UserRepository userRepository) {
        this.gameService = gameService;
        this.userRepository = userRepository;
    }

    @GetMapping("/play/{userId}/{choice}")
    public ResponseModel getResult(@PathVariable Integer userId , @PathVariable String choice) {
        return gameService.getResult(choice, userId);
    }
    @GetMapping("/{userId}")
    public User getUser(@PathVariable Integer userId) {
        return userRepository.getUser(userId);
    }

}
