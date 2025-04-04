package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.weapons.Weapon;

public class Dragon extends Enemy{
    Weapon weapon;
    private int hp;
    private int mp;
    Armor armor;

    public Dragon(int hp, int mp, Weapon weapon) {
        super(hp, mp, weapon);
    }

    @Override
    public void defend(){
        int defenseBonus = armor.getDefense();
        int damageReduction = defenseBonus / 2;
        int totalDamage = 10;
        int reducedDamage = totalDamage - damageReduction;
        if (reducedDamage < 0) {
            reducedDamage = 0;
        }
        this.takeDamage(reducedDamage);
    }

    void takedamage(int damage) {
        super.takeDamage(damage);
    }

    public int health(int damage) {
        return hp - damage;
    }

    @Override
    public void attack(Entity target) {
        target.takeDamage(weapon.getDamage());
        System.out.println("Attacking player");
    }

    @Override
    public void heal(int health) {
        health = health + 1;
    }

    @Override
    public void fillMana(int mana) {

    }

    @Override
    public int getMaxHP() {
        return 0;
    }
    @Override
    public int getMaxMP() {
        return 0;
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

    private class fire{
        private String name;
        private int damage;

        public fire(String name, int damage) {
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
