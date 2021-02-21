package com.smarthost.application;

import com.smarthost.application.ports.out.RoomOccupancyPortOut;
import com.smarthost.application.usecases.RoomOccupancyUseCase;
import com.smarthost.application.usecases.RoomOccupancyUseCase.RoomOccupancyCommand;
import com.smarthost.domain.Room;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import java.util.HashMap;

@QuarkusTest
public class RoomOccupancyApplicationTests {

    @Inject
    public RoomOccupancyUseCase roomOccupancyUseCase;


    @BeforeAll
    public static void setup() {
        //RoomOccupancyUseCase mock = Mockito.mock(RoomOccupancyUseCase .class);

        //QuarkusMock.installMockForType(mock, RoomOccupancyUseCase.class);


    }

    @Test
    void RoomOccupancyUseCaseTest (){
        //HashMap<Room.Category, Integer> rooms = new HashMap<>();
        //rooms.put(Room.Category.PREMIUM, 3);
        //rooms.put(Room.Category.ECONOMY, 3);

        //RoomOccupancyCommand roomOccupancyCommand = new RoomOccupancyCommand(rooms);
        //roomOccupancyUseCase.getRoomOccupancy(roomOccupancyCommand);
    }
}
