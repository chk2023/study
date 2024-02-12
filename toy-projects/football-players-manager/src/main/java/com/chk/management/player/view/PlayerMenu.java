package com.chk.management.player.view;

import com.chk.common.SearchCondition;
import com.chk.management.player.controller.PlayerController;
import com.chk.management.player.model.dto.PlayerDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayerMenu {
    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        PlayerController playerController = new PlayerController();

        do {
            System.out.println("====== 선수 정보 관리 ======");
            System.out.println("선수 정보 관리 화면입니다.");
            System.out.println("==========================");
            System.out.println("1. 전체 선수 정보 조회");
            System.out.println("2. 조건부 선수 정보 조회");
            System.out.println("3. 신규 선수 정보 등록");
            System.out.println("4. 기존 선수 정보 수정");
            System.out.println("5. 선수 정보 삭제");
            System.out.println("9. 이전 메뉴로 이동");
            System.out.println("===========================");
            System.out.println("원하는 관리 메뉴의 번호를 입력해 주세요 : ");
            int selectMenu = sc.nextInt();

            switch (selectMenu) {
                case 1 : playerController.selectAllPlayerList(); break;
                case 2 : playerController.selectPlayerByCondition(inputSearchCondition()); break;
                case 3 : playerController.registNewPlayer(inputNewPlayerInfo()); break;
                case 4 : playerController.modifyPlayerInfo(inputModifyPlayerInfo()); break;
                case 5 : playerController.deletePlayer(inputPlayerCode()); break;
                case 9 : System.out.println("====== 상위 메뉴로 이동합니다. ======"); return;
                default : System.out.println("잘못된 번호입니다. 확인 후 다시 입력해 주세요."); break;
            }
        } while (true);
    }

    private static SearchCondition inputSearchCondition() {
        Scanner sc = new Scanner(System.in);
        String searchOption = "";
        String searchValue = "";

        System.out.println("===========================");
        System.out.println("조회하고 싶은 조건을 선택하세요. ");
        System.out.println("===========================");
        System.out.println("1. 선수명으로 조회");
        System.out.println("2. 선수 번호로 조회");
        System.out.println("3. 선수 포지션으로 조회");
        System.out.println("===========================");
        System.out.println("원하는 조건의 번호를 입력해 주세요 : ");
        int selectMenu = sc.nextInt();

        switch (selectMenu) {
            case 1 :
                sc.nextLine();
                searchOption = "playerName";
                System.out.println("조회할 선수명을 입력해 주세요 : ");
                searchValue = sc.nextLine();
                break;
            case 2 :
                sc.nextLine();
                searchOption = "playerNumber";
                System.out.println("조회할 선수의 번호를 입력해 주세요 : ");
                searchValue = sc.nextLine();
                break;
            case 3 :
                sc.nextLine();
                searchOption = "playerPosition";
                System.out.println("조회할 선수의 포지션을 입력해 주세요 : ");
                searchValue = sc.nextLine();
                break;
            case 9 : System.out.println("====== 상위 메뉴로 이동합니다. ======"); return null;
            default : System.out.println("잘못된 번호입니다. 확인 후 다시 입력해 주세요."); break;
        }
        SearchCondition searchCondition = new SearchCondition(searchOption, searchValue);
        return searchCondition;
    }

    private static PlayerDTO inputNewPlayerInfo() {
        System.out.println("==============================");
        System.out.println("등록할 새로운 선수 정보를 입력하세요.");
        System.out.println("==============================");
        PlayerDTO playerDTO = new PlayerDTO();
        getPlayerInfo(playerDTO);
        System.out.println("==============================");

        return playerDTO;
    }

    private static PlayerDTO getPlayerInfo(PlayerDTO playerDTO) {
        Scanner sc = new Scanner(System.in);

        System.out.println("선수명을 입력해 주세요 : ");
        String playerName = sc.nextLine();
        System.out.println("선수의 번호를 입력해 주세요 : ");
        String playerNumber = sc.nextLine();
        System.out.println("선수의 포지션을 입력해 주세요 : ");
        String playerPosition = sc.nextLine();
        System.out.println("선수의 신장을 입력해 주세요 : ");
        String playerHeight = sc.nextLine();
        System.out.println("선수의 체중을 입력해 주세요 : ");
        String playerWeight = sc.nextLine();
        System.out.println("선수의 능력치를 입력해 주세요 : ");
        String playerStat = sc.nextLine();

        playerDTO.setPlayerName(playerName);
        playerDTO.setPlayerNumber(playerNumber);
        playerDTO.setPlayerPosition(playerPosition);
        playerDTO.setPlayerHeight(playerHeight);
        playerDTO.setPlayerWeight(playerWeight);
        playerDTO.setPlayerStat(playerStat);

        return playerDTO;
    }

    private static PlayerDTO inputModifyPlayerInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("수정할 선수 정보를 입력하세요.");
        System.out.println("수정 대상 선수 아이디를 입력해 주세요 : ");
        int playerId = sc.nextInt();

        PlayerDTO playerDTO = new PlayerDTO();

        playerDTO.setPlayerId(playerId);

        getPlayerInfo(playerDTO);

        System.out.println("==================================");

        return playerDTO;
    }

    private static Map<String, String> inputPlayerCode() {
        Scanner sc = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("삭제할 선수의 아이디를 입력해 주세요 : ");
        String playerId = sc.nextLine();
        System.out.println("==================================");

        Map<String, String> parameter = new HashMap<>();
        parameter.put("playerId", playerId);
        return parameter;
    }
}
