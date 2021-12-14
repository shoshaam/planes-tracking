import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class JsonSerializer {
    public JsonElement serialize(Object someObject){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJsonTree(someObject);
    }
}
