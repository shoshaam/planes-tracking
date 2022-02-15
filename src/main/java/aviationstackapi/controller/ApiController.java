package aviationstackapi.controller;

import java.util.List;

/**
 * Общий интерфейс контроллеров для работы с данными стороннего апи. Предоставляет метод получения данных
 * @param <T> - тип получаемых объектов
 */
public interface ApiController<T> {
    List<T> getData();
}
