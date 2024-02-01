package com.slimeheroes.game;

public class EndGame {
    private int endStoryIndex = 0;
    private String[] endStories = {"다음 스테이지로 넘어갑니다.\n스테이지를 클리어하여 스킬이 업그레이드 되었습니다.\n", "다음 스테이지로 넘어갑니다.\n스테이지를 클리어하여 스킬이 업그레이드 되었습니다.\n", "엠퍼러슬라임의 왕관을 챙겨 잡아마을로 돌아가자!\n====엠퍼러슬라임의 왕관 획득!====\n잡아마을로 돌아가는길...\n잡아마을 사람들의 환호 소리가 들려온다!!!\n와아아아아아아~\n잡아마을 광장에 [모험가]의 슬라임 영웅 동상이 세워졌다. \n [모험가]는 잡아마을의 슬라임 히어로가 되었다...\n축하드립니다. 게임을 클리어 하셨습니다!\n"};;

    public void endGame() {
        System.out.println(endStories[endStoryIndex]);
        endStoryIndex++;
    }
}