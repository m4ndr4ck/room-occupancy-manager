package com.smarthost.framework.adapters.out.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smarthost.application.ports.out.RoomOccupancyPortOut;
import com.smarthost.domain.Customer;
import javax.enterprise.context.Dependent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class RoomOccupancyJSONFileAdapterOut implements RoomOccupancyPortOut {
    @Override
    public List<Customer> getCustomers()    {
        String file = "src/resources/customers.json";
        return readFileAsString(file);
    }
    private static List<Customer> readFileAsString(String file) {
        List<Customer> customers = new ArrayList<>();
        try (InputStream inputStream = RoomOccupancyJSONFileAdapterOut.class.getResourceAsStream("/customers.json");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String customerJsonString = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
            ObjectMapper mapper = new ObjectMapper();
            List<Integer> customerIntegerList = Arrays.asList(mapper.readValue(customerJsonString, Integer[].class));
            customerIntegerList.stream().forEach(customerMoney ->
                    customers.add(new Customer(customerMoney)));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return customers;
    }
}

