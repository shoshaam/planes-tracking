import java.util.*;

/**
 * Класс тестового сервиса аэропорта. Бизнес логика
 */
public class MockAirportService implements AirportService{

    Map<Long, Airport> airports;

    //добавление данных
    {
        airports = new HashMap<>();
        long id = 0;
        airports.put(++id, new Airport(1L,"JND55DS", "Minsk"));
        airports.put(++id, new Airport(2L,"JND475DS", "Moscow"));
    }

    @Override
    public List<Airport> getAll(){
        return new ArrayList<>(airports.values());
    }

    @Override
    public Optional<Airport> getById(Long id){
        return Optional.ofNullable(airports.get(id));
    }
}
