package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.*;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ValidateInput validate = new ValidateInput(new StubInput(new String[]{"one", "1"}));
        validate.askInt("Enter");
        assertThat(mem.toString(), is(String.format("Please enter validate data again.%n")));
        System.setOut(out);
    }

    @Test
    public void whenKeyOutOfMenu() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        UserAction[] actions = new UserAction[3];
        ValidateInput validate = new ValidateInput(new StubInput(new String[]{"44", "1"}));
        validate.askInt("Enter: ", actions.length);
        assertThat(mem.toString(), is(String.format("Please select key from menu.%n")));
        System.setOut(out);
    }
}
