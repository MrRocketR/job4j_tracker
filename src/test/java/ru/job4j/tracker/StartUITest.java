package ru.job4j.tracker;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), /* id сохраненной заявки в объект tracker. */
                "replaced item"
        };
        StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {"3",String.valueOf(item.getId())};
        Input input = new StubInput(answers);
        StartUI.deleteItem(input, tracker);
        //Input input2 = new StubInput(answers);
        //StartUI.deleteItem(input, tracker);
        //StartUI.showItem(input, tracker);
        //Item deleted = tracker.findById(1);
        //assertThat(deleted.getId(), is(IsNull.nullValue()));

    }
    /*
    1. Создаем объект tracker.
    2. Создаем объект item.
    3. Добавляем item в tracker. После этой операции у нас есть id.
    4. Достаем item.id и создаем массив с ответами пользователя.
    5. Вызываем тестируемый метод replaceItem. Это действие изменит состояние объекта tracker.
    6. Ищем по item.id замененный item в объекте tracker.
    7. Сравниваем имя найденной заявки с ожидаемой.
     */


}