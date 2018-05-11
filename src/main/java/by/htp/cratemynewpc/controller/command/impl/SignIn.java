package by.htp.cratemynewpc.controller.command.impl;

import by.htp.cratemynewpc.controller.command.Command;
import by.htp.cratemynewpc.domain.PCBean;
import by.htp.cratemynewpc.domain.User;
import by.htp.cratemynewpc.service.PcService;
import by.htp.cratemynewpc.service.ServiceFactory;
import by.htp.cratemynewpc.service.UserService;
import by.htp.cratemynewpc.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SignIn implements Command {

    private static final String LOGIN_PARAM_NAME = "login";
    private static final String PASSWORD_PARAM_NAME = "password";


    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login;
        String password;

        login = request.getParameter(LOGIN_PARAM_NAME);
        password = request.getParameter(PASSWORD_PARAM_NAME);

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();


        User user = null;
        String goToPage = null;

        try {
            user = userService.signin(login, password);
            if (user != null) {
                user = userService.getUserInfo(login);
                PcService pcService = factory.getPCService();
                List<PCBean> findPC = pcService.findAllService();
                request.getSession(true).setAttribute("user", user);
                request.setAttribute("findPC", findPC);
                goToPage = JSPPagePath.USER_MAIN;
            } else {
                request.setAttribute("errorMessage", "Incorrect login or password.");
                goToPage = JSPPagePath.MAIN_PAGE;
            }

        } catch (ServiceException e) {
            //goToPage = JSPPagePath.ERROR_PAGE;
            // log
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request
                .getRequestDispatcher(goToPage);

        dispatcher.forward(request, response);

    }

}
