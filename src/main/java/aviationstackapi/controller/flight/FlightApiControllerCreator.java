package aviationstackapi.controller.flight;

import aviationstackapi.controller.ApiController;
import domain.Flight;
import web.Mode;

/**
 * Фабрика для контроллера полётов
 */
public class FlightApiControllerCreator {
    private static final ApiController<Flight> controller = new FlightApiController();
    private static final ApiController<Flight> mockController = new MockFlightApiController();

    public static ApiController<Flight> createController(Mode mode){
        if (mode == Mode.TEST){
            return mockController;
        }
        return controller;
    }
}
