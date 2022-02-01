package aviationstackapi.controller.airport;

import aviationstackapi.controller.ApiController;
import aviationstackapi.json.Deserializer;
import aviationstackapi.json.JsonDeserializer;
import domain.Airport;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 * Контроллер получения даннных о аэропортах из стороненного апи
 */
public class AirportApiController implements ApiController<Airport> {
    private static final Deserializer<Airport> airportDeserializer = new JsonDeserializer<>();

    @Override
    public List<Airport> getData() {
        try {
            List<Airport> airportList;
            URL url = new URL("http://api.aviationstack.com/v1/airports?access_key=15f8adef7b604ce5114dfe4ef352d34b&limit=2");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() != 200){
                throw new RuntimeException();
            }
            else {
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder json = new StringBuilder();
                while (scanner.hasNext()){
                    json.append(scanner.nextLine());
                }
                scanner.close();
                airportList = airportDeserializer.deserialize(json.toString(), Airport.class);
                return airportList;
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
