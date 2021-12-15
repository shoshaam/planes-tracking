/**
 * Интерфейс создания фабрики сериализаторов
 */
public interface SerializerCreator {

    /**
     * фабричный метод создания сериализатора
     * @return - конретный сериализатор
     */
    Serializer createSerializer();
}
