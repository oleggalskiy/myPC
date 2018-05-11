package by.htp.cratemynewpc.controller.command.impl;

import by.htp.cratemynewpc.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Localization implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String local = request.getParameter("local");
        request.getSession(true).setAttribute("local", local);

        RequestDispatcher dispatcher = request
                .getRequestDispatcher(JSPPagePath.MAIN_PAGE);

        dispatcher.forward(request, response);
    }

}
