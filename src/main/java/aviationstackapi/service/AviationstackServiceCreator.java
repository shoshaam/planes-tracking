package aviationstackapi.service;

import web.Mode;

/**
 * Фабрика для сервиса обновления данных из стороннего апи
 */
public class AviationstackServiceCreator {
    private static final ApiService mockService = new AviationstackMockService();
    private static final ApiService service = new AviationstackService();

    public static ApiService createService(Mode mode){
        if (mode == Mode.TEST){
            return mockService;
        }
        return service;
    }
}
