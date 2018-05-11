package by.htp.cratemynewpc.dao.impl;

import by.htp.cratemynewpc.dao.PcDAO;
import by.htp.cratemynewpc.dao.connectionpool.ConnectionPool;
import by.htp.cratemynewpc.dao.exception.DAOException;
import by.htp.cratemynewpc.domain.PCBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLpcDAO implements PcDAO {
    @Override
    public PCBean findDAO(Integer id) throws DAOException {

        ResultSet rs = null;
        ArrayList<PCBean> findAllPC = new ArrayList<>();
        PCBean findPC = null;
        ConnectionPool conPool = ConnectionPool.getInstance();
        try (Connection connection = conPool.takeConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT pc.*, cpu.*, mb.*, ddr.*, vga.* FROM pc JOIN cpu_has_pc chp ON pc.ID_PC = chp.PC_ID_PC JOIN cpu ON chp.CPU_ID_CPU = cpu.ID_CPU JOIN mb_has_pc pc2 ON pc.ID_PC = pc2.PC_ID_PC JOIN mb ON pc2.MB_ID_MB = mb.ID_MB JOIN ddr_has_pc pc3 ON pc.ID_PC = pc3.PC_ID_PC JOIN ddr ON pc3.DDR_ID_DDR = ddr.ID_DDR JOIN vga_has_pc vhp ON pc.ID_PC = vhp.PC_ID_PC JOIN vga v2 ON vhp.VGA_ID_VGA = v2.ID_VGA JOIN vga on vhp.VGA_ID_VGA = vga.ID_VGA WHERE ID_CPU = ? ORDER BY ID_PC");
            statement.setString(1,String.valueOf(id));
            rs = statement.executeQuery();
            while(rs.next()){
                findPC = new PCBean();
                findPC.setIdPC(rs.getString(1));
                findPC.setDate(rs.getString(3));
                findPC.setPcCPU(rs.getString(6));
                findPC.setPcMb(rs.getString(15));
                findPC.setPcRam(rs.getString(24));
                findPC.setPcVga(rs.getString(32));
                           }

        } catch (SQLException | InterruptedException e) {
            throw new DAOException("message foe change", e);
        }
        return findPC;
    }


    @Override
    public PCBean saveDAO(PCBean domain) throws DAOException {
        return null;
    }

    @Override
    public void updateDAO(PCBean domain) throws DAOException {

    }

    @Override
    public void deleteDAO(Integer id) throws DAOException {

        ConnectionPool conPool = ConnectionPool.getInstance();
        try (Connection connection = conPool.takeConnection())
        {

            PreparedStatement statement = connection.prepareStatement("DELETE FROM pc WHERE (ID_PC=?)");
            statement.setString(1, Integer.toString(id));
            statement.executeUpdate();
        }catch (SQLException | InterruptedException e) {
            throw new DAOException("message foe change", e);
        }
    }

    @Override
    public List<PCBean> findAllDAO() throws DAOException {
         ResultSet rs = null;
         ArrayList<PCBean> findAllPC = new ArrayList<>();

        ConnectionPool conPool = ConnectionPool.getInstance();
        try (Connection connection = conPool.takeConnection()){
             PreparedStatement statement = connection.prepareStatement("SELECT pc.*, cpu.*, mb.*, ddr.*, vga.* FROM pc JOIN cpu_has_pc chp ON pc.ID_PC = chp.PC_ID_PC JOIN cpu ON chp.CPU_ID_CPU = cpu.ID_CPU JOIN mb_has_pc pc2 ON pc.ID_PC = pc2.PC_ID_PC JOIN mb ON pc2.MB_ID_MB = mb.ID_MB JOIN ddr_has_pc pc3 ON pc.ID_PC = pc3.PC_ID_PC JOIN ddr ON pc3.DDR_ID_DDR = ddr.ID_DDR JOIN vga_has_pc vhp ON pc.ID_PC = vhp.PC_ID_PC JOIN vga v2 ON vhp.VGA_ID_VGA = v2.ID_VGA JOIN vga on vhp.VGA_ID_VGA = vga.ID_VGA ORDER BY ID_PC");
            rs = statement.executeQuery();

            while(rs.next()){
                PCBean pc = new PCBean();
                pc.setIdPC(rs.getString(1));
                pc.setDate(rs.getString(3));
                pc.setPcCPU(rs.getString(6));
                pc.setPcMb(rs.getString(15));
                pc.setPcRam(rs.getString(24));
                pc.setPcVga(rs.getString(32));
                findAllPC.add(pc);
            }

        } catch (SQLException | InterruptedException e) {
            throw new DAOException("message foe change", e);
        }
        return findAllPC;
    }
}
