package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Component;

public class Categorias extends JFrame {

	private JPanel contentPane;
	private JTextField txt_NombC;
	
	public static JComboBox cbx_IDC = new JComboBox();
	public static JTextPane txp_Des = new JTextPane();
	public static JButton btn_Mod = new JButton("Modificar");
	public static JButton btn_Regis = new JButton("Registrar");
	public static JButton btn_Borrar = new JButton("Borrar");
	public static int contI = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categorias frame = new Categorias();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void CargarD()
	{
		Conexion c = new Conexion();
        Connection con = c.Conectar();
        String consulta = "Select * from categories order by CategoryID ASC";
        try {
        	PreparedStatement st =  (PreparedStatement) con.prepareStatement(consulta);
            ResultSet r = st.executeQuery();
            
             while(r.next())
             {
            	 cbx_IDC.addItem(r.getString(1));
             }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "No te ondies"); 
        }
	}
	/**
	 * Create the frame.
	 */
	public Categorias() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				cbx_IDC.removeAllItems();
				CargarD();				
				txp_Des.setText("");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Categorias");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setBounds(129, 11, 115, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID de Categoria:");
		lblNewLabel_1.setBounds(10, 75, 128, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de categoria:");
		lblNewLabel_2.setBounds(10, 100, 142, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Descripcion");
		lblNewLabel_3.setBounds(156, 136, 88, 14);
		contentPane.add(lblNewLabel_3);
		txp_Des.setEnabled(false);
		
		
		txp_Des.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {				 
			        if (txp_Des.getText().length() >= 100) {
			            evt.consume();
			        }
			}
		});
		txp_Des.setBounds(35, 161, 295, 64);
		contentPane.add(txp_Des);
		
		txt_NombC = new JTextField();
		txt_NombC.setEnabled(false);
		txt_NombC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
		        boolean LM = n >= 65 && n <= 90;
		        boolean lm = n >= 97 && n <= 122;
		        if (!(LM || lm) || txt_NombC.getText().length() >= 15) {
		            evt.consume();
		        }
			}
		});
		txt_NombC.setBounds(172, 97, 86, 20);
		contentPane.add(txt_NombC);
		txt_NombC.setColumns(10);
		
		
		cbx_IDC.setBounds(148, 71, 110, 22);
		contentPane.add(cbx_IDC);
		
		JButton btn_Reg = new JButton("Regresar");
		btn_Reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_NombC.setEnabled(false);
				txp_Des.setEnabled(false);
				btn_Mod.setEnabled(false);
				btn_Regis.setEnabled(false);
				btn_Borrar.setEnabled(false);
				 Productos ir = new Productos();
			        ir.setVisible(true);
			        dispose();
			}
		});
		btn_Reg.setBounds(286, 329, 89, 23);
		contentPane.add(btn_Reg);
		
		JButton btn_Buscar = new JButton("Buscar");
		btn_Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
					Conexion c = new Conexion();
				    Connection con = c.Conectar();
			        String consulta = "Select * from categories where CategoryID = " + cbx_IDC.getSelectedItem().toString();
			        Statement st;
			        try {		        	
			        	st = (Statement) con.createStatement();
			        	ResultSet r = st.executeQuery(consulta);
			            while(r.next())
			            	{		
			            	txt_NombC.setText(r.getString(2));
			            	txp_Des.setText(r.getString(3));
			            	}
			            txt_NombC.setEnabled(true);
			            txp_Des.setEnabled(true);
			            btn_Mod.setEnabled(true);
			            btn_Regis.setEnabled(true);
			            btn_Borrar.setEnabled(true);
			        }
			            catch(Exception ex)
			            {
			                JOptionPane.showMessageDialog(null, "No te ondies"); 
			            }
			}
		});
		btn_Buscar.setBounds(286, 71, 89, 23);
		contentPane.add(btn_Buscar);
		btn_Mod.setEnabled(false);
		btn_Mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion c = new Conexion();
			     Connection con = (Connection) c.Conectar();
			     int IDC = Integer.parseInt(cbx_IDC.getSelectedItem().toString());
			     String Des = txp_Des.getText(), name = txt_NombC.getText();
			     String consulta = "Update categories set CategoryName = ? , Description = ? where CategoryID = ?";
			     try {
			            PreparedStatement pre =  (PreparedStatement) con.prepareStatement(consulta);
			            pre.setString(1, name);
			            pre.setString(2, Des);
			            pre.setInt(3, IDC);
			            pre.executeUpdate();			           
			            con.close();
			            JOptionPane.showMessageDialog(rootPane, "Modificación exitosa");
			            txt_NombC.setText("");
			            txt_NombC.setEnabled(false);
						txp_Des.setEnabled(false);
						btn_Mod.setEnabled(false);
						btn_Regis.setEnabled(false);
						btn_Borrar.setEnabled(false);
			     }
				 catch (Exception ex) {
			           JOptionPane.showMessageDialog(rootPane, "Error al Modificar");
			        }
			}
		});
		
		
		btn_Mod.setBounds(10, 268, 89, 23);
		contentPane.add(btn_Mod);
		btn_Regis.setEnabled(false);
		btn_Regis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( txt_NombC.getText().length() == 0 || txp_Des.getText().length() == 0) {
		            JOptionPane.showMessageDialog(rootPane, "Rellene Todos Los Campos");
		        }else {
					if(contI==0) {
						JOptionPane.showMessageDialog(rootPane, "Ingrese la informacion que desea registrar");
						txt_NombC.setText("");
						txp_Des.setText("");
						cbx_IDC.setEnabled(false);						
						contI++;
						}
						else
						{				
					        Conexion c = new Conexion();
					        Connection con = c.Conectar();	      					        
						    String Des = txp_Des.getText(), name = txt_NombC.getText();
					        String consulta = "insert into categories(CategoryName,Description)values (?,?)";
					        try {
					        	PreparedStatement pre = (PreparedStatement) con.prepareStatement(consulta);
					        	pre.setString(1, name);
					            pre.setString(2, Des);
					            pre.executeUpdate();			           
					            con.close();
					            txt_NombC.setText("");
					            txp_Des.setText("");
					            txt_NombC.setEnabled(false);
								txp_Des.setEnabled(false);
								btn_Mod.setEnabled(false);
								btn_Regis.setEnabled(false);
								btn_Borrar.setEnabled(false);
					            cbx_IDC.setEnabled(true);
					            
					            JOptionPane.showMessageDialog(rootPane, "Registro exitoso");
					            contI=0;
					        }
					        catch (Exception ex) {
					            JOptionPane.showMessageDialog(rootPane, "Error al guardar información");
					        }
						}
					}
			}
		});
		
		
		btn_Regis.setBounds(148, 268, 89, 23);
		contentPane.add(btn_Regis);
		btn_Borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion c = new Conexion();
			     Connection con = (Connection) c.Conectar(); 
			     int IDC = Integer.parseInt(cbx_IDC.getSelectedItem().toString());
			     String consulta = "Delete from categories where CategoryID = ?";
			        try {
			        	PreparedStatement pre = (PreparedStatement) con.prepareStatement(consulta);
			        	pre.setInt(1, IDC);	
			            pre.executeUpdate();
			            con.close();
			            JOptionPane.showMessageDialog(rootPane, "Informacion borrada con exito");
			            txt_NombC.setText("");
			            txp_Des.setText("");
			            txt_NombC.setEnabled(false);
						txp_Des.setEnabled(false);
						btn_Mod.setEnabled(false);
						btn_Regis.setEnabled(false);
						btn_Borrar.setEnabled(false);
			        }
			        catch (Exception ex) {
			            JOptionPane.showMessageDialog(rootPane, "Error al borrar información");
			        }
			}
		});
		
		
		btn_Borrar.setEnabled(false);
		btn_Borrar.setBounds(286, 268, 89, 23);
		contentPane.add(btn_Borrar);
		
	}
}
