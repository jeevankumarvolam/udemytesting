package com.in28minutes.unittesting.unittesting;

import org.junit.jupiter.api.*;
import org.mockito.configuration.*;
import com.in28minutes.unittesting.unittesting.service.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.*;

public class Types {
    List<String> mock = mock(List.class);

    @Test
    public void return_with_generic_parameters() {

        when(mock.get(anyInt())).thenReturn("in 28 minutes");
        assertEquals("in 28 minutes", mock.get(0));
        assertEquals("in 28 minutes", mock.get(1));
    }

    @Test
    public void verification_basis() {
        Object value = mock.get(0);
        Object value2 = mock.get(1);
        verify(mock).get(0);
        //THIS IS USED WHEN METHIOD DOESNT RETURN ANY VALUE
        verify(mock, times(1)).get(0);
        verify(mock, atLeast(2)).get(anyInt());
        verify(mock, never()).get(2);


    }

    @Test
    public void argumenta_capture() {
        //here we are capturing argument values
        mock.add("some string");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("some string", captor.getValue());


    }

    @Test
    public void multiple_argumenta_capture() {
        //here we are capturing  multiple argument values
        mock.add("some string");
        mock.add("some string 1");
        mock.add("some string 2");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(3)).add(captor.capture());
        List<String> allvalues = captor.getAllValues();
        assertEquals("some string", allvalues.get(0));
        assertEquals("some string 1", allvalues.get(1));

    }
    @Test
    public void no_spying(){
        ArrayList arrayListmock=mock(ArrayList.class);
        arrayListmock.add("test 1");
        System.out.println(arrayListmock.size());
//here it retuns 0 because we didnt wrote when and then return

    }
    @Test
    public void spying(){
        ArrayList arrayListspy=spy(ArrayList.class);
        arrayListspy.add("test 1");
        System.out.println(arrayListspy.size());
//here if we keep any class as spy it behaves as real class no need of when and returns method
        //here even though we didnt mentioned size() methods it gives retunr type because it behaves as
        //original method

    }




}