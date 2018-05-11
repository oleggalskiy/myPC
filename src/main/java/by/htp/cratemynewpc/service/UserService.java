package by.htp.cratemynewpc.service;

import by.htp.cratemynewpc.domain.User;
import by.htp.cratemynewpc.service.exception.ServiceException;


public interface UserService extends CrudServise<User> {

    User signin(String login, String password) throws ServiceException;
    User getUserInfo(String login) throws ServiceException;



}
