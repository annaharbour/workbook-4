package com.pluralsight;

import com.pluralsight.model.Employee;
import com.pluralsight.model.Hotel;
import com.pluralsight.model.Reservation;
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

        // Test Reservation class
        Reservation reservation = new Reservation("king", 3, 139.00f, true);
        System.out.printf("\nReservation Room Type: %s", reservation.getRoomType());
        System.out.printf("\nReservation Total: $%.2f", reservation.getReservationTotal());

        // Test Employee class
        Employee employee = new Employee("007", "James Bond", "MI6", 20.00f, 45, 40);
        System.out.printf("\nEmployee Total Pay: $%.2f\n", employee.getTotalPay());
        System.out.println(employee);

        //Test Hotel class
        Hotel hotel = new Hotel(200, 20, "The Carlisle");
        Hotel motel = new Hotel(300, 5, 50, 0, "Motel 6");
        System.out.println("Hotel's available suites:" + hotel.getAvailableSuites());
        System.out.println("Motel's available suites:" + motel.getAvailableSuites());
        System.out.println(hotel);
        System.out.println(motel);
    }
}
