package ru.job4j.tracker.gc;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.UserAction;

public class DeleteActionGC implements UserAction {
    private final Output out;

    public DeleteActionGC(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        int value = input.askInt("Enter value: ");
        for (int i = 0; i < value; i++) {
            out.println("=== Delete item ====");
            if (store.delete(i)) {
                System.out.println("Id текущей заявки " + i);
                out.println("Заявка удалена успешно.");
            } else {
                out.println("Ошибка удаления заявки.");
            }
        }
        return true;
    }
}
