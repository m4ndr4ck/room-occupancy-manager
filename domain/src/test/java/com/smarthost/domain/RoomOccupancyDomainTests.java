package com.smarthost.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class RoomOccupancyDomainTests {

    CopyOnWriteArrayList<Customer> getCustomersMock() {
        CopyOnWriteArrayList<Customer> customers = new CopyOnWriteArrayList<>();
        Stream.of(new Integer[] {23, 45, 155, 374, 22, 99, 100, 101, 115, 209}).forEach(customerMoney ->
                customers.add(new Customer(customerMoney))
        );
        return customers;
    }

    @Test
    void getOccupancyTest1() {
        var room = new Room();

        HashMap<Room.Category, Integer> rooms = new HashMap<>();
        rooms.put(Room.Category.PREMIUM, 3);
        rooms.put(Room.Category.ECONOMY, 3);

        var customers = getCustomersMock();
        var occupancies = room.getOccupancy(customers, rooms);

        var premiumOccupancy = occupancies.get(Room.Category.PREMIUM);
        var economyOccupancy = occupancies.get(Room.Category.ECONOMY);

        assertTrue (premiumOccupancy.getTotalRooms() == 3 && premiumOccupancy.getTotalMoney() == 738);
        assertTrue (economyOccupancy.getTotalRooms() == 3 && economyOccupancy.getTotalMoney() == 167);
    }

    @Test
    void getOccupancyTest2() {
        var room = new Room();

        HashMap<Room.Category, Integer> rooms = new HashMap<>();
        rooms.put(Room.Category.PREMIUM, 7);
        rooms.put(Room.Category.ECONOMY, 5);

        var customers = getCustomersMock();
        var occupancies = room.getOccupancy(customers, rooms);

        var premiumOccupancy = occupancies.get(Room.Category.PREMIUM);
        var economyOccupancy = occupancies.get(Room.Category.ECONOMY);

        assertTrue (premiumOccupancy.getTotalRooms() == 6 && premiumOccupancy.getTotalMoney() == 1054);
        assertTrue (economyOccupancy.getTotalRooms() == 4 && economyOccupancy.getTotalMoney() == 189);
    }

    @Test
    void getOccupancyTest3() {
        var room = new Room();

        HashMap<Room.Category, Integer> rooms = new HashMap<>();
        rooms.put(Room.Category.PREMIUM, 2);
        rooms.put(Room.Category.ECONOMY, 7);

        var customers = getCustomersMock();
        var occupancies = room.getOccupancy(customers, rooms);

        var premiumOccupancy = occupancies.get(Room.Category.PREMIUM);
        var economyOccupancy = occupancies.get(Room.Category.ECONOMY);

        assertTrue (premiumOccupancy.getTotalRooms() == 2 && premiumOccupancy.getTotalMoney() == 583);
        assertTrue (economyOccupancy.getTotalRooms() == 4 && economyOccupancy.getTotalMoney() == 189);
    }

    @Test
    void getOccupancyTest4() {
        var room = new Room();

        HashMap<Room.Category, Integer> rooms = new HashMap<>();
        rooms.put(Room.Category.PREMIUM, 7);
        rooms.put(Room.Category.ECONOMY, 1);

        var customers = getCustomersMock();
        var occupancies = room.getOccupancy(customers, rooms);

        var premiumOccupancy = occupancies.get(Room.Category.PREMIUM);
        var economyOccupancy = occupancies.get(Room.Category.ECONOMY);

        assertTrue (premiumOccupancy.getTotalRooms() == 7 && premiumOccupancy.getTotalMoney() == 1153);
        assertTrue (economyOccupancy.getTotalRooms() == 1 && economyOccupancy.getTotalMoney() == 45);
    }

}
