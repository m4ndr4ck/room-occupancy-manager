package com.smarthost.domain;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class Room {

    public enum Category {
        PREMIUM,
        ECONOMY,
    }

    public static HashMap<Category, Occupancy> getOccupancy(CopyOnWriteArrayList<Customer> customers, HashMap<Category, Integer> rooms) {

        HashMap<Category, Occupancy> occupancies = new HashMap<>();

        var categoryStream = EnumSet.allOf(Category.class).stream();
        var premiumRooms = rooms.get(Category.PREMIUM);
        var economyRooms = rooms.get(Category.ECONOMY);
        var totalCustomers = customers.size();

        var orderedStream = getOrderedStream(categoryStream, premiumRooms, economyRooms,totalCustomers);

        orderedStream.forEach(category -> {
            var occupancy = Usage
                    .getUsageStrategy(category)
                    .execute(customers, rooms.get(category));
            occupancies.put(category, occupancy);
        });

        return  occupancies;
    }

    private static Stream<Category> getOrderedStream(Stream<Category> categoryStream, int premiumRooms, int freeRooms, int totalCustomers){
        return (premiumRooms+freeRooms>totalCustomers) ?
                categoryStream.sorted(Comparator.reverseOrder()) :
                categoryStream.sorted(Comparator.naturalOrder());
    }
}

