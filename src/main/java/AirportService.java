/**
 * Интерфейс для всех сервисов аэропорта
 */
public interface AirportService{

    /**
     * Возвращает список всех объектов из базы
     * @return - список с объектами типа Т
     */
    Object getAll();

    /**
     * Возвращает обеъект с заданным айди
     * @param id - айди объекта
     * @return - обект типа T
     */
    Object getById(int id);


}
