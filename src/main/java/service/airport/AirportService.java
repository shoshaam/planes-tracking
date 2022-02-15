package service.airport;

import domain.Airport;

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
     * Возвращает объект с заданным айди
     * @param id - айди объекта
     * @return - объект
     */
    Optional<Airport> getById(Long id);

    /**
     * Возвращает объект с информацией об аэропорте с заданным айди и доп информацией о прилетающих/вылетающих самолётах
     * @param id - айди объекта
     * @return - объект
     */
    Optional<Airport> getAirplanesInformationById(Long id);

}
