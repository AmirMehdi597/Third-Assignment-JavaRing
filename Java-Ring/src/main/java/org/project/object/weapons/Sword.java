package org.project.object.weapons;

import org.project.entity.Entity;

import java.util.ArrayList;

public class Sword extends Weapon {
    private int damage;
    private int manaCost;
    private String name;
    private int health;

    int abilityCharge;

    public Sword(int  damage, int manaCost, String name, int health , int abilityCharge) {
        super(damage , manaCost , name , health , abilityCharge);
    }

    public void uniqueAbility(ArrayList<Entity> targets) {
        abilityCharge += 2;
        int targethealth;
        for (Entity target : targets) {
            target.takeDamage(getDamage());
            if (target.getHealth() <= 0) {
                targethealth = 0;
                System.out.println("target is dead");
            }
        }
    }

    public int getDamage(Entity target) {
        target.takeDamage(getDamage());
        return target.getHealth();
    }
}
