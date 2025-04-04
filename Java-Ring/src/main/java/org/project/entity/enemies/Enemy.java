package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

public abstract class Enemy implements Entity {
    Weapon weapon;
    private int hp;
    private int mp;
    Armor armor;
    public Enemy(int hp, int mp, Weapon weapon) {
        this.hp = hp;
        this.mp = mp;

        this.weapon = weapon;
    }
    @Override
    public void takeDamage(int damage) {
        int finalDamage = damage - this.getDefense();
        if (finalDamage < 0) finalDamage = 0;
        hp -= finalDamage;
        if (hp < 0) hp = 0;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public void defend() {
        int defenseBonus = armor.getDefense();
        int damageReduction = defenseBonus / 2;
        int totalDamage = 10;
        int reducedDamage = totalDamage - damageReduction;
        if (reducedDamage < 0) {
            reducedDamage = 0;
        }
        this.takeDamage(reducedDamage);
    }
}
