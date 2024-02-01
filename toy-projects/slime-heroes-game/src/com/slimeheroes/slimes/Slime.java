package com.slimeheroes.slimes;

import com.slimeheroes.hero.Hero;

public class Slime extends Slimes{
int slimeHp;
int slimeDamage;

    public Slime(int slimeDamage, int slimeHp) {
        this.slimeDamage = slimeDamage;
        this.slimeHp = slimeHp;
    }

    @Override
    public void finalattack(Hero hero) {
        if (getSlimeHp() <= 2 && getSlimeHp() >= 0) {
            System.out.println("몬스터가 생명의 위협을 느껴 자폭을 합니다!");
            hero.setHeroHp(hero.getHeroHp() - (slimeDamage * 40));
        }
    }

    @Override
    public void attack(Hero hero) {
        if (getSlimeHp() >= 1){
            System.out.println("몬스터가 공격을 했다!\n");
            hero.setHeroHp(hero.getHeroHp()-slimeDamage);
        } else {
            System.out.println("몬스터가 처치되었습니다.\n");
        }
    }

    @Override
    public void halfDamageAttack(Hero hero) {
        System.out.println("몬스터가 공격을 했다!\n방어에 성공했다.\n");
        hero.setHeroHp(hero.getHeroHp()-(slimeDamage/2));
        if (getSlimeHp() <= 1){setSlimeHp(getSlimeHp()-100);}
    }

    @Override
    public int getSlimeHp() {
        return slimeHp;
    }

    public void setSlimeHp(int slimeHp) {
        this.slimeHp = slimeHp;
    }

}
