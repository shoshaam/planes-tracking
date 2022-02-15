package aviationstackapi.dao.flight;

import aviationstackapi.dao.DAO;
import database.MySQLConnection;
import domain.Flight;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class FlightDAO implements DAO<Flight> {
    private final Connection connection = MySQLConnection.getConnection();

    @Override
    public void refreshData(List<Flight> list) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("delete from flights");
            CallableStatement cs = connection.prepareCall("{call insert_flights(?, ?, ?, ?, ?, ?)}");
            for (Flight flight : list) {
                cs.setString(1, flight.getDepIata());
                cs.setObject(2, flight.getDepSheduled());
                cs.setString(3, flight.getArrIata());
                cs.setObject(4, flight.getArrSheduled());
                cs.setString(5, flight.getPlaneRegistrationNumber());
                cs.setBoolean(6, flight.isGround());
                cs.addBatch();
            }
            cs.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
