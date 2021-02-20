package com.smarthost.domain.strategy;

import com.smarthost.domain.Customer;
import com.smarthost.domain.Occupancy;
import com.smarthost.domain.Room;

import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class EconomyUsageStrategy implements UsageStrategy {

    final int THRESHOLD = 100;

    @Override
    public Occupancy getOccupancy(CopyOnWriteArrayList<Customer> customers, int rooms, Room.Category category) {
        var totalRooms = new AtomicInteger();
        int totalEconomyMoney = customers.stream()
                .sorted(Comparator.comparingInt(Customer::getCustomerMoney).reversed())
                .filter(customer->customer.getCustomerMoney()<THRESHOLD)
                .limit(rooms)
                .map(customer -> {
                    customers.remove(customer);
                    return customer.getCustomerMoney();
                })
                .mapToInt(Integer::intValue)
                .peek(roomCount -> totalRooms.incrementAndGet())
                .sum();
        return Occupancy.builder().totalMoney(totalEconomyMoney).totalRooms(totalRooms.get()).category(category) .build();
    }
}
