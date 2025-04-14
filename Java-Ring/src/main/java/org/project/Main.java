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
        int damage1;
        int damage2;
        int def ;
        int health1;
        int health2;

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
                damage1 = 5;
                def = 5;
                health1 = 50;
                break;
            case 2:
                System.out.println("You chose Knight!");
                player = new Knight("Player", 50, 50, "baton", 6, "shield", 5, 10);
                damage1 = 6;
                def = 5;
                health1 = 50;
                break;
            case 3:
                System.out.println("You chose Assassin!");
                player = new Assassin("Player", 50, 50, "baton", 7, "shield", 5);
                damage1 = 7;
                def = 5;
                health1 = 50;
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
                damage2 = 7;
                health2 = 45;
                break;
            case 2:
                System.out.println("You chose Goblin!");
                enemy = new Goblin(47, 47, new Weapon(8, "Horror", 12));
                damage2 = 8;
                health2 = 47;
                break;
            case 3:
                System.out.println("You chose Dragon!");
                enemy = new Dragon(48, 48, new Weapon(9, "fire", 14));
                damage2 = 9;
                health2 = 48;
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
            System.out.println("write Attack to attack enemy");
            Scanner read = new Scanner(System.in);
            String notif = read.nextLine();
            if (notif.equals("Attack")) {
                System.out.println(name + " attacks!");
                health2 -= damage1;
                System.out.println("Enemy takes damage!");
            }
            if (health2 <= 0) {
                System.out.println("Enemy is dead!");
                break;
            }

            System.out.println("Enemy attacks!");
            System.out.println("input d to defence");
            String D = read.nextLine();
            if (D.equals("d")){
                System.out.println(name + " deffend attack");
            health1 -= damage2 - def;
        }
            else {
                System.out.println(name + " takes damage!");
                health1 -= damage2 ;}
                if (health1 <= 0) {
                    System.out.println(name + " is dead!");
                    break;
                }

                System.out.println("Player health: " + health1);
                System.out.println("Enemy health: " + health2);
            }

            System.out.println("Game Over!");
        }
    }


