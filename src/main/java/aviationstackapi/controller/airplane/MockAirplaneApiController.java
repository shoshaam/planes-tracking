package aviationstackapi.controller.airplane;

import aviationstackapi.controller.ApiController;
import domain.Airplane;

import java.util.*;

/**
 * Тестовый контроллер получения данных о самолётах
 */
public class MockAirplaneApiController implements ApiController<Airplane> {
    @Override
    public List<Airplane> getData() {
        List<Airplane> airplanes = new ArrayList<>();
        long id = 0;
        airplanes.add(new Airplane(++id, "Boeing 737 Classic", "YR-BAC"));
        airplanes.add(new Airplane(++id, "Boeing 737 Classic", "N160AN"));
        airplanes.add(new Airplane(++id, "Airbus A380-800", "A6-EOT"));
        return airplanes;
    }
}
