package org.project;
import java.util.ArrayList;
import java.util.List;
public class Location {

        private String name;
        private String description;

        public Location(String name, String description) {
            this.name = name;
            this.description = description;
        }


        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "Location{name='" + name + "', description='" + description + "'}";
        }
    }



