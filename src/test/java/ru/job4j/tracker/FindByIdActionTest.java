package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.trackers.MemTracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item(1, "New");
        tracker.add(item);
        FindByIdAction findById = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(4);
        when(input.askInt(any(String.class))).thenReturn(1);
        findById.execute(input, tracker);
        String ln = System.lineSeparator();
        String actual =  out.toString();
        String expected  = "=== Find item by id ====" +  ln + item + ln;
        assertEquals(expected, actual);
    }

}