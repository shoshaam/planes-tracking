package dao.airplane;

import domain.Airplane;

import java.util.*;

public class MockAirplaneDAO implements DAOAirportInterface {

    Map<Long, Airplane> airplanesWithPlace;

    {
        airplanesWithPlace = new HashMap<>();
        long id = 0;
        airplanesWithPlace.put(++id, new Airplane(id, "Boeing 737 Classic", "YR-BAC", "Minsk"));
        airplanesWithPlace.put(++id, new Airplane(id, "Airbus A380-800", "A6-EOT", "Moscow"));
        airplanesWithPlace.put(++id, new Airplane(id, "Airbus A380-800", "A9-EKA"));
    }

    @Override
    public List<Airplane> getAll() {
        return new ArrayList<>(airplanesWithPlace.values());
    }

    @Override
    public Optional<Airplane> getById(long id) {
        return Optional.ofNullable(airplanesWithPlace.get(id));
    }


    @Override
    public List<Airplane> getAllWithPlace() {
        return new ArrayList<>(airplanesWithPlace.values());
    }

    @Override
    public Optional<Airplane> getByIdWithPlace(long id) {
        return Optional.ofNullable(airplanesWithPlace.get(id));
    }
}
