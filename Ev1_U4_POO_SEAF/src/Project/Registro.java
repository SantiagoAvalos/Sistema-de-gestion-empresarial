package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txt_usuario;
	private JPasswordField psw_Contraseña;
	private JPasswordField psw_CContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void Registrar()
    {
        Conexion c = new Conexion();
        Connection con = c.Conectar();
        String Usuario = txt_usuario.getText(), Contrasena = psw_Contraseña.getText();
        String consulta = "insert into usuarios(Usuario, Contraseña)values (?,?)";
        try {
            PreparedStatement pre =  (PreparedStatement) con.prepareStatement(consulta);
            pre.setString(1, Usuario);
            pre.setString(2, Contrasena);            
            pre.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(rootPane, "Informacion Registrada");
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error al guardar información");
        }
    }
	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introdusca lo siguiente:");
		lblNewLabel.setBounds(90, 11, 170, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setBounds(39, 52, 77, 14);
		contentPane.add(lblNewLabel_2);
		
		txt_usuario = new JTextField();
		txt_usuario.setColumns(10);
		txt_usuario.setBounds(95, 49, 165, 20);
		contentPane.add(txt_usuario);
		
		JLabel lblNewLabel_3 = new JLabel("Contraseña:");
		lblNewLabel_3.setBounds(22, 84, 94, 14);
		contentPane.add(lblNewLabel_3);
		
		psw_Contraseña = new JPasswordField();
		psw_Contraseña.setBounds(95, 81, 165, 20);
		contentPane.add(psw_Contraseña);
		
		JLabel lblNewLabel_1 = new JLabel("Confirmar Contraseña:");
		lblNewLabel_1.setBounds(10, 127, 159, 14);
		contentPane.add(lblNewLabel_1);
		
		psw_CContraseña = new JPasswordField();
		psw_CContraseña.setBounds(149, 124, 131, 20);
		contentPane.add(psw_CContraseña);
		
		JButton jButton1 = new JButton("Finalizar");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txt_usuario.getText().isEmpty() || psw_Contraseña.getText().isEmpty() || psw_CContraseña.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(rootPane, "Rellene Todos Los Campos");
		        }else{            
		            	Conexion c = new Conexion();
		                Connection con = c.Conectar();
		                String consulta = "Select * from usuarios ";
		                Statement st;
		                int cont = 0;
		                try {
		                    st = (Statement) con.createStatement();
		                    ResultSet r = st.executeQuery(consulta);
		                     while(r.next())
		                     {
		                    	 if(r.getString(1).equals(txt_usuario.getText())  )
		                    	 {		                    		 
		                    		 cont = cont + 1;	
		                    	 }		                    	
		                    	 
		                     }  
		                     if(cont != 0)
		                     {
		                       JOptionPane.showMessageDialog(rootPane, "Este Ususario Ya existe Ingrese uno nuevo");   
		                     }
		                     else {
		                    	 if(psw_Contraseña.getText().equals(psw_CContraseña.getText()))
		  			           {
		  		                	 Registrar();      
		  		     		            txt_usuario.setText(" ");
		  		     		            psw_Contraseña.setText(" ");
		  		     		            psw_CContraseña.setText(" ");
		  		     		           r.afterLast();
		  		     		            Inicio ir = new Inicio();
		  		     		            ir.setVisible(true);
		  		     		            dispose();
		  		            }
		  		            else
		  		                 {
		  		                  JOptionPane.showMessageDialog(rootPane, "Las contraseñas no coinciden, vuelva a intentarlo");
		  		                }
		                     }
		                 }
		                 catch(Exception ex)
		                         {
		                             JOptionPane.showMessageDialog(rootPane, "No te ondies"); 
		                         }	
		                
		        }
			}
		});
		jButton1.setBounds(27, 187, 109, 23);
		contentPane.add(jButton1);
		
		JButton jButton2 = new JButton("Cancelar");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_usuario.setText(" ");
		        psw_Contraseña.setText(" ");
		        psw_CContraseña.setText(" ");
		        Inicio ir = new Inicio();
		        ir.setVisible(true);
		        dispose();
			}
		});
		jButton2.setBounds(171, 187, 109, 23);
		contentPane.add(jButton2);
	}

}
