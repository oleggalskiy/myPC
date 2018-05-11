package by.htp.cratemynewpc.controller.command.impl;

import by.htp.cratemynewpc.controller.command.Command;
import by.htp.cratemynewpc.domain.PCBean;
import by.htp.cratemynewpc.service.PcService;
import by.htp.cratemynewpc.service.ServiceFactory;
import by.htp.cratemynewpc.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteUserPC implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pcId = Integer.parseInt(request.getParameter("pcId"));
        String login = request.getParameter("login");
        String goToPage = null;
        ServiceFactory factory = ServiceFactory.getInstance();
        try {
            factory.getPCService().deleteService(pcId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        try {
            PcService pcService = factory.getPCService();
            List<PCBean> findPC = pcService.findAllService();
            request.setAttribute("findPC", findPC);
        }catch(ServiceException e)
        {
            //TODO log
        }

        request.setAttribute("login", login);

        try {
            goToPage = JSPPagePath.USER_MAIN;
            request.getRequestDispatcher(goToPage).forward(request, response);

        } catch (ServletException | IOException e) {
            //TODO log;
        }
    }

}

