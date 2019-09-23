package duke.commands;

import duke.storage.Storage;
import duke.ui.Ui;

/**
 * Class representing a command to list items in a task list.
 */
public class HelpCommand extends Command {
    /**
     * Executes this command on the given task list and user interface.
     *
     * @param ui The user interface displaying events on the task list.
     */
    @Override
    public void execute(Ui ui, Storage storage) {
        ui.setResponse(ui.getHelp());
    }
}
