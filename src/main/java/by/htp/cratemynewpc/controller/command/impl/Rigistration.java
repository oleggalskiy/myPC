package by.htp.cratemynewpc.controller.command.impl;

import by.htp.cratemynewpc.controller.command.Command;
import by.htp.cratemynewpc.domain.User;
import by.htp.cratemynewpc.service.ServiceFactory;
import by.htp.cratemynewpc.service.UserService;
import by.htp.cratemynewpc.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Rigistration implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("First Name");
        String surname = request.getParameter("Second Name");
        String age = request.getParameter("Age");
        String address = request.getParameter("Address");
        String email = request.getParameter("Email");

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();

        User user = new User();
        String goToPage = null;

        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        user.setAddress(address);
        user.setEmail(email);
        try {
            user = userService.saveService(user);
        } catch (ServiceException e) {
            //goToPage = JSPPagePath.ERROR_PAGE;
            // log
            e.printStackTrace();

        }

        if (user != null) {
            request.getSession(true).setAttribute("user", user);
            goToPage = JSPPagePath.USER_MAIN;
        } else {
            request.setAttribute("errorMessage", "Incorrect information.");
            goToPage = JSPPagePath.REGISTRATION_PAGE;
        }


        RequestDispatcher dispatcher = request
                .getRequestDispatcher(goToPage);

        dispatcher.forward(request, response);

    }
}
