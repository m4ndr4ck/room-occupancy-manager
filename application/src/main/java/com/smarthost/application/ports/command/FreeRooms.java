package com.smarthost.application.ports.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class FreeRooms {
    int freePremiumRooms;
    int freeEconomyRooms;
}
