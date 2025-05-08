package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

public class Knight implements Entity {

    private String name;
    private Weapon weapon;
    private Armor armor;
    private int hp;
    private int maxHP;
    private int mp;
    private int maxMP;
    private int manaCost;

    public Knight(String name, int hp, int mp, String weaponName, int weaponDamage, String armorName, int armorDefense , int manaCost) {
        this.name = name;
        this.hp = hp;
        this.maxHP = hp;
        this.mp = mp;
        this.maxMP = mp;
        this.weapon = new Weapon(weaponDamage, weaponName , manaCost);
        this.armor = new Armor(armorName, armorDefense);
    }

    public int health(int damage) {
        return hp - damage;
    }

    @Override
    public void attack(Entity target) {
        target.takeDamage(weapon.getDamage());
        System.out.println("player attacking");
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
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    @Override
    public void heal(int health) {
        hp += health;
        if (hp > maxHP) {
            hp = maxHP;
        }
    }

    @Override
    public void fillMana(int mana) {
        mp += mana;
        if (mp > maxMP) {
            mp = maxMP;
        }
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public int getMaxMP() {
        return maxMP;
    }

    @Override
    public int getHealth() {
        return hp;
    }


    @Override
    public void setHealth(int i) {

    }

    @Override
    public int getDefense() {
        return 0;
    }

    @Override
    public void setDefence(int i) {

    }

    @Override
    public void setDefense(int i) {

    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    private class baton{
        private String name;
        private int damage;

        public baton(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        public String getName() {
            return name;
        }

        public int getDamage() {
            return damage;
        }
    }

    private class Armor {
        private String name;
        private int defense;

        public Armor(String name, int defense) {
            this.name = name;
            this.defense = defense;
        }

        public String getName() {
            return name;
        }

        public int getDefense() {
            return defense;
        }
    }
}

