import java.util.Collection;

/**
 * Интерфейс сервисов аэропорта
 */
public interface AirportService{

    /**
     * Возвращает список всех объектов
     * @return - коллекция с объектами
     */
    Collection getAll();

    /**
     * Возвращает обеъект с заданным айди
     * @param id - айди объекта
     * @return - объект
     */
    Airport getById(Long id) throws ElementNotFoundException;

}
