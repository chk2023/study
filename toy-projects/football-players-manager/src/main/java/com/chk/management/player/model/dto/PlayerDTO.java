package com.chk.management.player.model.dto;

public class PlayerDTO {
    private int playerId;
    private String playerName;
    private String playerNumber;
    private String playerPosition;
    private String playerHeight;
    private String playerWeight;
    private String playerStat;

    public PlayerDTO() {
    }

    public PlayerDTO(int playerId, String playerName, String playerNumber, String playerPosition, String playerHeight,
                     String playerWeight, String playerStat) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerNumber = playerNumber;
        this.playerPosition = playerPosition;
        this.playerHeight = playerHeight;
        this.playerWeight = playerWeight;
        this.playerStat = playerStat;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getPlayerHeight() {
        return playerHeight;
    }

    public void setPlayerHeight(String playerHeight) {
        this.playerHeight = playerHeight;
    }

    public String getPlayerWeight() {
        return playerWeight;
    }

    public void setPlayerWeight(String playerWeight) {
        this.playerWeight = playerWeight;
    }

    public String getPlayerStat() {
        return playerStat;
    }

    public void setPlayerStat(String playerStat) {
        this.playerStat = playerStat;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", playerNumber='" + playerNumber + '\'' +
                ", playerPosition='" + playerPosition + '\'' +
                ", playerHeight='" + playerHeight + '\'' +
                ", playerWeight='" + playerWeight + '\'' +
                ", playerStat='" + playerStat + '\'' +
                '}';
    }
}
