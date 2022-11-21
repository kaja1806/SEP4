package sep4Project.DAO;

import javafx.scene.control.DatePicker;
import sep4Project.Model.PanelInstallationModel;
import sep4Project.Server.Conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PanelInstallationDAO {

    public List<PanelInstallationModel> GetAllPanelInstallationData() {
        Conn c = new Conn();
        String sql = "SELECT * FROM solarpanel";  //parametirized statement
        List<PanelInstallationModel> returnValues = new ArrayList<>();

        try {
            PreparedStatement stmt = c.getConnection().prepareStatement(sql);
            ResultSet sqlReturnValues = stmt.executeQuery();

            while (sqlReturnValues.next()) {
                returnValues.add(new PanelInstallationModel(
                        sqlReturnValues.getString("id"),
                        sqlReturnValues.getDate("InstallDate"),
                        sqlReturnValues.getString("Placement"),
                        sqlReturnValues.getString("PanelType"),
                        sqlReturnValues.getString("Manufacturer")));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return returnValues;
    }

    public List<PanelInstallationModel> getPanelInstallationByID(String ID) {
        Conn c = new Conn();
        String sql = "SELECT * FROM solarpanel WHERE \"id\" = " + "'" + ID + "'";
        List<PanelInstallationModel> returnValues = new ArrayList<>();

        try {

            PreparedStatement stmt = c.getConnection().prepareStatement(sql);
            ResultSet sqlReturnValues = stmt.executeQuery();

            while (sqlReturnValues.next()) {
                returnValues.add(new PanelInstallationModel(
                        sqlReturnValues.getString("id"),
                        sqlReturnValues.getDate("InstallDate"),
                        sqlReturnValues.getString("Placement"),
                        sqlReturnValues.getString("PanelType"),
                        sqlReturnValues.getString("Manufacturer")));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return returnValues;
    }

    public List<PanelInstallationModel> getPanelInstallationByDate(DatePicker installDate) {
        Conn c = new Conn();
        String sql = "SELECT * FROM solarpanel WHERE \"InstallDate\" = " + "'" + installDate.getValue() + "'";
        List<PanelInstallationModel> returnValues = new ArrayList<>();

        try {

            PreparedStatement stmt = c.getConnection().prepareStatement(sql);
            ResultSet sqlReturnValues = stmt.executeQuery();

            while (sqlReturnValues.next()) {
                returnValues.add(new PanelInstallationModel(
                        sqlReturnValues.getString("id"),
                        sqlReturnValues.getDate("InstallDate"),
                        sqlReturnValues.getString("Placement"),
                        sqlReturnValues.getString("PanelType"),
                        sqlReturnValues.getString("Manufacturer")));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return returnValues;
    }


}
