package com.slimeheroes.game;
public class StartGame {
    private int startStoryIndex = 0;
    private String[] startStories = {"잡아 마을에 슬라임들이 자주 출몰해 마을사람들이 위험한 상황이다. 그때 어느 모험가 나타나 마을을 위해 나선다...\n[모험가]가 잡아 마을을 지키기 위해 마을 사람들의 환호를 받으며 슬라임 왕국으로 떠납니다!\n뚜벅 뚜벅...\nΣ(°ロ°) !?!!\n앗! 갑자기 슬라임이 나타났다!!!\n슬라임 : (+_+)? \n모든 몬스터는 일정 HP가 되면 자폭하니 잘 선택하고 \n전투를 준비하자!", "\n슬라임왕국으로 가는길...\n뚜벅.. 뚜벅..\n무언가 문을 지키고있다!\n문앞을 막고 있는 나이트슬라임을 상대해야한다!\n            ++++\n나이트슬라임 : (-_-)", "\n문을 연다...\n끼이이익..\n건방진 엠퍼러슬라임이 중앙에 앉아있다.\n              (*)(*)(*)\n엠퍼러슬라임 : ***( -_- )***"};

    public void startGame() {
        System.out.println(startStories[startStoryIndex]);
        startStoryIndex++;
    }
}
