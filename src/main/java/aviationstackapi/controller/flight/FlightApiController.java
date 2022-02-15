package aviationstackapi.controller.flight;

import aviationstackapi.controller.ApiController;
import aviationstackapi.dto.flight.FlightDTO;
import aviationstackapi.json.Deserializer;
import aviationstackapi.json.JsonDeserializer;
import domain.Flight;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Контроллер получения даннных о полётах из стороненного апи
 */
public class FlightApiController implements ApiController<Flight> {
    private static final Deserializer<FlightDTO> flightDeserializer = new JsonDeserializer<>();

    @Override
    public List<Flight> getData() {
        List<Flight> flightList = new ArrayList<>();
        try {
            URL url = new URL("http://api.aviationstack.com/v1/flights?access_key=15f8adef7b604ce5114dfe4ef352d34b&limit=2");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException();
            } else {
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder json = new StringBuilder();
                while (scanner.hasNext()) {
                    json.append(scanner.nextLine());
                }
                scanner.close();
                List<FlightDTO> flightDTOs = flightDeserializer.deserialize(json.toString(), FlightDTO.class);
                for (FlightDTO flightDTO : flightDTOs) {
                    flightList.add(new Flight(0L, flightDTO.departure.iata, flightDTO.departure.scheduled, flightDTO.arrival.iata,
                            flightDTO.arrival.scheduled, flightDTO.aircraft.registration, flightDTO.live.isGround));
                }
                return flightList;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
