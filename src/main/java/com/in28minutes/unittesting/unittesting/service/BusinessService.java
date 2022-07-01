package com.in28minutes.unittesting.unittesting.service;

import com.in28minutes.unittesting.unittesting.model.*;
import org.springframework.stereotype.*;

@Component
public class BusinessService {
    public Item retrieveHardcodedItemFromBusinessService(int id, String name, int price, int quantity) {
        return new Item(id,name,price,quantity);
    }
}
