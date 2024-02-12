package com.chk.management.player.controller;

import com.chk.common.SearchCondition;
import com.chk.management.player.model.dto.PlayerDTO;
import com.chk.management.player.model.service.PlayerService;
import com.chk.management.player.view.PlayerPrint;

import java.util.List;
import java.util.Map;

public class PlayerController {
    private PlayerService playerService = new PlayerService();
    private PlayerPrint playerPrint = new PlayerPrint();

    public void selectAllPlayerList() {
        List<PlayerDTO> playerList = playerService.selectAllPlayerList();

        if (playerList != null) {
            playerPrint.printAllPlayerList(playerList);
        } else {
            playerPrint.printErrorMessage("selectAllList");
        }
    }

    public void selectPlayerByCondition(SearchCondition searchCondition) {
        List<PlayerDTO> player = playerService.selectPlayerBycondition(searchCondition);

        if (player != null) {
            playerPrint.printPlayerList(player, searchCondition);
        } else {
            playerPrint.printErrorMessage("selectList");
        }
    }

    public void registNewPlayer(PlayerDTO player) {
        boolean newPlayer = playerService.registNewPlayer(player);

        if (newPlayer) {
            playerPrint.printSuccessMessage("registNewPlayer");
        } else {
            playerPrint.printErrorMessage("registNewPlayer");
        }
    }

    public void modifyPlayerInfo(PlayerDTO player) {
        boolean modifyPlayer = playerService.modifyPlayerInfo(player);

        if (modifyPlayer) {
            playerPrint.printSuccessMessage("modifyPlayer");
        } else {
            playerPrint.printErrorMessage("modifyPlayer");
        }
    }

    public void deletePlayer(Map<String, String> parameter) {
        boolean deletePlayer = playerService.deletePlayer(parameter);

        if (deletePlayer) {
            playerPrint.printSuccessMessage("deleteProduct");
        } else {
            playerPrint.printErrorMessage("deleteProduct");
        }
    }
}
