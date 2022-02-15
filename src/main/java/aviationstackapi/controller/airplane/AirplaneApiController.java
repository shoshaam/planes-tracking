package aviationstackapi.controller.airplane;

import aviationstackapi.controller.ApiController;
import aviationstackapi.json.Deserializer;
import aviationstackapi.json.JsonDeserializer;
import domain.Airplane;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 * Контроллер получения даннных о самолётах из стороненного апи
 */
public class AirplaneApiController implements ApiController<Airplane> {
    private static final Deserializer<Airplane> airplaneDeserializer = new JsonDeserializer<>();

    @Override
    public List<Airplane> getData() {
        try {
            List<Airplane> airplaneList;
            URL url = new URL("http://api.aviationstack.com/v1/airplanes?access_key=15f8adef7b604ce5114dfe4ef352d34b&limit=2");
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
                airplaneList = airplaneDeserializer.deserialize(json.toString(), Airplane.class);
                return airplaneList;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
