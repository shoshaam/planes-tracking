package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonSerializer implements Serializer {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String serialize(Object obj) {
        return gson.toJsonTree(obj).toString();
    }
}
