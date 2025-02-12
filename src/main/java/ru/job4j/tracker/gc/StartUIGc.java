package ru.job4j.tracker.gc;

import ru.job4j.tracker.*;
import ru.job4j.tracker.trackers.MemTracker;

import java.util.List;

public class StartUIGc {
    private final Output out;

    public StartUIGc(Output out) {
        this.out = out;
    }

    public void init(Input input, Store store, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, store);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
           out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        MemTracker tracker = new MemTracker();
            List<UserAction> actions = List.of(
                    new CreateActionGC(output),
                    new DeleteActionGC(output),
                    new Exit(output)
            );
            new StartUIGc(output).init(input, tracker, actions);

        }
    }



