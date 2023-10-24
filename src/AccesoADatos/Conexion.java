
package AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    
    
    private static final String url ="jdbc:mariadb://localhost:3306/";
    private static final String bd="nutriprueba";
    private static final String usuario="root";
    private static final String password="";
    
    private static Connection connection;
    
    private Conexion(){}
    
    public static Connection getconexion(){
        
        if(connection==null){
            
            try{
                Class.forName("org.mariadb.jdbc.Driver");
                
                connection=DriverManager.getConnection(url+bd,usuario,password);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error al conectarse a la DB " + ex.getMessage());
            }catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Error al cargar los drivers " + ex.getMessage());
            }
        }
        
       return connection; 
    }
    
}
