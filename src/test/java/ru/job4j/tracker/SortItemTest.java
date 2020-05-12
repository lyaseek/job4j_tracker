package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;

public class SortItemTest {

    @Test
    public void whenSortByNameAscend() {
        List<Item> list = Arrays.asList(new Item("D"), new Item("B"), new Item("A"), new Item("C"));
        list.sort(new SortByNameItem());
        assertThat(list.toString(), is("[Item id = null  name = A    , Item id = null  name = B    , Item id = null  name = C    , Item id = null  name = D    ]"));
    }
    @Test
    public void whenSortByIDReverse(){
        List<Item> list = Arrays.asList(new Item("D"), new Item("B"), new Item("A"), new Item("C"));
        list.sort(new SortReverseByNameItem());
        assertThat(list.toString(), is("[Item id = null  name = D    , Item id = null  name = C    , Item id = null  name = B    , Item id = null  name = A    ]"));
    }

}
