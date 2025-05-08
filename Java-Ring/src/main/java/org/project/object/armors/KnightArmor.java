package org.project.object.armors;

import org.project.entity.Entity;

public class KnightArmor extends Armor {
    private int defense;
    private int maxDefense;
    private int durability;
    private int maxDurability;
    private int health;

    private boolean isBroke;


    public KnightArmor(int defense, int durability, int maxDefense, int maxDurability) {
        super(defense, durability, maxDefense, maxDurability);
    }

    @Override
    public void use(Entity target) {
        super.use(target);
        if (target.getDefense() > 0 && !this.isBroke()) {
            target.setDefense(target.getDefense() + 15);
            target.setHealth(target.getDefense() - 15);
        }
    }

    public void checkBreak() {
        if (durability <= 0) {
            isBroke = true;
            defense = 0;
        }
    }

    public void repair() {
        isBroke = false;
        while (defense < maxDefense) {
            defense += 1;
            if (defense == maxDefense) {
                defense = maxDefense;
            }
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
    public void heal(Entity target) {
        target.setHealth(target.getHealth() - 10);
        if (target.getHealth() <= 0) {
            target.setHealth(0);
            System.out.println("Target is dead!");
        }
    }

    @Override
    public boolean ArmorBreak() {
        if (isBroke) {
            return true;
        }
        return false;
    }

}
