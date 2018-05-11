package by.htp.cratemynewpc.service.impl;


import by.htp.cratemynewpc.dao.DAOFactory;
import by.htp.cratemynewpc.dao.PcDAO;
import by.htp.cratemynewpc.dao.exception.DAOException;
import by.htp.cratemynewpc.domain.PCBean;
import by.htp.cratemynewpc.service.PcService;
import by.htp.cratemynewpc.service.exception.ServiceException;


import java.util.List;

public class PCServiceImpl implements PcService {
    @Override
    public PCBean findService(Integer id) throws ServiceException {
        return null;
    }

    @Override
    public PCBean saveService(PCBean domain) throws ServiceException {
        return null;
    }

    @Override
    public void updateService(PCBean domain) throws ServiceException {

    }

    @Override
    public void deleteService(Integer id) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        PcDAO dao = factory.getPcDAO();
        try {
            dao.deleteDAO(id);
        }catch (DAOException e){
            throw new ServiceException("!!!UserPC not del",e);
        }
    }

    @Override
    public List<PCBean> findAllService() throws ServiceException {

        DAOFactory factory = DAOFactory.getInstance();
        PcDAO dao = factory.getPcDAO();

        List<PCBean> findallPC = null;
        try {
            findallPC = dao.findAllDAO();
        } catch (DAOException e) {
            throw new ServiceException("message!!!! change", e);
        }

        return findallPC;
    }
}
