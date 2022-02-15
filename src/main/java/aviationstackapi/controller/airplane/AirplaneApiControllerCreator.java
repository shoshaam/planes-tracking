package aviationstackapi.controller.airplane;

import aviationstackapi.controller.ApiController;
import domain.Airplane;
import web.Mode;

/**
 * Фабрика для контроллера самолётов
 */
public class AirplaneApiControllerCreator {
    private static final ApiController<Airplane> controller = new AirplaneApiController();
    private static final ApiController<Airplane> mockController = new MockAirplaneApiController();

    public static ApiController<Airplane> createController(Mode mode){
        if (mode == Mode.TEST){
            return mockController;
        }
        return controller;
    }
}
