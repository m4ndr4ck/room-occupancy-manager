package com.smarthost.application.ports.in;

import com.smarthost.application.ports.out.RoomOccupancyPortOut;
import com.smarthost.application.usecases.RoomOccupancyUseCase;
import com.smarthost.domain.Customer;
import com.smarthost.domain.Occupancy;
import com.smarthost.domain.Room;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RequestScoped
public class RoomOccupancyPortIn implements RoomOccupancyUseCase {

    @Inject
    RoomOccupancyPortOut roomOccupancyPortOut;

    @Override
    public HashMap<Room.Category, Occupancy> getRoomOccupancy(RoomOccupancyCommand roomOccupancyCommand) {
        var customers = new CopyOnWriteArrayList(getCustomers());
        var rooms =roomOccupancyCommand.getRooms();
        return Room.getOccupancy(customers, rooms);
    }

    private List<Customer> getCustomers(){
        return null;
    }
}
