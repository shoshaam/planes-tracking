import java.sql.*;

/**
 * Реализация дао для аэропорта
 */
public class AirportDAO extends DAO <Airport>{

    @Override
    public Airport getById(int id) {
        Connection connection = MySQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM airports WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return new Airport(resultSet.getInt("id"),
                        resultSet.getString("iata_code"),
                        resultSet.getString("airport_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
