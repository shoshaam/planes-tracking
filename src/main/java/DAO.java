import java.util.Map;

/**
 * Общий дао класс
 * @param <T> - домэйн класс
 */
public interface DAO<T> {
    Map<Long, T> getAll();
}
