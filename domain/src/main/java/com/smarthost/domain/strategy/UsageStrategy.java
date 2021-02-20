package com.smarthost.domain.strategy;

import com.smarthost.domain.Customer;
import com.smarthost.domain.Occupancy;
import com.smarthost.domain.Room;
import java.util.concurrent.CopyOnWriteArrayList;

public interface UsageStrategy {
    Occupancy getOccupancy(CopyOnWriteArrayList<Customer> customers, int rooms, Room.Category category);
}

