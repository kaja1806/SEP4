package sep4Project.DAO;

import sep4Project.Model.EnergyStatusModel;
import sep4Project.Server.Conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EnergyStatusDAO {

    public List<EnergyStatusModel> getEnergyStatus() {
        Conn c = new Conn();
        String sql = "SELECT * FROM pvdata";
        List<EnergyStatusModel> returnValues = new ArrayList<>();

        try {
            PreparedStatement stmt = c.getConnection().prepareStatement(sql);
            ResultSet sqlReturnValues = stmt.executeQuery();

            while (sqlReturnValues.next()) {
                returnValues.add(new EnergyStatusModel(
                        sqlReturnValues.getTimestamp("DateAndTime"),
                        sqlReturnValues.getDouble("Voltage"),
                        sqlReturnValues.getDouble("Current"),
                        sqlReturnValues.getDouble("Resistance"),
                        sqlReturnValues.getDouble("Power"),
                        sqlReturnValues.getDouble("Efficiency"),
                        sqlReturnValues.getString("SolarPanelID")));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return returnValues;
    }

    public List<EnergyStatusModel> getEnergyStatusByID(String ID) {
        Conn c = new Conn();
        String sql = "SELECT * FROM pvdata WHERE \"SolarPanelID\" = " + "'" + ID + "'";
        List<EnergyStatusModel> returnValues = new ArrayList<>();

        try {

            PreparedStatement stmt = c.getConnection().prepareStatement(sql);
            ResultSet sqlReturnValues = stmt.executeQuery();

            while (sqlReturnValues.next()) {
                returnValues.add(new EnergyStatusModel(
                        sqlReturnValues.getTimestamp("DateAndTime"),
                        sqlReturnValues.getDouble("Voltage"),
                        sqlReturnValues.getDouble("Current"),
                        sqlReturnValues.getDouble("Resistance"),
                        sqlReturnValues.getDouble("Power"),
                        sqlReturnValues.getDouble("Efficiency"),
                        sqlReturnValues.getString("SolarPanelID")));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return returnValues;
    }
}

