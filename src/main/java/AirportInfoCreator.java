/**
 * Фабрика для сервиса с информацией об аэропортах
 */
public class AirportInfoCreator implements ServiceCreator{

    @Override
    public AirportService createService() {
        return new AirportInfoService();
    }
}
