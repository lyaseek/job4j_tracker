package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC", "Install the App"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[1];
        Item expected = new Item("Install the App");
        assertThat(created.getName(), is(expected.getName()));
    }
}
