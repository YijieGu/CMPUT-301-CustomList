package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @BeforeEach
    public void createList(){
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest(){
        int listSize =list.getCount();
        list.addCity(new City("Halifax","Ns"));
        assertEquals(list.getCount(),listSize+1);
    }

    @Test
    public void hasCityTest(){
        City newCity = new City("Edmonton","AB");
        list.addCity(newCity);
        assertTrue(list.hasCity(newCity));
        City newCity2 = new City("Toronto","ON");
        assertFalse(list.hasCity(newCity2));
    }
}

