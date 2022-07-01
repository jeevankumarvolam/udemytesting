package com.in28minutes.unittesting.unittesting.service;

import org.springframework.beans.factory.annotation.*;

public class SomeBusinessClass {
    @Autowired
private SomeDataService someDataService;
    public int caluclateSum(int[] data){
    int sum=0;
    for(int value:data){
        sum+=value;
    }
return sum;
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int caluclateSumUsingSomeDataService(){
        int sum=0;
        int[] data=someDataService.retrieveAllData();
        for(int value:data){
            sum+=value;
        }
        return sum;
    }


}
