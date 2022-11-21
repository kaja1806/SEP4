package sep4Project.Helpers;

import sep4Project.Server.Conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_Authentication {

    public static int uid = -1;
    private static ResultSet resultSet = null;

    public static int isValid(String name, String pass) {
        Conn c = new Conn();
        String sql = "SELECT * FROM login WHERE \"User\" = " + "'" + name + "'" + "AND \"Password\" = " + "'" + pass + "'";

        try {
            PreparedStatement stmt = c.getConnection().prepareStatement(sql);
            ResultSet sqlReturnValues = stmt.executeQuery();

            while (sqlReturnValues.next()) {
                uid = sqlReturnValues.getInt("ID");
            }
            return uid;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return uid;
    }
}
