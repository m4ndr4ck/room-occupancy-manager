package com.smarthost.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Occupancy {
    private int totalRooms;
    private int totalMoney;
    private Room.Category category;

    @Override
    public String toString() {
        return "Occupancy{" +
                "totalRooms=" + totalRooms +
                ", totalMoney=" + totalMoney +
                ", category=" + category +
                '}';
    }
}
