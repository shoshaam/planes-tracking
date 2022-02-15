package aviationstackapi.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonDeserializer<T> implements Deserializer<T>{

    public List<T> deserialize(String stringData, Class<T> parameterClassType) {
        JsonObject jsonObject = new Gson().fromJson(stringData, JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonArray("data");
        Type typeOfT = TypeToken.getParameterized(List.class, parameterClassType).getType();
        return new Gson().fromJson(jsonArray, typeOfT);
    }
}
