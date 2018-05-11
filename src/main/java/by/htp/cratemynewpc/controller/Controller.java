package by.htp.cratemynewpc.controller;

import by.htp.cratemynewpc.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {


    private static final String COMMAND_PARAM_NAME = "command";


    private final CommandProvider provider = new CommandProvider();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String commandName = request.getParameter(COMMAND_PARAM_NAME);
        System.out.println("commandNAme=" + commandName);
        Command command = provider.getCommand(commandName);

        command.execute(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
