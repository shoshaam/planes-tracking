package dao;

import java.util.List;
import java.util.Optional;

/**
 * Общий дао класс
 * @param <T> - домэйн класс
 */
public interface DAO<T> {
    List<T> getAll();

    Optional<T> getById(long id);
}
