package sep4Project.DAO;

import sep4Project.Model.ContactInfoModel;
import sep4Project.Server.Conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ContactInfoDAO {

    Conn c = new Conn();


    public List<ContactInfoModel> getAllContactInfo() {
        String sql = "SELECT * FROM manufacturer";
        List<ContactInfoModel> returnValues = new ArrayList<>();

        try {
            PreparedStatement stmt = c.getConnection().prepareStatement(sql);
            ResultSet sqlReturnValues = stmt.executeQuery();

            while (sqlReturnValues.next()) {
                returnValues.add(new ContactInfoModel(
                        sqlReturnValues.getString("id"),
                        sqlReturnValues.getString("Name"),
                        sqlReturnValues.getString("Address"),
                        sqlReturnValues.getString("Phone"),
                        sqlReturnValues.getString("Email")
                ));
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return returnValues;
    }

    public boolean createManufacturerData(String name, String address, String phone, String email) {

       // INSERT INTO manufacturer VALUES ('test','fdsaf','fdasf','fdsafdas');
        String sql = "INSERT INTO manufacturer VALUES ('" + name+ "' ," + "'" + address + "' ," + "'" + phone+ "'," + "'" + email+ "')";

        try {
            Statement stmt = c.getConnection().createStatement();
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to update :" + e);
        }
        return false;
    }


    public boolean deleteManufacturer(String manufacturerID) {
        String sql = "DELETE FROM manufacturer WHERE \"id\" = " + "'" + manufacturerID + "'";
        try {
            Statement stmt = c.getConnection().createStatement();
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to delete :" + e);
        }
        return false;
    }

    public boolean updateManufacturerData(ContactInfoModel contactInfoModel, String manufacturerID) {
        String sql = "UPDATE manufacturer SET \"Name\" =" + "'" + contactInfoModel.getName() + "' ," +
                "\"Address\" =" + "'" + contactInfoModel.getAddress() + "'," +
                "\"Phone\" = " + "'" + contactInfoModel.getPhone() + "'," +
                "\"Email\" = " + "'" + contactInfoModel.getEmail() + "'" +
                "WHERE id = " + "'" + manufacturerID + "'";

        try {
            Statement stmt = c.getConnection().createStatement();
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to update :" + e);
        }
        return false;
    }
}
