package service;

import dao.AirportDAOCreator;
import dao.DAO;
import domain.Airport;
import web.Mode;

import java.util.*;


/**
 * Класс сервиса аэропорта. Бизнес логика
 */
public class RealAirportService implements AirportService {

    private static final DAO<Airport> dao = AirportDAOCreator.createDAO(Mode.NORMAL);

    @Override
    public List<Airport> getAll(){
        return dao.getAll();
    }

    @Override
    public Optional<Airport> getById(Long id){
        return dao.getById(id);
    }
}
