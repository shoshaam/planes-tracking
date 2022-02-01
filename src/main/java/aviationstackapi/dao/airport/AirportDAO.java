package aviationstackapi.dao.airport;

import aviationstackapi.dao.DAO;
import database.MySQLConnection;
import domain.Airport;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AirportDAO implements DAO<Airport>{
    private final Connection connection = MySQLConnection.getConnection();

    @Override
    public void refreshData(List<Airport> list) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("delete from airports");
            CallableStatement cs = connection.prepareCall("{call insert_airports(?, ?)}");
            for (Airport airport : list) {
                cs.setString(1, airport.getIataCode());
                cs.setString(2, airport.getAirportName());
                cs.addBatch();
            }
            cs.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
