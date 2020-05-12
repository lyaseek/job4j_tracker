package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;

public class SortItemTest {
    @Test
    public void whenSortByIDAscend() {
        Item item1 = new Item("B");
        item1.setId("234");
        Item item2 = new Item("D");
        item2.setId("123");
        Item item3 = new Item("C");
        item3.setId("456");
        Item item4 = new Item("A");
        item4.setId("345");
        List<Item> list = Arrays.asList(item1, item2, item3, item4);
        list.sort(new SortByIDItem());
        assertThat(list.toString(), is("[Item id = 123   name = D    , Item id = 234   name = B    , Item id = 345   name = A    , Item id = 456   name = C    ]"));
    }

    @Test
    public void whenSortByNameAscend() {
        List<Item> list = Arrays.asList(new Item("D"), new Item("B"), new Item("A"), new Item("C"));
        list.sort(new SortByNameItem());
        assertThat(list.toString(), is("[Item id = null  name = A    , Item id = null  name = B    , Item id = null  name = C    , Item id = null  name = D    ]"));
    }
    @Test
    public void whenSortByIDReverse(){
        Item item1 = new Item("B");
        item1.setId("234");
        Item item2 = new Item("D");
        item2.setId("123");
        Item item3 = new Item("C");
        item3.setId("456");
        Item item4 = new Item("A");
        item4.setId("345");
        List<Item> list = Arrays.asList(item1, item2, item3, item4);
        list.sort(new SortReverseByIDItem());
        assertThat(list.toString(), is("[Item id = 456   name = C    , Item id = 345   name = A    , Item id = 234   name = B    , Item id = 123   name = D    ]"));
    }

}
