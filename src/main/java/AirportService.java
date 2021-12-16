import java.util.ArrayList;

/**
 * Интерфейс для всех сервисов аэропорта
 */
public interface AirportService{

    /**
     * Возвращает список всех объектов из базы
     * @return - список с объектами
     */
    //???
    ArrayList getAll();

    /**
     * Возвращает обеъект с заданным айди
     * @param id - айди объекта
     * @return - объект
     */
    //???
    Object getById(int id);


}
