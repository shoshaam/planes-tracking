package aviationstackapi.controller.airport;

import aviationstackapi.controller.ApiController;
import domain.Airport;
import web.Mode;

/**
 * Фабрика для контроллера аэропортов
 */
public class AirportApiControllerCreator {
    private static final ApiController<Airport> controller = new AirportApiController();
    private static final ApiController<Airport> mockController = new MockAirportApiController();

    public static ApiController<Airport> createController(Mode mode){
        if (mode == Mode.TEST){
            return mockController;
        }
        return controller;
    }
}
