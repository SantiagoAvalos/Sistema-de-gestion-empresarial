package Project;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class Conexion {
	 Connection con ;
	   public Connection Conectar(){
	    
	        
	       try {
	           Class.forName("com.mysql.jdbc.Driver");
	           con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/northwind","root","");	           
	       } catch (Exception ex) {
	          JOptionPane.showMessageDialog(null, "Error de conexion");
	       }
	       return con;
	   }
}
