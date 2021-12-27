/**
 * Дао фабрика для аэропорта
 */
public class AirportDAOCreator {
    private static DAO<Airport> airportDAO = new AirportDAO();
    private static DAO<Airport> mockAirportDAO = new MockAirportDAO();

    public static DAO<Airport> createDAO(Mode mode){
        if(mode == Mode.TEST){
            return mockAirportDAO;
        }
        return airportDAO;
    }
}
