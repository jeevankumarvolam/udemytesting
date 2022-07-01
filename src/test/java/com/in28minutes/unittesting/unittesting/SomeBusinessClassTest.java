package com.in28minutes.unittesting.unittesting;

import com.in28minutes.unittesting.unittesting.service.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessClassTest {
    @Test
    public void caluclateSum(){
        SomeBusinessClass someBusinessClass=new SomeBusinessClass();
       int actualResult= someBusinessClass.caluclateSum(new int[]{1,2,3,4});
       int expectedResult=10;
       assertEquals(expectedResult,actualResult);
    }

    public class SomeDataServiceStub implements SomeDataService{
        @Override
        public int[] retrieveAllData() {
            return new int[]{1,2,3,4,5,6};
        }
    }
    public class SomeDataServiceOneElementStub implements SomeDataService{
        @Override
        public int[] retrieveAllData() {
            return new int[]{5};
        }
    }
    public class SomeDataServiceEmptyStub implements SomeDataService{
        @Override
        public int[] retrieveAllData() {
            return new int[]{};
        }
    }

    @Test
    public void caluclateSumUsingDataService() {
        SomeBusinessClass someBusinessClass=new SomeBusinessClass();
        someBusinessClass.setSomeDataService(new SomeDataServiceStub());
     int actualResult=   someBusinessClass.caluclateSumUsingSomeDataService();
int expectedResult=21;
assertEquals(expectedResult,actualResult);
    }
    @Test
    public void caluclateSumUsingDataServiceOneElement() {
        SomeBusinessClass someBusinessClass=new SomeBusinessClass();
        someBusinessClass.setSomeDataService(new SomeDataServiceOneElementStub());
        int actualResult=   someBusinessClass.caluclateSumUsingSomeDataService();
        int expectedResult=5;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void caluclateSumUsingDataServiceEmpty() {
        SomeBusinessClass someBusinessClass=new SomeBusinessClass();
        someBusinessClass.setSomeDataService(new SomeDataServiceEmptyStub());
        int actualResult=   someBusinessClass.caluclateSumUsingSomeDataService();
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }


}