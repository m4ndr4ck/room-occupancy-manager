package com.smarthost.framework;

import com.smarthost.domain.Occupancy;
import com.smarthost.domain.Room;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Tag;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@QuarkusTest
@Tag("integration")
public class RoomOccupancyAdapterTests {

    @Test
    public void test1() {
        Map<String,String> requestParams = new HashMap<>();
        requestParams.put("freePremiumRooms", "3");
        requestParams.put("freeEconomyRooms", "3");

        var occupancies =List.of(given().contentType("application/json")
                .body(requestParams)
                .when()
                .post("/api/v1/rooms/occupancy")
                .then()
                .statusCode(200)
                .extract()
                .as(Occupancy[].class));

        for (Occupancy occupancy : occupancies) {
            if(occupancy.getCategory() == Room.Category.PREMIUM){
                assertTrue(occupancy.getTotalRooms()==3);
                assertTrue(occupancy.getTotalMoney()==738);
            } else {
                assertTrue(occupancy.getTotalRooms()==3);
                assertTrue(occupancy.getTotalMoney()==167);
            }
        }
    }

    @Test
    public void test2() {
        Map<String,String> requestParams = new HashMap<>();
        requestParams.put("freePremiumRooms", "7");
        requestParams.put("freeEconomyRooms", "5");

        var occupancies =List.of(given().contentType("application/json")
                .body(requestParams)
                .when()
                .post("/api/v1/rooms/occupancy")
                .then()
                .statusCode(200)
                .extract()
                .as(Occupancy[].class));

        for (Occupancy occupancy : occupancies) {
            if(occupancy.getCategory() == Room.Category.PREMIUM){
                assertTrue(occupancy.getTotalRooms()==6);
                assertTrue(occupancy.getTotalMoney()==1054);
            } else {
                assertTrue(occupancy.getTotalRooms()==4);
                assertTrue(occupancy.getTotalMoney()==189);
            }
        }
    }

    @Test
    public void test3() {
        Map<String,String> requestParams = new HashMap<>();
        requestParams.put("freePremiumRooms", "2");
        requestParams.put("freeEconomyRooms", "7");

        var occupancies =List.of(given().contentType("application/json")
                .body(requestParams)
                .when()
                .post("/api/v1/rooms/occupancy")
                .then()
                .statusCode(200)
                .extract()
                .as(Occupancy[].class));

        for (Occupancy occupancy : occupancies) {
            if(occupancy.getCategory() == Room.Category.PREMIUM){
                assertTrue(occupancy.getTotalRooms()==2);
                assertTrue(occupancy.getTotalMoney()==583);
            } else {
                assertTrue(occupancy.getTotalRooms()==4);
                assertTrue(occupancy.getTotalMoney()==189);
            }
        }
    }

    @Test
    public void test4() {
        Map<String,String> requestParams = new HashMap<>();
        requestParams.put("freePremiumRooms", "7");
        requestParams.put("freeEconomyRooms", "1");

        var occupancies =List.of(given().contentType("application/json")
                .body(requestParams)
                .when()
                .post("/api/v1/rooms/occupancy")
                .then()
                .statusCode(200)
                .extract()
                .as(Occupancy[].class));

        for (Occupancy occupancy : occupancies) {
            if(occupancy.getCategory() == Room.Category.PREMIUM){
                assertTrue(occupancy.getTotalRooms()==7);
                assertTrue(occupancy.getTotalMoney()==1153);
            } else {
                assertTrue(occupancy.getTotalRooms()==1);
                assertTrue(occupancy.getTotalMoney()==45);
            }
        }
    }

}
