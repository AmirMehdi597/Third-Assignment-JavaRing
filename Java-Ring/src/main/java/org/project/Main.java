package org.project;
import org.project.entity.Entity;
import org.project.entity.enemies.Dragon;
import org.project.entity.enemies.Goblin;
import org.project.entity.enemies.Skeleton;
import org.project.entity.players.Assassin;
import org.project.entity.players.Knight;
import org.project.entity.players.Wizzard;
import org.project.object.weapons.Weapon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the game");

        System.out.println("Choose your map:");
        System.out.println("1 - Forest");
        System.out.println("2 - Castle");
        System.out.println("3 - Village");
        System.out.println("4 - Desert");
        System.out.println("5 - Mountain");

        Scanner in = new Scanner(System.in);
        int y = in.nextInt();
        String selectedLocation = "";
        switch (y) {
            case 1:
                selectedLocation = "Forest";
                break;
            case 2:
                selectedLocation = "Castle";
                break;
            case 3:
                selectedLocation = "Village";
                break;
            case 4:
                selectedLocation = "Desert";
                break;
            case 5:
                selectedLocation = "Mountain";
                break;
            default:
                System.out.println("Invalid selection.");
                return;
        }
        System.out.println("You chose: " + selectedLocation);

        System.out.println("Choose your player:");
        System.out.println("1 - Wizzard");
        System.out.println("2 - Knight");
        System.out.println("3 - Assassin");
        int e = in.nextInt();
        Entity player = null;
        switch (e) {
            case 1:
                System.out.println("You chose Wizzard!");
                player = new Wizzard("Player", 50, 50, "lightning", 5, "Separ", 5, 10);
                break;
            case 2:
                System.out.println("You chose Knight!");
                player = new Knight("Player", 50, 50, "baton", 6, "shield", 5, 10);
                break;
            case 3:
                System.out.println("You chose Assassin!");
                player = new Assassin("Player", 50, 50, "baton", 7, "shield", 5);
                break;
            default:
                System.out.println("Invalid player choice.");
                return;
        }

        System.out.println("Choose your enemy:");
        System.out.println("1 - Skeleton");
        System.out.println("2 - Goblin");
        System.out.println("3 - Dragon");
        int f = in.nextInt();
        Entity enemy = null;
        switch (f) {
            case 1:
                System.out.println("You chose Skeleton!");
                enemy = new Skeleton(45, 45, new Weapon(7, "fear", 10));
                break;
            case 2:
                System.out.println("You chose Goblin!");
                enemy = new Goblin(60, 60, new Weapon(8,"Horror", 12));
                break;
            case 3:
                System.out.println("You chose Dragon!");
                enemy = new Dragon(75, 75, new Weapon(9, "fire", 14));
                break;
            default:
                System.out.println("Invalid enemy choice.");
                return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("please write your name");
        String name = input.nextLine();
        System.out.println("Game start!");
        while (true) {
            System.out.println(name +" attacks!");
            player.attack(enemy);
            enemy.takeDamage(15);
            System.out.println("Enemy takes damage!");

            if (enemy.getHealth() <= 0) {
                System.out.println("Enemy is dead!");
                break;
            }

            System.out.println("Enemy attacks!");
            enemy.attack(player);
            player.takeDamage(12);
            System.out.println(name +" takes damage!");

            if (player.getHealth() <= 0) {
                System.out.println( name +" is dead!");
                break;
            }

            System.out.println( name +" defends!");
            player.defend();

            System.out.println("Player health: " + player.getDefense());
            System.out.println("Enemy health: " + enemy.getDefense());
        }

        System.out.println("Game Over!");
    }
}
