package by.htp.cratemynewpc.dao;

import by.htp.cratemynewpc.dao.impl.SQLUserDAO;
import by.htp.cratemynewpc.dao.impl.SQLpcDAO;



public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO  userDAO = new SQLUserDAO();
    private final SQLpcDAO pcDAO = new SQLpcDAO();
    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }


    public UserDAO getUserDAO() {
        return userDAO;
    }
    public SQLpcDAO getPcDAO(){ return  pcDAO;  }

}
