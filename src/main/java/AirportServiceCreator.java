/**
 * Фабрика для сервиса с информацией об аэропортах
 */
public class AirportServiceCreator {
    private static final AirportService airportService = new RealAirportService();
    private static final AirportService mockAirportService = new MockAirportService();

    public static AirportService createService(Mode mode) {
        if (mode == Mode.TEST)
            return mockAirportService;
        return airportService;
    }
}
