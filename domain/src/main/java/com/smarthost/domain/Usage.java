package com.smarthost.domain;

import com.smarthost.domain.strategy.EconomyUsageStrategy;
import com.smarthost.domain.strategy.PremiumUsageStrategy;
import com.smarthost.domain.strategy.UsageStrategy;
import lombok.Getter;

import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class Usage {

    private UsageStrategy usageStrategy;
    private Room.Category category;

    private Usage (Room.Category category) {
        this.category = category;
        switch (category){
            case PREMIUM:
                this.usageStrategy = new PremiumUsageStrategy();
                break;
            case ECONOMY:
                this.usageStrategy = new EconomyUsageStrategy();
                break;
        }
    }

    public static Usage getUsageStrategy(Room.Category category){
        return new Usage(category);
    }

    public Occupancy execute(CopyOnWriteArrayList<Customer> customers, int rooms) {
        return usageStrategy.getOccupancy(customers, rooms, category);
    }

}
