package com.example.assignment4_rida_aftab;

import androidx.annotation.NonNull;

import java.util.Random;

public class Player {

    private int _id;
    String playerName;

    String playerPosition;

    int numOfGoals;


    public Player(int playerId, String playerName, String playerPosition, int numOfGoals) {
        this._id = playerId;
        this.playerName = playerName;
        this.playerPosition = playerPosition;
        this.numOfGoals = numOfGoals;
    }


    @NonNull
    @Override
    public String toString() {

         String info =  _id + " " + playerName + " " + playerPosition + numOfGoals;
         return info;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getNumOfGoals() {
        return numOfGoals;
    }

    public void setNumOfGoals(int numOfGoals) {
        this.numOfGoals = numOfGoals;
    }
}
