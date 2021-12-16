/**
 * Фабрика для сериалайзера с json информацией
 */
public class JsonSerializerCreator{
    public static Serializer createSerializer(){
        return new JsonSerializer();
    }
}
