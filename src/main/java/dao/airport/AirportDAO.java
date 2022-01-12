package dao.airport;

import dao.DAO;
import domain.Airport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Реализация дао для аэропорта
 */
public class AirportDAO implements DAO<Airport> {
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
}
