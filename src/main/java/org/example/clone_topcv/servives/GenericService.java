package org.example.clone_topcv.servives;

import java.util.List;

public interface GenericService<T, ID>{
    T save(T entity);

    T update(ID id, T entity);

    void delete(ID id);

    List<T> findAll();

    T findById(ID id);

}
