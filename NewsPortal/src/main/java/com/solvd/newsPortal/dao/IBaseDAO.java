package com.solvd.newsPortal.dao;

public interface IBaseDAO<T> {
    void createItem(T item);

    T getItemById(Long id);

    void updateItem(T item, Long id);

    void deleteById(Long id);
}
