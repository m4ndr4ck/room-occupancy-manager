package com.smarthost.application.usecases;

import com.smarthost.application.usecases.helpers.SelfValidating;
import com.smarthost.domain.Occupancy;
import com.smarthost.domain.Room;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

public interface RoomOccupancyUseCase {

    HashMap<Room.Category, Occupancy> getRoomOccupancy(RoomOccupancyCommand roomOccupancyCommand);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class RoomOccupancyCommand extends SelfValidating<RoomOccupancyCommand> {

        @NotNull
        HashMap<Room.Category, Integer> rooms;

        public RoomOccupancyCommand(HashMap<Room.Category, Integer> rooms) {
            this.rooms = rooms;
            this.validateSelf();
        }
    }
}
