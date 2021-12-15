/**
 * Интерфейс для всех сервисов аэропорта
 */
public interface AirportService{

    /**
     * Возвращает список всех объектов из базы
     * @return - список с объектами
     */
    Object getAll();

    /**
     * Возвращает обеъект с заданным айди
     * @param id - айди объекта
     * @return - объект
     */
    Object getById(int id);


}
