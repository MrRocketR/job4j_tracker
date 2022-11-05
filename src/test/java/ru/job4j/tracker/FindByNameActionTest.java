package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item(1, "New");
        tracker.add(item);
        FindByNameAction findByNameAction = new  FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(6);
        when(input.askStr(any(String.class))).thenReturn("New");
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        String actual =  out.toString();
        String expected  = "=== Find items by name ====" +  ln + item + ln;
        assertEquals(expected, actual);
    }

}