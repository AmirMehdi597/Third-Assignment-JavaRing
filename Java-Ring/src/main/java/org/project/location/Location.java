package org.project.location;

import org.project.entity.enemies.Enemy;

import java.util.ArrayList;
import java.util.Scanner;

public class Location {
    private String name;

    private ArrayList<Location> locations;
    private ArrayList<Enemy> enemies;

    public Location(ArrayList<Location> locations, ArrayList<Enemy> enemies) {
        this.locations = locations;
        this.enemies = enemies;
    }
    public Location chooseLocation() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < locations.size(); i++) {
            System.out.println(i + 1 + ". " + locations.get(i).getName());
        }
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= locations.size()) {
            return locations.get(choice - 1);  // Return the selected location
        } else {
            System.out.println("Invalid choice, please try again.");
            return chooseLocation();
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    }
