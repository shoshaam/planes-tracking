/**
 * Интерфейс создания фабрики сервисов
 */
public interface ServiceCreator {

    /**
     * фабричный метод создания сервиса
     * @return - конретный сервис
     */
    AirportService createService();
}
