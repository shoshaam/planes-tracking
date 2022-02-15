package aviationstackapi.dao.flight;

import aviationstackapi.dao.DAO;
import domain.Flight;

public class FlightDAOCreator {
    private static final DAO<Flight> flightDAO = new FlightDAO();

    public static DAO<Flight> createDAO(){
        return flightDAO;
    }
}
