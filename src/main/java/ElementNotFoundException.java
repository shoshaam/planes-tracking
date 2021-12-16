/**
 * Выбрасывается, когда не получилось найти нужный элемент в коллекции
 */
public class ElementNotFoundException extends Exception{
    ElementNotFoundException(String message) {
        super(message);
    }
    ElementNotFoundException() {
        super();
    }
    ElementNotFoundException(String message, Throwable cause) {
            super(message, cause);
    }
}
