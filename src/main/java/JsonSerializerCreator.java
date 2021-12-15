public class JsonSerializerCreator implements SerializerCreator{

    @Override
    public Serializer createSerializer() {
        return new JsonSerializer();
    }
}
