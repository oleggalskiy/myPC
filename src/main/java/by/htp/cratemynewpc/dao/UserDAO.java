package by.htp.cratemynewpc.dao;

import by.htp.cratemynewpc.dao.exception.DAOException;
import by.htp.cratemynewpc.domain.User;


public interface UserDAO extends CrudDAO<User>{

    User checkUser(String login, String password) throws DAOException;
    User findUserInfoDAO(String login) throws DAOException;
}
