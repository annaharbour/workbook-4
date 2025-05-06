package com.pluralsight;

import com.pluralsight.model.Room;

public class Main {
    public static void main(String[] args) {
        Room room101 = new Room(2, 200.00f, true, true);
        System.out.println(room101.isAvailable());
        Room room102 = new Room(2, 200.00f, false, false);
        System.out.println(room102.isAvailable());
        Room room103 = new Room(2, 200.00f, false, true);
        System.out.println(room103.isAvailable());
        Room room104 = new Room(2, 200.00f, true, false);
        System.out.println(room104.isAvailable());
    }
}