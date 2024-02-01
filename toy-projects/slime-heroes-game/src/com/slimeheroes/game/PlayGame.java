package com.slimeheroes.game;

import com.slimeheroes.hero.Hero;
import com.slimeheroes.slimes.Slimes;

import java.util.Scanner;

public class PlayGame {
    EndGame endGame = new EndGame();

    public void playGame(Hero hero, Slimes slimes) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("다음 행동을 선택해주세요. \n 1.공격 2.방어");
                int action = sc.nextInt();

                /* 영웅 차례 */
                HeroBattle(action, hero, slimes);

                /* 몬스터 차례 */
                MonsterBattle(action, hero, slimes);

                if (slimes.getSlimeHp() <= 0) {
                    break;
                } else if (hero.getHeroHp() <= 0) {
                    System.out.println("GAME OVER");
                    System.exit(0);
                }
            }
            endGame.endGame();
            break;
        }
    }


    private void HeroBattle(int action, Hero hero, Slimes slimes) {
        if (action == 1) {
            hero.classSkill(slimes);
        } else if (action == 2) {
            hero.defend();
        }
    }

    private void MonsterBattle(int action, Hero hero, Slimes slimes) {
        if (action == 1) {
            slimes.attack(hero);
            if (slimes.getSlimeHp() >= 1) {
                System.out.println("영웅 잔여 HP : " + hero.getHeroHp() + "\n몬스터 잔여 Hp : " + slimes.getSlimeHp() + "\n");
            } else {
                System.out.println("영웅 잔여 HP : " + hero.getHeroHp() + "\n몬스터 잔여 Hp : 0 " + "\n");
            }
            if (slimes.getSlimeHp() <= 100) {
                slimes.finalattack(hero);
            }
        } else if (action == 2) {
            slimes.halfDamageAttack(hero);
            if (slimes.getSlimeHp() >= 1) {
                System.out.println("영웅 잔여 HP : " + hero.getHeroHp() + "\n몬스터 잔여 Hp : " + slimes.getSlimeHp() + "\n");
            } else {
                System.out.println("영웅 잔여 HP : " + hero.getHeroHp() + "\n몬스터 잔여 Hp : 0 " + "\n");
            }
        }
    }
}



