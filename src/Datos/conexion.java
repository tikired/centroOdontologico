package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {

    public conexion() {
    }
    
    public Connection conectar(){
        
        Connection link = null;
        try {
            link = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "administrador", "admin");
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return link;
        }
    }
