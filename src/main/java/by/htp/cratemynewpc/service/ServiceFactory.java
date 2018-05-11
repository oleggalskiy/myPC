package by.htp.cratemynewpc.service;

import by.htp.cratemynewpc.service.impl.PCServiceImpl;
import by.htp.cratemynewpc.service.impl.UserServiceImpl;


public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final PcService pcService =  new PCServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public PcService getPCService() {
        return pcService;
    }
}
