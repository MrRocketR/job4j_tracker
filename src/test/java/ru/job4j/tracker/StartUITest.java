package ru.job4j.tracker;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }
}
/*
 /*  @Test
    public void whenShowAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindAllAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
*/
/*   *//* assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0.Show all items Хранилище еще не содержит заявок" + System.lineSeparator()
        )*//*
        )*//**//*;*/
/*
    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "Exit" + System.lineSeparator()
        ));
    }
   /* @Test
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
    }*/

    /*@Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        *//* Добавим в tracker новую заявку *//*
        Item item = tracker.add(new Item("Replaced item"));
        *//* Входные данные должны содержать ID добавленной заявки item.getId() *//*
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0" , String.valueOf(item.getId()),replacedName,"1", }
        );
        UserAction[] actions = {
                new ReplaceAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }*/

    /*@Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
         //Добавим в tracker новую заявку
        Item item = tracker.add(new Item("Deleted item"));
         //Входные данные должны содержать ID добавленной заявки item.getId()
        Input in = new StubInput(
                new String[] {"0",  String.valueOf(item.getId()) , "1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
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
        //assertThat(deleted.getId(), is(nullValue())); <- нельзя вызывать getId */


















