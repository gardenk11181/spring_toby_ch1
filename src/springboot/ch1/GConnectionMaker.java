package springboot.ch1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GConnectionMaker implements ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db_spring","springuser","springuser"
        );
        return c;
    }
}
