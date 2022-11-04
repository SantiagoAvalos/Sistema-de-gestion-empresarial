package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Usuario1;
	private JPasswordField psw_Contraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void CompUsuario()
    {
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
                 if(r.getString(1).equals(txt_Usuario1.getText()) && r.getString(2).equals(psw_Contraseña.getText()))
                 {
                     JOptionPane.showMessageDialog(rootPane, "Bienvenido "+ r.getString(1)); 
                     cont = 0;
                     r.afterLast();
                     Principal ir = new Principal();
                     ir.setVisible(true);
                     dispose(); 
                     
                 }
                 else
                 {
                   cont = cont + 1;
                 }
             }   
            if(cont != 0)
            {
              JOptionPane.showMessageDialog(rootPane, "Usuario u contraseña invalidos");   
            }
       
        }
        catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(rootPane, "No te ondies"); 
                }
        
    }
	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema gestor empresarial Northwind ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setBounds(55, 11, 423, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Porfavor Inicie sesion o registre un nuevo usuario");
		lblNewLabel_1.setBounds(150, 72, 365, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setBounds(176, 122, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contraseña:");
		lblNewLabel_3.setBounds(159, 154, 106, 14);
		contentPane.add(lblNewLabel_3);
		
		txt_Usuario1 = new JTextField();
		txt_Usuario1.setBounds(232, 119, 165, 20);
		contentPane.add(txt_Usuario1);
		txt_Usuario1.setColumns(10);
		
		JButton btn_Inicio = new JButton("Iniciar sesión");
		btn_Inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 CompUsuario();
			}
		});
		btn_Inicio.setBounds(219, 192, 120, 23);
		contentPane.add(btn_Inicio);
		
		JButton btn_Registro = new JButton("Registrarse");
		btn_Registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro ir = new Registro(); 
		        ir.setVisible(true);
		        dispose();
			}
		});
		btn_Registro.setBounds(432, 250, 120, 23);
		contentPane.add(btn_Registro);
		
		psw_Contraseña = new JPasswordField();
		psw_Contraseña.setBounds(232, 151, 165, 20);
		contentPane.add(psw_Contraseña);
	}
}
