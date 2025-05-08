package org.project.object.armors;

import org.project.entity.Entity;
import org.project.object.Object;

public abstract class Armor implements Object {
    private int defense;
    private int maxDefense;
    private int durability;
    private int maxDurability;
    private int health;

    private boolean isBroke;


    public Armor(int defense, int durability, int maxDefense, int maxDurability) {
    this.defense = defense;
    this.durability = durability;
    this.maxDefense = maxDefense;
    this.maxDurability = maxDurability;
    }

    public void checkBreak() {
        if (durability <= 0) {
            isBroke = true;
            defense = 0;
        }
    }

    public void repair() {
        isBroke = false;
        while ( defense < maxDefense ) {
        defense += 1;
        if(defense == maxDefense) {
        defense = maxDefense;}
        }
        durability = maxDurability;
    }

    public int getDefense() {
        return defense;
    }

    public int getDurability() {
        return durability;
    }

    public boolean isBroke() {
        return isBroke;
    }
    @Override
    public void use(Entity target) {
        target.heal(target.getMaxHP() / 10);
    }

    @Override
    public void heal(Entity target) {

    }


}
