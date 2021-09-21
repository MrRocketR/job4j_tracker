package ru.job4j.tracker;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

/*    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }
}*/
/*    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), *//* id сохраненной заявки в объект tracker. *//*
                "replaced item"
        };
        StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }*/
   /* @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        Input input = new StubInput(answers);
        StartUI.deleteItem(input, tracker);
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted);
       // assertThat(deleted, is(IsNull.nullValue())); <- другой вариант
        //assertThat(deleted.getId(), is(nullValue())); <- нельзя вызывать getId*/

    }



}