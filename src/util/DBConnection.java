package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/HospitalDB";// Change if needed
        String user = "root";       
        String password = "yourpasswordhere";   
        return DriverManager.getConnection(url, user, password);
    }
}
