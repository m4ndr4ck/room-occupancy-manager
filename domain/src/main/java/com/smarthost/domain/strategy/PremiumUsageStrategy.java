package com.smarthost.domain.strategy;

import com.smarthost.domain.Occupancy;
import com.smarthost.domain.Customer;
import com.smarthost.domain.Room;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class PremiumUsageStrategy implements UsageStrategy {

    @Override
    public Occupancy getOccupancy(CopyOnWriteArrayList<Customer> customers, int rooms, Room.Category category) {
      AtomicInteger totalRooms = new AtomicInteger();
      int totalPremiumMoney = customers.stream()
                .sorted(Comparator.comparingInt(Customer::getCustomerMoney).reversed())
                .limit(rooms)
                .map(customer -> {
                  customers.remove(customer);
                  return customer.getCustomerMoney();
                })
                .mapToInt(Integer::intValue)
                .peek(roomCount -> totalRooms.incrementAndGet())
                .sum();
        return Occupancy.builder().totalMoney(totalPremiumMoney).totalRooms(totalRooms.get()).category(category).build();
    }
}
