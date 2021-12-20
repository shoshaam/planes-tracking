/**
 * Фабрика для сериалайзера с json информацией
 */
public class JsonSerializerCreator{
    private static Serializer serializer = new JsonSerializer();

    public static Serializer createSerializer(){
        return serializer;
    }
}
