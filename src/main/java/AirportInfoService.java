import java.util.ArrayList;

/**
 * Класс сервиса аэропорта. Бизнес логика
 */
public class AirportInfoService implements AirportService{

    @Override
    public ArrayList<Airport> getAll() {
        ArrayList<Airport> airports = new ArrayList<>();
        airports.add(new Airport(1,"JND55DS", "Minsk"));
        return airports;
    }

    @Override
    public Airport getById(int id){
        return new Airport(1,"JND55DS", "Minsk");
    }
}
