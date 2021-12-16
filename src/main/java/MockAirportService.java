import java.util.ArrayList;
import java.util.Collection;

/**
 * Класс сервиса аэропорта. Бизнес логика
 */
public class MockAirportService implements AirportService{

    ArrayList<Airport> airports;

    //добавление данных
    {
        airports = new ArrayList<>();
        airports.add(new Airport(1L,"JND55DS", "Minsk"));
        airports.add(new Airport(2L,"JND475DS", "Moscow"));
    }

    @Override
    public Collection<Airport> getAll(){
        return airports;
    }

    @Override
    public Airport getById(Long id) throws ElementNotFoundException{
        for(Airport airport : airports){
            if(airport.id.equals(id)){
                return airport;
            }
        }
        throw new ElementNotFoundException("Airport is not found. Id:" + id);
    }
}
