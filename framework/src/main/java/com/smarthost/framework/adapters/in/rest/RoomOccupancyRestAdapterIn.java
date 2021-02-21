package com.smarthost.framework.adapters.in.rest;

import com.smarthost.application.ports.command.FreeRooms;
import com.smarthost.application.usecases.RoomOccupancyUseCase;
import com.smarthost.application.usecases.RoomOccupancyUseCase.RoomOccupancyCommand;
import com.smarthost.domain.Occupancy;
import com.smarthost.domain.Room;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1/rooms/occupancy")
public class RoomOccupancyRestAdapterIn {

    @Inject
    public RoomOccupancyUseCase roomOccupancyUseCase;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(operationId = "getRoomOccupancy", description = "Obtain the best guest allocation based on both premium and economy available rooms.")
    @Tag(name = "Get Room Occupancy")
    public List<Occupancy> getRoomOccupancy(FreeRooms freeRooms) {
        RoomOccupancyCommand roomOccupancyCommand = new RoomOccupancyCommand(freeRooms);
        var occupancy = roomOccupancyUseCase.getRoomOccupancy(roomOccupancyCommand);
        return List.of(occupancy.get(Room.Category.PREMIUM), occupancy.get(Room.Category.ECONOMY));
    }
}
