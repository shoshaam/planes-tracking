/**
 * Фабрика для сервиса с информацией об аэропортах
 */
public class AirportInfoCreator{
    public static AirportService createService() {
        return new AirportInfoService();
    }
}
