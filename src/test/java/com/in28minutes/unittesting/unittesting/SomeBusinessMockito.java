package com.in28minutes.unittesting.unittesting;

import com.in28minutes.unittesting.unittesting.service.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockito {
//    SomeBusinessClass someBusinessClass=new SomeBusinessClass();
//    SomeDataService someDataService=mock(SomeDataService.class);
//    @BeforeEach
//    public void before(){
//        someBusinessClass.setSomeDataService(someDataService);
////    here we wrote the code which is common for all test cases
//    }
@InjectMocks
SomeBusinessClass someBusinessClass=new SomeBusinessClass();

@Mock
SomeDataService someDataService;

    @Test
    public void caluclateSumUsingDataService() {
//        SomeBusinessClass someBusinessClass=new SomeBusinessClass();
//      SomeDataService mockSomeDataService=  mock(SomeDataService.class);
      when(someDataService.retrieveAllData()).thenReturn(new int[] {1,2,3,4});
      //intha mundu we created stub for this but problem with stub is we should write lot of code
        //if new method added to interface we should modify the test cases again
        //here we can achieve loose coupling
//        someBusinessClass.setSomeDataService(someDataService);
        int actualResult=   someBusinessClass.caluclateSumUsingSomeDataService();
        int expectedResult=10;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void caluclateSumUsingDataServiceEmpty() {
//        SomeBusinessClass someBusinessClass=new SomeBusinessClass();
//        SomeDataService someDataService=mock(SomeDataService.class);
        when(someDataService.retrieveAllData()).thenReturn(new int[]{});
//        someBusinessClass.setSomeDataService(someDataService);
        int actualResult=   someBusinessClass.caluclateSumUsingSomeDataService();
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void caluclateSumUsingDataServiceOneElement() {
//        SomeBusinessClass someBusinessClass=new SomeBusinessClass();
//        SomeDataService someDataService=mock(SomeDataService.class);
        when(someDataService.retrieveAllData()).thenReturn(new int[]{5});
//        someBusinessClass.setSomeDataService(someDataService);
        int actualResult=   someBusinessClass.caluclateSumUsingSomeDataService();
        int expectedResult=5;
        assertEquals(expectedResult,actualResult);
    }

}
