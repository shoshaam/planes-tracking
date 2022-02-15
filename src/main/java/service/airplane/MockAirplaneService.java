package service.airplane;

import domain.Airplane;

import java.util.*;

/**
 * Тестовый сервис для самолётов
 */
public class MockAirplaneService implements AirplaneService {
    Map<Long, Airplane> airplanesWithPlace;

    {
        airplanesWithPlace = new HashMap<>();
        long id = 0;
        airplanesWithPlace.put(++id, new Airplane(id, "Boeing 737 Classic", "YR-BAC", "Minsk"));
        airplanesWithPlace.put(++id, new Airplane(id, "Airbus A380-800", "A6-EOT", "Moscow"));
    }

    @Override
    public List<Airplane> getAll() {
        return new ArrayList<>(airplanesWithPlace.values());
    }

    @Override
    public List<Airplane> getAllWithPlace() {
        return new ArrayList<>(airplanesWithPlace.values());
    }

    @Override
    public Optional<Airplane> getByIdWithPlace(Long id) {
        return Optional.ofNullable(airplanesWithPlace.get(id));
    }

    @Override
    public Optional<Airplane> getById(Long id) {
        return Optional.ofNullable(airplanesWithPlace.get(id));
    }
}
