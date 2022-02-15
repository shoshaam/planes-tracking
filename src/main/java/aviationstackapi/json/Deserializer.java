package aviationstackapi.json;

import java.util.List;

public interface Deserializer<T> {
    List<T> deserialize(String stringData, Class<T> parameterClassType);
}
