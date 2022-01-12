package dao.airplane;

import web.Mode;

public class AirplaneDAOCreator {
    private static final DAOAirportInterface mockAirplaneDAO = new MockAirplaneDAO();
    private static final DAOAirportInterface airplaneDAO = new AirplaneDAO();

    public static DAOAirportInterface createDAO(Mode mode){
        if(mode == Mode.TEST){
            return mockAirplaneDAO;
        }
        return airplaneDAO;
    }
}
