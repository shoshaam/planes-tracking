package aviationstackapi.dao.airport;

import aviationstackapi.dao.DAO;
import domain.Airport;

public class AirportDAOCreator {
    private static final DAO<Airport> airportDAO = new AirportDAO();

    public static DAO<Airport> createDAO(){
        return airportDAO;
    }
}
