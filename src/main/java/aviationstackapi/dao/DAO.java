package aviationstackapi.dao;

import java.util.List;

public interface DAO<T> {
    void refreshData(List<T> list);
}
