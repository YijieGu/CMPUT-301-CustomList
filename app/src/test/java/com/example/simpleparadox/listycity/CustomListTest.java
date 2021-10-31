package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    public  void deleteCityTest(){
        City newCity = new City("Halifax","Ns");
        list.addCity(newCity);
        assertEquals(list.getCount(),1);
        list.deleteCity(newCity);
        assertEquals(list.getCount(),0);
        City newCity2 = new City("Toronto","ON");
        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(newCity2);
        });
    }

    @Test
    public void countCitiesTest(){
        City newCity = new City("Halifax","Ns");
        list.addCity(newCity);
        City newCity2 = new City("Toronto","ON");
        list.addCity(newCity2);
        assertEquals(list.countCities(),2);
        list.deleteCity(newCity);
        list.deleteCity(newCity2);
        assertEquals(list.countCities(),0);
    }



}

