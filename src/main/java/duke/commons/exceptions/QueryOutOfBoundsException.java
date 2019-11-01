package duke.commons.exceptions;

import duke.commons.Messages;

/**
 * Exception thrown when index query is out of bounds.
 */
public class QueryOutOfBoundsException extends DukeException {

    /**
     * Constructs the Exception.
     */
    public QueryOutOfBoundsException() {
        super(Messages.ERROR_INDEX_OUT_OF_BOUNDS);
    }
}
