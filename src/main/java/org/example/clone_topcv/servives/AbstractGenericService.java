package org.example.clone_topcv.servives;

import jakarta.persistence.EntityNotFoundException;
import org.example.clone_topcv.entities.UserManagement.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public abstract class AbstractGenericService<T, ID, R extends JpaRepository<T, ID>> implements GenericService<T, ID> {

    protected final R repository;

    public AbstractGenericService(R repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(ID id, T entity) {
        if(!repository.existsById(id)) {
            throw new EntityNotFoundException("Entity not found with id " + id);
        }
        return repository.save(entity);
    }

    @Override
    public void delete(ID id) {
        if(!repository.existsById(id)) {
            throw new EntityNotFoundException("Entity not found with id " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
