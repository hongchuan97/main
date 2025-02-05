package sgtravel.commons.exceptions;

import sgtravel.commons.Messages;

/**
 * Displays an error when nothing is found.
 */
public class NullResultException extends DukeException {

    /**
     * Constructs the Exception.
     */
    public NullResultException() {
        super(Messages.ERROR_RESULT_NOT_FOUND);
    }
}
