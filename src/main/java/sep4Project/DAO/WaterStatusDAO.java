package sep4Project.DAO;

import sep4Project.Model.WaterStatusModel;
import sep4Project.Server.Conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WaterStatusDAO {

    public List<WaterStatusModel> getWaterStatus() {
        Conn c = new Conn();
        String sql = "SELECT * FROM thermaldata";
        List<WaterStatusModel> returnValues = new ArrayList<>();

        try {
            PreparedStatement stmt = c.getConnection().prepareStatement(sql);
            ResultSet sqlReturnValues = stmt.executeQuery();

            while (sqlReturnValues.next()) {
                returnValues.add(new WaterStatusModel(
                        sqlReturnValues.getString("SolarPanelID"),
                        sqlReturnValues.getTimestamp("DateAndTime"),
                        sqlReturnValues.getDouble("WaterConsumption")));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return returnValues;
    }

    public List<WaterStatusModel> getWaterStatusByID(String ID) {
        Conn c = new Conn();
        String sql = "SELECT * FROM thermaldata WHERE \"SolarPanelID\" = " + "'" + ID + "'";
        List<WaterStatusModel> returnValues = new ArrayList<>();

        try {
            PreparedStatement stmt = c.getConnection().prepareStatement(sql);
            ResultSet sqlReturnValues = stmt.executeQuery();

            while (sqlReturnValues.next()) {
                returnValues.add(new WaterStatusModel(
                        sqlReturnValues.getString("SolarPanelID"),
                        sqlReturnValues.getTimestamp("DateAndTime"),
                        sqlReturnValues.getDouble("WaterConsumption")));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return returnValues;
    }

}