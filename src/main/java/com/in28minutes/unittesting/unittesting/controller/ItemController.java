package com.in28minutes.unittesting.unittesting.controller;

import com.in28minutes.unittesting.unittesting.model.*;
import com.in28minutes.unittesting.unittesting.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @Autowired
    private BusinessService businessService;
    @GetMapping("/dummy-item")
public Item dummyItem(){
    return new Item(1,"ball",10,100);
}


    @GetMapping("/get-item-from-business-service")
    public Item itemFromBusinessService(){
     return   businessService.retrieveHardcodedItemFromBusinessService(1,"ball",10,100);
    }


}
