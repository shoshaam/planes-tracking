package aviationstackapi.service;

import aviationstackapi.controller.ApiController;
import aviationstackapi.controller.airplane.AirplaneApiControllerCreator;
import aviationstackapi.controller.airport.AirportApiControllerCreator;
import aviationstackapi.controller.flight.FlightApiControllerCreator;
import aviationstackapi.dao.DAO;
import aviationstackapi.dao.airplane.AirplaneDAOCreator;
import aviationstackapi.dao.airport.AirportDAOCreator;
import aviationstackapi.dao.flight.FlightDAOCreator;
import domain.Airplane;
import domain.Airport;
import domain.Flight;
import web.Mode;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Рабочий сервис обновления данных бд
 */
public class AviationstackService implements ApiService {
    private final DAO<Airplane> airplaneDAO = AirplaneDAOCreator.createDAO();
    private final DAO<Airport> airportDAO = AirportDAOCreator.createDAO();
    private final DAO<Flight> flightDAO = FlightDAOCreator.createDAO();

    private final ApiController<Airplane> airplaneApiController = AirplaneApiControllerCreator.createController(Mode.NORMAL);
    private final ApiController<Airport> airportsApiController = AirportApiControllerCreator.createController(Mode.NORMAL);
    private final ApiController<Flight> flightsApiController = FlightApiControllerCreator.createController(Mode.NORMAL);

    @Override
    public void startUpdating() {
        List<Airplane> airplanes = airplaneApiController.getData();
        airplaneDAO.refreshData(airplanes);

        List<Airport> airports = airportsApiController.getData();
        airportDAO.refreshData(airports);

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(() -> {
            List<Flight> flights = flightsApiController.getData();
            flightDAO.refreshData(flights);
        }, 0, 30, TimeUnit.MINUTES);
    }
}
