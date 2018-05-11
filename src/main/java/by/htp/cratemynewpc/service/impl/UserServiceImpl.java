package by.htp.cratemynewpc.service.impl;

import by.htp.cratemynewpc.dao.DAOFactory;
import by.htp.cratemynewpc.dao.UserDAO;
import by.htp.cratemynewpc.dao.exception.DAOException;
import by.htp.cratemynewpc.domain.User;
import by.htp.cratemynewpc.service.UserService;
import by.htp.cratemynewpc.service.exception.ServiceException;

import java.util.List;


public class UserServiceImpl implements UserService {

    @Override
    public User signin(String login, String password) throws ServiceException {
        //TODO validation

        DAOFactory factory = DAOFactory.getInstance();
        UserDAO dao = factory.getUserDAO();

        User user = null;
        try {
            user = dao.checkUser(login, password);
        } catch (DAOException e) {
            throw new ServiceException("message!!!! change", e);
        }


        return user;
    }


    @Override
    public User getUserInfo(String login) throws ServiceException{
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO dao = factory.getUserDAO();
        User user = null;
        try {
            user = dao.findUserInfoDAO(login);
        } catch (DAOException e) {
            throw new ServiceException("message!!!! change", e);
        }

        return user;
    }

    @Override
    public User findService(Integer id) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO dao = factory.getUserDAO();
         Integer idUser = id;
         User user = null;

        try {
            user = dao.findDAO(idUser);
        } catch (DAOException e) {
            throw new ServiceException("message!!!! change", e);
        }

        return user;
    }

    @Override
    public User saveService(User domain) throws ServiceException  {
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO dao = factory.getUserDAO();
        User user = null;

        try {
            user = dao.saveDAO(domain);
        } catch (DAOException e) {
            throw new ServiceException("message!!!! change", e);
        }

        return user;
    }

    @Override
    public void updateService(User domain) {

    }

    @Override
    public void deleteService(Integer id) {

    }

    @Override
    public List<User> findAllService() {
        return null;
    }
}
