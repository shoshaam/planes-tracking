package dao.airplane;

import domain.Airplane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Реализация дао для самолёта
 */
public class AirplaneDAO implements DAOAirplaneInterface {
    private static final Connection connection = database.MySQLConnection.getConnection();

    @Override
    public List<Airplane> getAll() {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM airplanes");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Airplane> airplanes = new ArrayList<>();
            while (resultSet.next()) {
                airplanes.add(new Airplane(resultSet.getLong("id"),
                        resultSet.getString("production_line"),
                        resultSet.getString("registration_number")));
            }
            return airplanes;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Airplane> getById(long id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM airplanes WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return Optional.of(new Airplane(resultSet.getLong("id"),
                        resultSet.getString("production_line"),
                        resultSet.getString("registration_number")));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Airplane> getAllWithPlace() {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM airplanes_with_place");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Airplane> airplanes = new ArrayList<>();
            while (resultSet.next()) {
                airplanes.add(new Airplane(resultSet.getLong("id"),
                        resultSet.getString("production_line"),
                        resultSet.getString("registration_number"),
                        resultSet.getString("where_airplane_is")));
            }
            return airplanes;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Airplane> getByIdWithPlace(long id) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM airplanes_with_place WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return Optional.of(new Airplane(resultSet.getLong("id"),
                        resultSet.getString("production_line"),
                        resultSet.getString("registration_number"),
                        resultSet.getString("where_airplane_is")));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
