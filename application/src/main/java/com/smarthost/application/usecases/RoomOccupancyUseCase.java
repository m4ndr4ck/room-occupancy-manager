package com.smarthost.application.usecases;

import com.smarthost.application.ports.command.FreeRooms;
import com.smarthost.application.usecases.helpers.SelfValidating;
import com.smarthost.domain.Occupancy;
import com.smarthost.domain.Room;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.inject.Inject;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.HashMap;

public interface RoomOccupancyUseCase {

    HashMap<Room.Category, Occupancy> getRoomOccupancy(RoomOccupancyCommand roomOccupancyCommand);

    @Getter
    @EqualsAndHashCode(callSuper = false)
    class RoomOccupancyCommand extends SelfValidating<RoomOccupancyCommand> {

        @Inject
        Validator validator;

        @NotNull
        @Positive
        Integer freePremiumRooms;

        @NotNull
        @Positive
        Integer freeEconomyRooms;

        public HashMap<Room.Category, Integer> getRooms(){
            HashMap<Room.Category, Integer> rooms = new HashMap<>();
            rooms.put(Room.Category.PREMIUM, freePremiumRooms);
            rooms.put(Room.Category.ECONOMY, freeEconomyRooms);
            return rooms;
        }

        public RoomOccupancyCommand(FreeRooms freeRooms) {
            this.freePremiumRooms = freeRooms.getFreePremiumRooms();
            this.freeEconomyRooms = freeRooms.getFreeEconomyRooms();
            this.validateSelf();
        }
    }
}
