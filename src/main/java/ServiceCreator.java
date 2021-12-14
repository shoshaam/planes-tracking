/**
 * Интерфейс создания фабрики
 */
public interface ServiceCreator {

    /**
     * фабричный метод создания сервиса
     * @return - конретный сервис
     */
    AirportService createService();
}
