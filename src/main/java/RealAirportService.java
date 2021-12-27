import java.util.*;

/**
 * Класс сервиса аэропорта. Бизнес логика
 */
public class RealAirportService implements AirportService{

    private static DAO<Airport> dao = AirportDAOCreator.createDAO(Mode.TEST);
    private static Map<Long, Airport> airports = dao.getAll();

    @Override
    public List<Airport> getAll(){
        return new ArrayList<>(airports.values());
    }

    @Override
    public Optional<Airport> getById(Long id){
        return Optional.ofNullable(airports.get(id));
    }
}
