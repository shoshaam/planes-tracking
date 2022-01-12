package dao.airplane;

import dao.DAO;
import domain.Airplane;

import java.util.List;
import java.util.Optional;

/**
 * Расширенный интерфейс, включающий методы для /api/airplan/{airplan-id} эндпоинта
 * Методы работают с описанием самолёта и где он сейчас находится
 */
public interface DAOAirportInterface extends DAO<Airplane> {
    List<Airplane> getAllWithPlace();
    Optional<Airplane> getByIdWithPlace(long id);
}
