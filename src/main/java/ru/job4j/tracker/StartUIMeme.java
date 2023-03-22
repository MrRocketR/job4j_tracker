package ru.job4j.tracker;

import ru.job4j.tracker.trackers.MemTracker;
import ru.job4j.tracker.trackers.SqlTracker;

import java.util.List;

public class StartUIMeme {
    private final Output out;

    public StartUIMeme(Output out) {
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
        Log4File log = Log4File.getInstance();
        log.add("add new Item");
        log.save();
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Store tracker = new MemTracker();
            tracker.init();
            List<UserAction> actions = List.of(
                    new CreateAction(output),
                    new ReplaceAction(output),
                    new DeleteAction(output),
                    new FindAllAction(output),
                    new FindByIdAction(output),
                    new FindByNameAction(output),
                    new Exit(output)
            );
            new StartUIMeme(output).init(input, tracker, actions);
        }
    }



