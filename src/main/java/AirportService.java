/**
 * Класс сервиса аэропорта. Будет сожержать всю??? безнес логику
 */
public class AirportService {
    public Airport getAllInformationById(int id){
        DAO<Airport> dao = new AirportDAO();
        return dao.getById(id);
    }
}
