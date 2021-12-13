import java.util.ArrayList;

/**
 * Общий дао класс
 * @param <T> - домэйн класс
 */
public abstract class DAO<T> {
    public abstract T getById(int id);
}
