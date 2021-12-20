import java.util.*;

/**
 * Класс сервиса аэропорта. Бизнес логика
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
    public Map<Long, Airport> getAll(){
        return airports;
    }

    @Override
    public Airport getById(Long id){
        return airports.get(id);
    }
}
