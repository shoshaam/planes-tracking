package dao.airplane;

import web.Mode;

public class AirplaneDAOCreator {
    private static final DAOAirplaneInterface mockAirplaneDAO = new MockAirplaneDAO();
    private static final DAOAirplaneInterface airplaneDAO = new AirplaneDAO();

    public static DAOAirplaneInterface createDAO(Mode mode){
        if(mode == Mode.TEST){
            return mockAirplaneDAO;
        }
        return airplaneDAO;
    }
}
