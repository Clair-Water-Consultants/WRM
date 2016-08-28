package com.wrm.dao;

import java.io.Serializable;
import java.util.List;

public interface DaoInterface<T, IdT extends Serializable> {
  public String persist(T entity);

  public void update(T entity);

  public T findById(String id);

  public boolean delete(String id);

  public List<T> findAll();

  public void deleteAll();

}