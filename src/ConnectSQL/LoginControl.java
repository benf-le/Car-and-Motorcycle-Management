package ConnectSQL;

import javax.swing.*;
import java.sql.*;

public class LoginControl {
    private Connection conn;
    private ResultSet rs;
    private Statement sm;
    private Boolean check;

    public Boolean checkLogin(String user, String pass) {
        try {
            conn = Connect.getConnection();
            sm = conn.createStatement();

            String sql = "SELECT * FROM Account_Management WHERE Account LIKE N\'" + user + "\' and Pass LIKE N\'" + pass + "\'";


            rs = sm.executeQuery(sql);

            check = rs.next();

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return check;
    }
}