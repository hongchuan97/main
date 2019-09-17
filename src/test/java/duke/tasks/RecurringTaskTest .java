package duke.tasks;

import duke.commons.DukeException;

import duke.parsers.ParserUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecurringTaskTest {
    ParserUtil parserUtil = new ParserUtil();

    @Test
    void testToString() throws DukeException {
        RecurringTask task = ParserUtil.createRecurringTask("repeat Homework /at 17/09/19 2359 /every 5");
        assertEquals(task.toString(), "[R][✘] Homework by 2019-09-17 23:59 (every 5 days)");
    }
}

