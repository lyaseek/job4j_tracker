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
        String[] data = new String[]{"one", "1"};
        ValidateInput validate = new ValidateStubInput(data);
        validate.askInt("Enter");
        assertThat(mem.toString(), is(String.format("Please enter validate data again.%n")));
        System.setOut(out);
    }

    @Test
    public void whenKeyOutOfMenu() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        String[] data = new String[]{"3", "1"};
        UserAction[] actions = new UserAction[]{new ReplaceAction(), new CreateAction(), new DeleteAction()};
        ValidateInput input = new ValidateStubInput(data);
        input.askInt("Enter: ", actions.length);
        assertThat(mem.toString(), is(String.format("Please select key from menu.%n")));
        System.setOut(out);
    }
}
