package service.airplane;

import dao.airplane.AirplaneDAOCreator;
import dao.airplane.DAOAirplaneInterface;
import domain.Airplane;
import web.Mode;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для самолётов. Бизнес логика
 */
public class RealAirplaneService implements AirplaneService{

    private static final DAOAirplaneInterface dao = AirplaneDAOCreator.createDAO(Mode.NORMAL);

    @Override
    public List<Airplane> getAll() {
        return dao.getAll();
    }

    @Override
    public List<Airplane> getAllWithPlace() {
        return dao.getAllWithPlace();
    }

    @Override
    public Optional<Airplane> getByIdWithPlace(Long id) {
        return dao.getByIdWithPlace(id);
    }

    @Override
    public Optional<Airplane> getById(Long id) {
        return dao.getById(id);
    }
}
