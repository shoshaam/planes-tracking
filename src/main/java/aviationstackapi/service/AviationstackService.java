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

/**
 * Рабочий сервис обновления данных бд
 */
public class AviationstackService implements ApiService {
    private DAO<Airplane> airplaneDAO = AirplaneDAOCreator.createDAO();
    private DAO<Airport> airportDAO = AirportDAOCreator.createDAO();
    private DAO<Flight> flightDAO = FlightDAOCreator.createDAO();

    private ApiController<Airplane> airplaneApiController = AirplaneApiControllerCreator.createController(Mode.NORMAL);
    private ApiController<Airport> airportsApiController = AirportApiControllerCreator.createController(Mode.NORMAL);
    private ApiController<Flight> flightsApiController = FlightApiControllerCreator.createController(Mode.NORMAL);

    @Override
    public void startUpdating() {
        List<Airplane> airplanes = airplaneApiController.getData();
        airplaneDAO.refreshData(airplanes);

        List<Airport> airports = airportsApiController.getData();
        airportDAO.refreshData(airports);

        List<Flight> flights = flightsApiController.getData();
        flightDAO.refreshData(flights);
    }
}
