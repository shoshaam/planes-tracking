package dao.airport;

import dao.DAO;
import domain.Airport;

import java.util.*;

/**
 * Тестовая реализация дао для аэропорта
 */
public class MockAirportDAO implements DAO<Airport> {

    Map<Long, Airport> airports;

    {
        airports = new HashMap<>();
        long id = 0;
        airports.put(++id, new Airport(1L,"JND55DS", "Moscow"));
        airports.put(++id, new Airport(2L,"JND475DS", "Minsk"));
    }

    @Override
    public List<Airport> getAll(){
        return new ArrayList<>(airports.values());
    }

    @Override
    public Optional<Airport> getById(long id) {
        return Optional.ofNullable(airports.get(id));
    }
}
