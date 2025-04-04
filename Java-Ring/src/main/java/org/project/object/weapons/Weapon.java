package org.project.object.weapons;

import org.project.entity.Entity;
import org.project.object.Object;

public class Weapon implements Object {
    private int damage;
    private int manaCost;
    private String name;
    private int health;

    public Weapon(int damage, String weaponName, int manaCost) {
        this.damage = damage;
        this.manaCost = manaCost;
    }

    public Weapon(int damage, int manaCost, String name, int health, int abilityCharge) {
    }

    @Override
    public void use(Entity target) {
        target.takeDamage(damage);
    }

    @Override
    public void heal(Entity target) {

    }

    @Override
    public boolean ArmorBreak() {
        return false;
    }

    public int getDamage() {
        int health = this.health;
        int damage = this.damage;
        return health - damage;
    }

    public int getManaCost() {
        return manaCost;
    }

}
