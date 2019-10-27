package duke.model.locations;

import duke.commons.enumerations.Constraint;
import duke.commons.exceptions.QueryFailedException;
import duke.model.Model;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Class representing a Bus Stop.
 */
public class BusStop extends RouteNode {
    private String busCode;
    private Set<String> buses;

    /**
     * Creates a BusStop object.
     *
     * @param busCode The bus code.
     * @param address The address.
     * @param description The description.
     * @param latitude The latitude.
     * @param longitude The longitude.
     */
    public BusStop(String busCode, String address, String description, double latitude, double longitude) {
        super(Constraint.valueOf("BUS"), address, description, latitude, longitude);
        this.busCode = busCode;
        this.buses = new HashSet<>();
    }

    /**
     * Gets the Set of bus services of the bus stop in String.
     *
     * @return buses The Set of bus services in String.
     */
    public Set<String> getBuses() {
        return buses;
    }

    /**
     * Gets the bus code of the Bus Stop in String.
     *
     * @return busCode The bus code of the bus stop in String.
     */
    public String getBusCode() {
        return busCode;
    }

    /**
     * Adds a bus service in the form of a String to buses.
     *
     * @param bus The bus to add.
     */
    public void addBuses(String bus) {
        buses.add(bus);
    }

    /**
     * Fetches data from model and updates the bus stop.
     *
     * @param model The model.
     * @throws QueryFailedException If the bus stop is not found.
     */
    public void fetchData(Model model) throws QueryFailedException {
        HashMap<String, BusStop> allBus = model.getMap().getBusStopMap();
        if (allBus.containsKey(this.busCode)) {
            this.setAddress(allBus.get(this.busCode).getAddress());
            this.setLatitude(allBus.get(this.busCode).getLatitude());
            this.setLongitude(allBus.get(this.busCode).getLongitude());
            return;
        }

        throw new QueryFailedException("BUS_STOP");
    }
}

