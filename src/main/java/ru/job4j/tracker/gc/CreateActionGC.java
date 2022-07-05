package ru.job4j.tracker.gc;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.UserAction;
import ru.job4j.tracker.model.Item;

public class CreateActionGC implements UserAction {
    private final Output out;

    public CreateActionGC(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        int value = input.askInt("Enter value: ");
        for (int i = 0; i <= value; i++) {
            out.println("=== Create a new Item ====");
            String name = String.valueOf(i);
            Item item = new Item(name);
            store.add(item);
            out.println("Добавленная заявка: " + item);
        }
        return true;
    }
}
