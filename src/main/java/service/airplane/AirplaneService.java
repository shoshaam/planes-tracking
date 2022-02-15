package service.airplane;

import domain.Airplane;

import java.util.List;
import java.util.Optional;

public interface AirplaneService {

    List<Airplane> getAll();

    List<Airplane> getAllWithPlace();

    Optional<Airplane> getByIdWithPlace(Long id);

    Optional<Airplane> getById(Long id);
}
