package com.slimeheroes.slimes;

import com.slimeheroes.hero.Hero;

public abstract class Slimes {
    public abstract void attack(Hero hero);
    public abstract void halfDamageAttack(Hero hero);

    public abstract int getSlimeHp();

    public abstract void setSlimeHp(int slimeHp);

    public void finalattack(Hero hero) {
    }
}
