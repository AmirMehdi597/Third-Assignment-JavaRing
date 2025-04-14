package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

public abstract class Player implements Entity {
    protected String name;
    Weapon weapon;
    Armor armor;
    private int maxHP;
    private int mp;
    private int maxMP;

    public Player(String name, int hp, int mp, Weapon weapon, Armor armor) {
        this.name = name;
        this.mp = mp;

        this.weapon = weapon;
        this.armor = armor;
    }

    @Override
    public void attack(Entity target) {
        target.takeDamage(weapon.getDamage());
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

    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public void heal(int health) {

    }

    @Override
    public void fillMana(int mana) {
        mp += mana;
        if (mp > maxMP) {
            mp = maxMP;
        }
    }


    public String getName() {
        return name;
    }

    public int getHp() {
        return 0;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    public int getMp() {
        return mp;
    }

    @Override
    public int getMaxMP() {
        return maxMP;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }
}
