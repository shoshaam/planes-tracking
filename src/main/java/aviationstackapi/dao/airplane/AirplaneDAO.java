package aviationstackapi.dao.airplane;

import aviationstackapi.dao.DAO;
import domain.Airplane;

import java.sql.*;
import java.util.List;

/**
 * Реализация дао для самолётов
 */
public class AirplaneDAO implements DAO<Airplane> {

    private final Connection connection = database.MySQLConnection.getConnection();

    @Override
    public void refreshData(List<Airplane> list) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("delete from airplanes");
            CallableStatement cs = connection.prepareCall("{call insert_airplanes(?, ?)}");
            for (Airplane airplane : list) {
                cs.setString(1, airplane.getProductionLine());
                cs.setString(2, airplane.getRegistrationNumber());
                cs.addBatch();
            }
            cs.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
