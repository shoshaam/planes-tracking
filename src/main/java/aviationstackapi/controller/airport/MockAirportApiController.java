package aviationstackapi.controller.airport;

import aviationstackapi.controller.ApiController;
import domain.Airport;

import java.util.ArrayList;
import java.util.List;

/**
 * Тестовый контроллер получения данных о аэропортах
 */
public class MockAirportApiController implements ApiController<Airport> {
    @Override
    public List<Airport> getData() {
        List<Airport> airports = new ArrayList<>();
        long id = 0;
        airports.add(new Airport(++id,"SFO", "Minsk"));
        airports.add(new Airport(++id,"DFW", "Moscow"));
        return airports;
    }
}
