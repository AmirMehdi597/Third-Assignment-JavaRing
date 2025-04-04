package org.project.object.consumables;

import org.project.entity.Entity;

public class Flask extends Consumable {
    private  int health;
    private  int Bullet;
    @Override
    public void use(Entity target) {
        target.heal(target.getMaxHP() / 10);
    }

    @Override
    public void ExtraDamage(Entity target) {
        int health = this.health;
        health -= 20;
        if(health <= 0){
            health = 0;
            System.out.println("you are dead");
        }
    }

    @Override
    public void heal(Entity target) {
        int health = this.health;
        health += 20;
    }

    @Override
    public boolean ArmorBreak() {
        return false;
    }

    public void addbullet(Entity target) {
        int bullet = this.Bullet;
        bullet += 10;
    }
}
