package dao.airplane;

import dao.DAO;
import domain.Airplane;

import java.util.List;
import java.util.Optional;

public interface DAOAirportInterface extends DAO<Airplane> {
    List<Airplane> getAllWithPlace();
    Optional<Airplane> getByIdWithPlace(long id);
}
