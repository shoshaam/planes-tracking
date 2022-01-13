package service.airport;

import dao.airport.AirportDAOCreator;
import dao.airport.DAOAirportInterface;
import domain.Airport;
import web.Mode;

import java.util.*;


/**
 * Класс сервиса аэропорта. Бизнес логика
 */
public class RealAirportService implements AirportService {

    private static final DAOAirportInterface dao = AirportDAOCreator.createDAO(Mode.NORMAL);

    @Override
    public List<Airport> getAll(){
        return dao.getAll();
    }

    @Override
    public Optional<Airport> getById(Long id){
        return dao.getById(id);
    }

    @Override
    public Optional<Airport> getAirplanesInformationById(Long id) {
        return dao.getAirplanesInformationById(id);
    }
}
