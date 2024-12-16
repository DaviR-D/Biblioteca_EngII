package biblioteca;

import java.util.List;

public interface GenericDAO<T> {
    void save(T t);

    T findById(int id);

    List<T> findAll();

    void update(T t);

    void delete(int id);
}
