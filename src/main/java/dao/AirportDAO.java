package dao;

import entity.Airport;

import java.util.Map;

/**
 * Реализация дао для аэропорта
 */
public class AirportDAO implements DAO<Airport> {
    @Override
    public Map<Long, Airport> getAll(){
        return null;
    }

    /*@Override
    public entity.Airport getById(int id) throws SQLException {
        Connection connection = database.MySQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM airports WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return new entity.Airport(resultSet.getLong("id"),
                        resultSet.getString("iata_code"),
                        resultSet.getString("airport_name"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }*/

}
