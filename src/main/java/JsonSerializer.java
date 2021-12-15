import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonSerializer implements Serializer {

    @Override
    public String serialize(Object obj) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJsonTree(obj).toString();
    }
}
