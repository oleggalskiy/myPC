package by.htp.cratemynewpc.service;

import by.htp.cratemynewpc.service.exception.ServiceException;

import java.util.List;

public interface CrudServise<T>  {

    T findService(Integer id) throws ServiceException;
    T saveService(T domain) throws ServiceException;
    void updateService(T domain) throws ServiceException;
    void deleteService(Integer id) throws ServiceException;

    List<T> findAllService() throws ServiceException;
}
