package singleton;

import org.h2.security.auth.H2AuthConfigXml;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class H2Singleton {

    private static H2Singleton  h2Singleton= null;

    private  H2Singleton() {
        String jdbcURL = "jdbc:h2:mem:";
        //String username = "sa";
        //String password = "1234";
        int a = 23;
        int b = 2;
        try (Connection con = DriverManager.getConnection(jdbcURL);
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT " + a + "+" + b)) {

            if (rs.next()) {
                System.out.println(rs.getInt(1));
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(H2Singleton.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    public static H2Singleton getInstance() {
        if (h2Singleton == null)
            h2Singleton = new H2Singleton();
        return h2Singleton;
    }

}