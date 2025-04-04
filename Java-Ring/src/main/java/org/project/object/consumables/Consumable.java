package org.project.object.consumables;

import org.project.entity.Entity;
import org.project.object.Object;

public abstract class Consumable implements Object {
   private int health;

   public void use(Entity target) {
      target.heal(target.getMaxHP() / 10);
   }

   public void ExtraDamage(Entity target) {
   int health = this.health;
   health -= 10;
   if (health <= 0) {
      health = 0;
      System.out.println("You are dead!");
   }
   }

   public void heal(Entity target) {
      int health = this.health;
      health += 10;
   }
}
