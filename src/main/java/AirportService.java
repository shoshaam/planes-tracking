import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;

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
    Optional<Airport> getById(Long id);

}
