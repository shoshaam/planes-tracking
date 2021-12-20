import java.util.Map;

/**
 * Интерфейс сервисов аэропорта
 */
public interface AirportService{

    /**
     * Возвращает список всех объектов
     * @return - коллекция с объектами
     */
    Map<Long, Airport> getAll();

    /**
     * Возвращает обеъект с заданным айди
     * @param id - айди объекта
     * @return - объект
     */
    Airport getById(Long id);

}
