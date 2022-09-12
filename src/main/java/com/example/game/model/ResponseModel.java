package com.example.game.model;

import lombok.Data;

@Data
public class ResponseModel {
    private boolean result;
    private String message;
    private Integer score;
    private GameItems playerItem;
    private GameItems computerItem;
    private Integer userId;
}
