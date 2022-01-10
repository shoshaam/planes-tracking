package dao;
import domain.Airport;
import web.Mode;

/**
 * Дао фабрика для аэропорта
 */
public class AirportDAOCreator {
    private static final DAO<Airport> airportDAO = new AirportDAO();
    private static final DAO<Airport> mockAirportDAO = new MockAirportDAO();

    public static DAO<Airport> createDAO(Mode mode){
        if(mode == Mode.TEST){
            return mockAirportDAO;
        }
        return airportDAO;
    }
}
