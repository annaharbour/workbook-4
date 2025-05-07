package com.pluralsight;

import com.pluralsight.model.Employee;
import com.pluralsight.model.Hotel;
import com.pluralsight.model.Reservation;
import com.pluralsight.model.Room;

import java.time.LocalDateTime;

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
        room104.checkIn();
        room104.checkOut();
        room104.checkIn();

        // Test Reservation class
        Reservation reservation = new Reservation("king", 3, true);
        System.out.printf("\nReservation Total: $%.2f", reservation.getReservationTotal());

        // Test Employee class
        Employee employee = new Employee("007", "James Bond", "MI6", 20.00f);
        System.out.printf("\nEmployee Total Pay: $%.2f\n", employee.getTotalPay());
        System.out.println(employee);
        employee.punchTimeCard(LocalDateTime.now(), LocalDateTime.now().plusHours(10));
        employee.punchTimeCard(LocalDateTime.now(), LocalDateTime.now().plusHours(10));
        employee.punchTimeCard(LocalDateTime.now(), LocalDateTime.now().plusHours(10));
        System.out.printf("\nEmployee Total Pay: $%.2f\n", employee.getTotalPay());
        employee.punchTimeCard(LocalDateTime.now(), LocalDateTime.now().plusHours(10));
        employee.punchTimeCard(LocalDateTime.now(), LocalDateTime.now().plusHours(10));
        System.out.printf("\nEmployee Total Pay: $%.2f\n", employee.getTotalPay());


        //Test Hotel class
        Hotel hotel = new Hotel(20, 5, "The Carlisle");
        Hotel motel = new Hotel(30, 5, 4, 0, "Motel 6");
        System.out.println(hotel);
        System.out.println(motel);
//        will book rooms
        hotel.bookRoom(2, false);
//        will not book rooms because not enough suites
        motel.bookRoom(6, true);
        System.out.println(hotel);
        System.out.println(motel);
    }
}
