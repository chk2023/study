package com.chk.management.player.view;

import com.chk.common.SearchCondition;
import com.chk.management.player.model.dto.PlayerDTO;

import java.util.List;

public class PlayerPrint {
    public void printAllPlayerList(List<PlayerDTO> playerList) {
        System.out.println("====== 선수 목록 ======");
        for (PlayerDTO player : playerList) {
            System.out.println(player);
        }
    }

    public void printErrorMessage(String errorCode) {
        System.out.println("====== Error ======");
        String errorMessage = "";
        
        switch (errorCode) {
            case "selectAllList" :
                errorMessage = "선수 목록 조회에 실패하였습니다."; break;
            case "selectList" :
                errorMessage = "선수 조회에 실패하였습니다."; break;
            case "registNewPlayer" :
                errorMessage = "선수 추가에 실패하였습니다."; break;
            case "modifyPlayerInfo" :
                errorMessage = "선수 수정에 실패하였습니다."; break;
            case "deletePlayer" :
                errorMessage = "선수 삭제에 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
        }

    public void printPlayerList(List<PlayerDTO> playerList, SearchCondition searchCondition) {
        System.out.println("====== 선수 조회 ======");
        System.out.println(searchCondition.toString());
        for (PlayerDTO player : playerList) {
            System.out.println(player);
        }
    }

    public void printSuccessMessage(String successCode) {
        System.out.println("====== Success ======");
        String successMessage = "";

        switch (successCode) {
            case "registNewPlayer" :
                successMessage = "선수 추가에 성공하였습니다."; break;
            case "modifyPlayer" :
                successMessage = "선수 수정에 성공하였습니다."; break;
            case "deletePlayer" :
                successMessage = "선수 삭제에 성공하였습니다."; break;
        }
        System.out.println(successMessage);
    }
}
