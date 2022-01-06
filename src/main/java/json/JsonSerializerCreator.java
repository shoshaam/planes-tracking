package json;

/**
 * Фабрика для сериалайзера с json информацией
 */
public class JsonSerializerCreator{
    private static final Serializer serializer = new JsonSerializer();

    public static Serializer createSerializer(){
        return serializer;
    }
}
