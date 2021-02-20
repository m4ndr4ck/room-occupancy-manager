package com.smarthost.application.ports.out;

import com.smarthost.domain.Customer;

import java.util.List;

public interface RoomOccupancyPortOut {
    List<Customer> getCustomers();
}
