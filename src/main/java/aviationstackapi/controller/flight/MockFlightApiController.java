package aviationstackapi.controller.flight;

import aviationstackapi.controller.ApiController;
import domain.Flight;
import java.util.ArrayList;
import java.util.List;

/**
 * Тестовый контроллер получения данных о полётах
 */
public class MockFlightApiController implements ApiController<Flight> {
    @Override
    public List<Flight> getData() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(0L,"DFW", "2019-12-12T04:20:00+00:00", "SFO", "2019-12-12T04:20:00+00:00", "YR-BAC", true));
        flights.add(new Flight(0L,"DFW", "2019-12-12T04:20:00+00:00", "SFO", "2019-12-12T04:20:00+00:00", "N160AN", false));
        return flights;
    }
}
