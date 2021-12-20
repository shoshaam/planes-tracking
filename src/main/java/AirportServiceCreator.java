/**
 * Фабрика для сервиса с информацией об аэропортах
 */
public class AirportServiceCreator {
    private static AirportService airportService = new MockAirportService();

    public static AirportService createService() {
        return airportService;
    }
}
