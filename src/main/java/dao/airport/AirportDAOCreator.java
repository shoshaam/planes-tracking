package dao.airport;
import web.Mode;

/**
 * Дао фабрика для аэропорта
 */
public class AirportDAOCreator {
    private static final DAOAirportInterface airportDAO = new AirportDAO();
    private static final DAOAirportInterface mockAirportDAO = new MockAirportDAO();

    public static DAOAirportInterface createDAO(Mode mode){
        if(mode == Mode.TEST){
            return mockAirportDAO;
        }
        return airportDAO;
    }
}
