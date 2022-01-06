package dao;

import entity.Airport;

import java.util.HashMap;
import java.util.Map;

/**
 * Тестовая реализация дао для аэропорта
 */
public class MockAirportDAO implements DAO<Airport> {
    @Override
    public Map<Long, Airport> getAll(){
        Map<Long, Airport> airports = new HashMap<>();
        long id = 0;
        airports.put(++id, new Airport(1L,"JND55DS", "Moscow"));
        airports.put(++id, new Airport(2L,"JND475DS", "Minsk"));
        return airports;
    }
}
