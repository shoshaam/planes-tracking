package service.airplane;

import web.Mode;

/**
 * Фабрика для сервиса с информацией о самолётах
 */
public class AirplaneServiceCreator {
    private static final AirplaneService mockAirplaneService = new MockAirplaneService();
    private static final RealAirplaneService realAirplaneService = new RealAirplaneService();

    public static AirplaneService createService(Mode mode){
        if(mode == Mode.TEST){
            return mockAirplaneService;
        }
        return realAirplaneService;
    }
}
