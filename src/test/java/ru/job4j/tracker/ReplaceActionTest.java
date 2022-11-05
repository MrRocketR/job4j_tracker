package ru.job4j.tracker;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import ru.job4j.tracker.model.Item;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

public class ReplaceActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertEquals("=== Edit item ===" + ln + "Заявка изменена успешно." + ln, out.toString());
        assertEquals(tracker.findAll().get(0).getName(), replacedName);
    }

}