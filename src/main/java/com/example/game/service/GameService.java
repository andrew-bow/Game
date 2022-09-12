package com.example.game.service;

import com.example.game.model.GameItems;
import com.example.game.model.ResponseModel;
import com.example.game.model.User;
import com.example.game.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final UserRepository userRepository;


    public GameService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseModel getResult(String choice, Integer userId) {
        var userChoice = GameItems.getItem(choice);
        var computerChoice = GameItems.getRandomItem();
        var roundResult = compareItems(userChoice, computerChoice);

        return buildResult(roundResult , userChoice , computerChoice , userId);

    }

    private boolean compareItems(GameItems playerItem, GameItems computerItem) {
        if (playerItem == computerItem) {
            throw new RuntimeException("incorrect choice");
        } else return playerItem == GameItems.ROCK && computerItem == GameItems.SCISSORS ||
                playerItem == GameItems.PAPER && computerItem == GameItems.ROCK ||
                playerItem == GameItems.SCISSORS && computerItem == GameItems.PAPER;
    }

    private void updateScore(Integer userId, Integer score) {
        userRepository.updateScore(userId, score);
    }

    private ResponseModel buildResult(boolean result, GameItems playerItem, GameItems computerItem, Integer userId) {
        if (userRepository.checkUserId(userId) == null) {
            userRepository.addUser(userId);
        }
        var user = userRepository.getUser(userId);
        scoreHandler(result, user);
        var response = new ResponseModel();
        response.setPlayerItem(playerItem);
        response.setComputerItem(computerItem);
        response.setResult(result);
        response.setScore(userRepository.getUser(userId).getScore());
        response.setUserId(userId);
        response.setMessage(result ? "You win" : "You lose");
        return response;
    }

    private void scoreHandler(boolean result , User user) {
        if (result) {
            updateScore(user.getId(), user.getScore() + 100);
        } else {
            if (user.getScore() >= 100) {
                updateScore(user.getId(), user.getScore() - 100);
            }

        }
    }
}