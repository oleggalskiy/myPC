package by.htp.cratemynewpc.dao;

import by.htp.cratemynewpc.dao.exception.DAOException;

import java.util.List;

public interface CrudDAO<T> {
    T findDAO(Integer id) throws DAOException;
    T saveDAO(T domain) throws DAOException;
    void updateDAO(T domain) throws DAOException;
    void deleteDAO(Integer id) throws DAOException;

    List<T> findAllDAO() throws DAOException;


}
