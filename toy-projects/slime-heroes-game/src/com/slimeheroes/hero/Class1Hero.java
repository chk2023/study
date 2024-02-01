package com.slimeheroes.hero;

import com.slimeheroes.slimes.Slimes;

public class Class1Hero extends Hero {
    int skillDamage;

    public Class1Hero(int skillDamage, int heroHp) {
        this.skillDamage = skillDamage;
        super.heroHp = heroHp;
    }

    @Override
    public void classSkill(Slimes slimes) {
        System.out.println("파워 슬래시가 적중했다!");
        slimes.setSlimeHp(slimes.getSlimeHp() - skillDamage);
    }

    @Override
    public void defend() {
        System.out.println("방어를 합니다. 몬스터의 데미지가 반감됩니다.");
    }

    @Override
    public int getHeroHp() {
        return super.heroHp;
    }

    @Override
    public void setHeroHp(int heroHp) {
        super.heroHp = heroHp;
    }


}
