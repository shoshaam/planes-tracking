package aviationstackapi.dao.airplane;

import aviationstackapi.dao.DAO;
import domain.Airplane;

public class AirplaneDAOCreator {
    private static final DAO<Airplane> airplaneDAO = new AirplaneDAO();

    public static DAO<Airplane> createDAO(){
        return airplaneDAO;
    }
}
