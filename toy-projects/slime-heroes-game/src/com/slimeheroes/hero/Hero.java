package com.slimeheroes.hero;

import com.slimeheroes.slimes.Slimes;

public abstract class Hero {
    int heroHp = 100;

    public abstract void classSkill(Slimes slimes);

    public abstract void defend();

    public abstract int getHeroHp();

    public abstract void setHeroHp(int heroHp);
}
