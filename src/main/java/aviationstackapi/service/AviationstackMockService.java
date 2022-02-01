package aviationstackapi.service;

import domain.Airplane;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Тестовый сервис обновления данных в бд (только самолёты для проверки)
 */
public class AviationstackMockService implements ApiService {

    private static final Connection connection = database.MySQLConnection.getConnection();
    List<Airplane> airplanesWithPlace;

    {
        airplanesWithPlace = new ArrayList<>();
        long id = 0;
        airplanesWithPlace.add(new Airplane(++id, "Boeing 737 Classic", "00-BAC", "Minsk"));
        airplanesWithPlace.add(new Airplane(++id, "Airbus A380-800", "00-EOT", "Moscow"));
    }

    @Override
    public void startUpdating() {
        try {
            CallableStatement cs = connection.prepareCall("{call insert_airplanes(?, ?)}");
            for (Airplane airplane : airplanesWithPlace) {
                cs.setString(1, airplane.getProductionLine());
                cs.setString(2, airplane.getRegistrationNumber());
                cs.addBatch();
            }
            cs.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
