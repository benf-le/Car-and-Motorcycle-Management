package ConnectSQL;
import java.sql.*;

public class Connect {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        String dbURL = "jdbc:sqlserver://localhost:1433;encrypt=false;DatabaseName=Quan_ly_dang_ky_xe_may_oto;user=sa;password=123";
        return DriverManager.getConnection(dbURL);

    }
}



