package com.smarthost.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UsageDomainTests {

    @Test
    void getPremiumUsage() {
        assertTrue(Room.Type.PREMIUM.name().equals("PREMIUM"));
    }

    @Test
    void getFreeUsage() {
        assertTrue(Room.Type.ECONOMY.name().equals("ECONOMY"));
    }

}
