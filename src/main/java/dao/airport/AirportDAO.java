package dao.airport;

import domain.Airplane;
import domain.Airport;
import domain.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * Реализация дао для аэропорта
 */
public class AirportDAO implements DAOAirportInterface {
    private static final Connection connection = database.MySQLConnection.getConnection();

    @Override
    public List<Airport> getAll(){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM airports");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Airport> airports = new ArrayList<>();
            while (resultSet.next()) {
                airports.add(new Airport(resultSet.getLong("id"),
                        resultSet.getString("iata_code"),
                        resultSet.getString("airport_name")));
            }
            return airports;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Airport> getById(long id){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM airports WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return Optional.of(new Airport(resultSet.getLong("id"),
                        resultSet.getString("iata_code"),
                        resultSet.getString("airport_name")));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Airport> getAirplanesInformationById(Long id) {
        try{
            CallableStatement cs = connection.prepareCall("{call airport_airplanes_information(?)}");
            cs.setLong(1, id);
            cs.executeUpdate();
            ArrayList<Airplane> airplanes = new ArrayList<>();
            ResultSet resultSet = cs.getResultSet();
            while(resultSet.next()) {
                airplanes.add(new Airplane(resultSet.getLong("airplane_id"),
                        resultSet.getString("production_line"),
                        resultSet.getString("registration_number"),
                        Status.valueOf(resultSet.getString("airplane_status").toUpperCase(Locale.ROOT))));
            }
            Optional<Airport> airport = getById(id);
            airport.ifPresent(aAirport -> aAirport.setAirplanes(airplanes));
            return airport;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
