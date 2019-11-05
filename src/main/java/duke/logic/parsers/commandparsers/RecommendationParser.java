package duke.logic.parsers.commandparsers;

import duke.commons.Messages;
import duke.commons.exceptions.ParseException;
import duke.logic.commands.Command;
import duke.logic.commands.RecommendationsCommand;

/**
 * Parses the user inputs into suitable format for RecommendationsCommand.
 */
public class RecommendationParser extends CommandParser {
    private String input;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;

    /**
     * Constructs the RecommendationParser.
     */
    public RecommendationParser(String input) {
        this.input = input;
    }

    /**
     * Parses the input and return a new Itinerary constructed from it.
     * @return The Itinerary object.
     * @throws ParseException If Itinerary object cannot be created.
     */
    private String[] createRecommendation() throws ParseException {
        String[] itineraryDetails = input.substring("recommend".length()).strip().split("between | and");

        if (itineraryDetails.length != THREE || itineraryDetails[ONE] == null || itineraryDetails[TWO] == null) {
            throw new ParseException(Messages.ERROR_INPUT_INVALID_FORMAT);
        }

        if (itineraryDetails[ZERO].strip().isEmpty()) {
            throw new ParseException(Messages.ERROR_DESCRIPTION_EMPTY);
        }
        return itineraryDetails;
    }

    /**
     * Parses the user input and constructs RecommendationCommand object.
     * @return RecommendationCommand object.
     * @throws ParseException If RecommendationCommand object cannot be created.
     */
    @Override
    public Command parse() throws ParseException {
        String[] itineraryDetails = createRecommendation();
        return new RecommendationsCommand(itineraryDetails);
    }
}
