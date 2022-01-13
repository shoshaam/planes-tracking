package dao.airport;

import dao.DAO;
import domain.Airport;

import java.util.List;
import java.util.Optional;

public interface DAOAirportInterface extends DAO<Airport> {
    Optional<Airport> getAirplanesInformationById(Long id);
}
