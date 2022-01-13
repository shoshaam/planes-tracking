package dao.airport;

import dao.DAO;
import domain.Airplane;
import domain.Airport;

import java.util.*;

/**
 * Тестовая реализация дао для аэропорта
 */
public class MockAirportDAO implements DAOAirportInterface {

    Map<Long, Airport> airports;

    {
        airports = new HashMap<>();
        long id = 0;
        airports.put(++id, new Airport(1L,"JND55DS", "Moscow"));
        airports.put(++id, new Airport(2L,"JND475DS", "Minsk"));

        ArrayList<Airplane> airplanes = new ArrayList<>();
        id = 0;
        airplanes.add(new Airplane(++id, "Boeing 737 Classic", "YR-BAC", "Minsk"));
        airplanes.add(new Airplane(++id, "Airbus A380-800", "A6-EOT", "Moscow"));
        airports.get(1L).setAirplanes(airplanes);
    }

    @Override
    public List<Airport> getAll(){
        return new ArrayList<>(airports.values());
    }

    @Override
    public Optional<Airport> getById(long id) {
        return Optional.ofNullable(airports.get(id));
    }

    @Override
    public Optional<Airport> getAirplanesInformationById(Long id) {
        return Optional.ofNullable(airports.get(id));
    }
}
