import java.util.List;
import java.util.Optional;

/**
 * Интерфейс сервисов аэропорта
 */
public interface AirportService{

    /**
     * Возвращает список всех объектов
     * @return - коллекция с объектами
     */
    List<Airport> getAll();

    /**
     * Возвращает обеъект с заданным айди
     * @param id - айди объекта
     * @return - объект
     */
    Optional<Airport> getById(Long id);

}
