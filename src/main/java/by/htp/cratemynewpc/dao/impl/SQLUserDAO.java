package by.htp.cratemynewpc.dao.impl;


import by.htp.cratemynewpc.dao.UserDAO;
import by.htp.cratemynewpc.dao.connectionpool.ConnectionPool;
import by.htp.cratemynewpc.dao.connectionpool.DBResourceManager;
import by.htp.cratemynewpc.dao.exception.DAOException;
import by.htp.cratemynewpc.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class SQLUserDAO implements UserDAO {


    @Override
    public User checkUser(String login, String password) throws DAOException {

        DBResourceManager dbr = DBResourceManager.getInstance();
        System.out.println("--------------------------" + dbr.getValue("db.url"));
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        User user = null;

        ConnectionPool conPool = ConnectionPool.getInstance();


        try { // try with res rel
            connection = conPool.takeConnection();

            statement = connection.prepareStatement("SELECT name, surname FROM user_info JOIN users on user_info.USERS_ID_USERS = users.ID_USERS where login=? and password=?");
            statement.setString(1, login);
            statement.setString(2, password);

            rs = statement.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setName(rs.getString(1));
                user.setSurname(rs.getString(2));
            }

        } catch (SQLException | InterruptedException e) {
            throw new DAOException("message foe change", e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // TODO log error
                }
            }
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO log error
            }
        }

        return user;
    }

    @Override
    public User findUserInfoDAO(String login) throws DAOException {
        DBResourceManager dbr = DBResourceManager.getInstance();
        User user = null;
        ResultSet rs = null;
        Integer id = null;

        ConnectionPool conPool = ConnectionPool.getInstance();
        try (Connection connection = conPool.takeConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT ID_USERS FROM users WHERE login=?");
            statement.setString(1, login);
            rs = statement.executeQuery();

            if (rs.next()) {
                id = Integer.valueOf(rs.getString(1));

                user = findDAO(id);
            }
        } catch (SQLException | InterruptedException e) {
            throw new DAOException("message foe change", e);
        }
        return user;
    }

    @Override
    public User findDAO(Integer id) throws DAOException {
        DBResourceManager dbr = DBResourceManager.getInstance();
        User user = null;
        ResultSet rs = null;

        ConnectionPool conPool = ConnectionPool.getInstance();
        try (Connection connection = conPool.takeConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT ID_USERS, login, password, name, surname, age, adress, email, is_Admin FROM users JOIN user_info ON user_info.USERS_ID_USERS = users.ID_USERS where ID_USERS=?")) {
            statement.setString(1, Integer.toString(id));
            rs = statement.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getString(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));

                user.setName(rs.getString(4));
                user.setSurname(rs.getString(5));
                user.setAge(rs.getString(6));
                user.setAddress(rs.getString(7));
                user.setEmail(rs.getString(8));
                user.setIs_Admin(Boolean.valueOf(rs.getString(9)));
            }



        } catch (SQLException | InterruptedException e) {
            throw new DAOException("message foe change", e);
        }
        return user;
    }

    @Override
    public User saveDAO(User domain) throws DAOException {

        /*DBResourceManager dbr = DBResourceManager.getInstance();*/
        Connection connection = null;
        User user = null;

        ConnectionPool conPool = ConnectionPool.getInstance();


        try {
            connection = conPool.takeConnection();
            connection.setAutoCommit(false);
            {
                try (PreparedStatement statement = connection.prepareStatement("INSERT INTO users (login, password) values (?,?)")) {
                    statement.setString(1, domain.getLogin());
                    statement.setString(2, domain.getPassword());
                    statement.executeUpdate();

                }
                try (PreparedStatement statement = connection.prepareStatement("INSERT INTO user_info(name, surname, age, adress, email, USERS_ID_USERS) values(?,?,?,?,?,(SELECT ID_USERS FROM users WHERE login=?))")) {

                    statement.setString(1, domain.getName());
                    statement.setString(2, domain.getSurname());
                    statement.setString(3, domain.getAge());
                    statement.setString(4, domain.getAddress());
                    statement.setString(5, domain.getEmail());
                    statement.setString(6, domain.getLogin());


                    statement.executeUpdate();
                    /* connection.commit();*///???

                }
            }
            connection.commit();
        } catch (SQLException | InterruptedException e) {
            connection.rollback();
            throw new DAOException("message foe change", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO log error
            }

            return user = domain;
        }
    }

    @Override
    public void updateDAO(User domain) throws DAOException {

    }

    @Override
    public void deleteDAO(Integer id) throws DAOException {

    }

    @Override
    public List<User> findAllDAO() throws DAOException {
        return null;
    }
}
