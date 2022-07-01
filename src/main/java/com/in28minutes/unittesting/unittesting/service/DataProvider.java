package com.in28minutes.unittesting.unittesting.service;

public class DataProvider implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3,4};
    }
}
