package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField txt_NombComp;
	private JTextField txt_NombCont;
	private JTextField txt_TituloC;
	private JTextField txt_Dirección;
	private JTextField txt_Región;
	private JTextField txt_CP;
	private JTextField txt_Telf;
	private JTextField txt_Fax;
	public static JComboBox cbx_IdCLiente = new JComboBox();
	public static JButton btn_Mod = new JButton("Modificar");
	public static JButton btn_Regresar = new JButton("Regresar");
	public static JButton btn_Borrar = new JButton("Borrar");
	public static JButton btn_Registrar = new JButton("Registrar");
	public static JButton btn_Buscar = new JButton("Buscar");
	public static int contI;
	private JTextField txt_IDC;
	private JTextField txt_Pais;
	private JTextField txt_Ciudad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Clientes() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {				
				Conexion c = new Conexion();
		        Connection con = c.Conectar();
		        String consulta = "Select * from customers order by CustomerID ASC";
		        try {
		        	PreparedStatement st =  (PreparedStatement) con.prepareStatement(consulta);
		            ResultSet r = st.executeQuery();     
		             while(r.next())
		             {           	
		            	cbx_IdCLiente.addItem(r.getString(1)); 		            	
		             }
		            
		        }
		        catch(Exception ex)
		        {
		            JOptionPane.showMessageDialog(null, "No te ondies"); 
		        }
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setBounds(169, 11, 87, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID de Cliente:");
		lblNewLabel_1.setBounds(10, 54, 128, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de Compañia:");
		lblNewLabel_2.setBounds(10, 79, 128, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre de contacto:");
		lblNewLabel_3.setBounds(10, 104, 128, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Titulo de contacto:");
		lblNewLabel_4.setBounds(10, 129, 128, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Dirección:");
		lblNewLabel_5.setBounds(10, 154, 128, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("País:");
		lblNewLabel_6.setBounds(10, 179, 128, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Ciudad:");
		lblNewLabel_7.setBounds(10, 204, 128, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Región:");
		lblNewLabel_8.setBounds(10, 229, 128, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Codigo Postal:");
		lblNewLabel_9.setBounds(10, 254, 128, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Telefono:");
		lblNewLabel_10.setBounds(10, 279, 128, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Fax:");
		lblNewLabel_11.setBounds(10, 304, 128, 14);
		contentPane.add(lblNewLabel_11);
		cbx_IdCLiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		cbx_IdCLiente.setBounds(113, 50, 212, 22);
		contentPane.add(cbx_IdCLiente);
		
		txt_NombComp = new JTextField();
		txt_NombComp.setEnabled(false);
		txt_NombComp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				 char n = evt.getKeyChar();
			        boolean LM = n >= 65 && n <= 90;
			        boolean lm = n >= 97 && n <= 122;
			        boolean num = n >= 48 && n <= 57;
			        boolean space = n == 32;
			        boolean letrañ = n == 241;
			        boolean letraÑ = n == 209;
			        if (!(LM || lm || num || space || letrañ || letraÑ) || txt_NombComp.getText().length() >= 40) {
			            evt.consume();
			        }			        			        
			}
		});
		txt_NombComp.setBounds(153, 76, 172, 20);
		contentPane.add(txt_NombComp);
		txt_NombComp.setColumns(10);
		
		txt_NombCont = new JTextField();
		txt_NombCont.setEnabled(false);
		txt_NombCont.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
		        boolean LM = n >= 65 && n <= 90;
		        boolean lm = n >= 97 && n <= 122;
		        boolean num = n >= 48 && n <= 57;
		        boolean space = n == 32;
		        boolean letrañ = n == 241;
		        boolean letraÑ = n == 209;
		        if (!(LM || lm || num || space || letrañ || letraÑ) || txt_NombCont.getText().length() >= 30) {
		            evt.consume();
		        } 
			}
		});
		txt_NombCont.setBounds(148, 101, 177, 20);
		contentPane.add(txt_NombCont);
		txt_NombCont.setColumns(10);
		
		txt_TituloC = new JTextField();
		txt_TituloC.setEnabled(false);
		txt_TituloC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
		        boolean LM = n >= 65 && n <= 90;
		        boolean lm = n >= 97 && n <= 122;
		        boolean num = n >= 48 && n <= 57;
		        boolean space = n == 32;
		        boolean letrañ = n == 241;
		        boolean letraÑ = n == 209;
		        if (!(LM || lm || num || space || letrañ || letraÑ) || txt_TituloC.getText().length() >= 30) {
		            evt.consume();
		        }
			}
		});
		txt_TituloC.setBounds(137, 126, 188, 20);
		contentPane.add(txt_TituloC);
		txt_TituloC.setColumns(10);
		
		txt_Dirección = new JTextField();
		txt_Dirección.setEnabled(false);
		txt_Dirección.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char dir = evt.getKeyChar();
		        boolean LM = dir >= 65 && dir <= 90;
		        boolean lm = dir >= 97 && dir <= 122;
		        boolean space = dir == 32;
		        boolean num = dir >= 48 && dir <= 57;
		        boolean p = dir == 46;
		        boolean letrañ = dir == 241;
		        boolean letraÑ = dir == 209;
		        if (!(LM || lm || space || num || p || letrañ || letraÑ) || txt_Dirección.getText().length() >= 60) {
		            evt.consume();
		        }
			}
		});
		txt_Dirección.setBounds(94, 151, 231, 20);
		contentPane.add(txt_Dirección);
		txt_Dirección.setColumns(10);
		
		txt_Región = new JTextField();
		txt_Región.setEnabled(false);
		txt_Región.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				 char n = evt.getKeyChar();
			        boolean LM = n >= 65 && n <= 90;
			        boolean lm = n >= 97 && n <= 122;
			        boolean num = n >= 48 && n <= 57;
			        boolean letrañ = n == 241;
			        boolean letraÑ = n == 209;
			        if (!(LM || lm || num || letrañ || letraÑ) || txt_Región.getText().length() >= 15) {
			            evt.consume();
			        }
			}
		});
		txt_Región.setBounds(84, 226, 241, 20);
		contentPane.add(txt_Región);
		txt_Región.setColumns(10);
		
		txt_CP = new JTextField();
		txt_CP.setEnabled(false);
		txt_CP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
		        boolean LM = n >= 65 && n <= 90;
		        boolean lm = n >= 97 && n <= 122;
		        boolean num = n >= 48 && n <= 57;
		        boolean letrañ = n == 241;
		        boolean letraÑ = n == 209;
		        boolean guion = n == 45;
		        if (!(LM || lm || num || letrañ || letraÑ || guion) || txt_CP.getText().length() >= 15) {
		            evt.consume();
		        }
			}
		});
		txt_CP.setBounds(116, 251, 209, 20);
		contentPane.add(txt_CP);
		txt_CP.setColumns(10);
		
		txt_Telf = new JTextField();
		txt_Telf.setEnabled(false);
		txt_Telf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
		        boolean num = n >= 48 && n <= 57;
		        if (!(num) || txt_Telf.getText().length() >= 22) {
		            evt.consume();
		        }
			}
		});
		txt_Telf.setBounds(94, 276, 231, 20);
		contentPane.add(txt_Telf);
		txt_Telf.setColumns(10);
		
		txt_Fax = new JTextField();
		txt_Fax.setEnabled(false);
		txt_Fax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
		        boolean num = n >= 48 && n <= 57;
		        boolean guion = n == 45;
		        boolean p = n == 46;
		        if (!(num || guion || p) || txt_Fax.getText().length() >= 24) {
		            evt.consume();
		        }
			}
		});
		txt_Fax.setBounds(70, 301, 255, 20);
		contentPane.add(txt_Fax);
		txt_Fax.setColumns(10);
		
		
		btn_Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion c = new Conexion();
			    Connection con = c.Conectar();
		        String consulta = "Select * from  customers  where CustomerID = " +"'"+ cbx_IdCLiente.getSelectedItem().toString()+"'";
		        Statement st;
		        try {		        	
		        	st = (Statement) con.createStatement();
		        	ResultSet r = st.executeQuery(consulta);
		            while(r.next())
		            	{		            	
						
		            	txt_NombComp.setText(r.getString(2));
						txt_NombCont.setText(r.getString(3));
						txt_TituloC.setText(r.getString(4));
						txt_Dirección.setText(r.getString(5));
						txt_Ciudad.setText(r.getString(6));
						txt_Región.setText(r.getString(7));
						txt_CP.setText(r.getString(8));
						txt_Pais.setText(r.getString(9));
						txt_Telf.setText(r.getString(10));
						txt_Fax.setText(r.getString(11));
		            	}
		        }
		        catch(Exception ex)
		        {
		            JOptionPane.showMessageDialog(null, "No te ondies"); 
		        }		        
				txt_NombComp.setEnabled(true);
				txt_NombCont.setEnabled(true);
				txt_TituloC.setEnabled(true);
				txt_Dirección.setEnabled(true);
				txt_Pais.setEnabled(true);
				txt_Ciudad.setEnabled(true);
				txt_Región.setEnabled(true);
				txt_CP.setEnabled(true);
				txt_Telf.setEnabled(true);
				txt_Fax.setEnabled(true);
				btn_Mod.setEnabled(true);
				btn_Registrar.setEnabled(true);
				btn_Borrar.setEnabled(true);
				
			}
		});
		btn_Buscar.setBounds(335, 50, 89, 23);
		contentPane.add(btn_Buscar);
		
		
		btn_Regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_NombComp.setEnabled(false);
				txt_NombCont.setEnabled(false);
				txt_TituloC.setEnabled(false);
				txt_Dirección.setEnabled(false);
				txt_Pais.setEnabled(false);
				txt_Ciudad.setEnabled(false);
				txt_Región.setEnabled(false);
				txt_CP.setEnabled(false);
				txt_Telf.setEnabled(false);
				txt_Fax.setEnabled(false);
				btn_Mod.setEnabled(false);
				btn_Registrar.setEnabled(false);
				btn_Borrar.setEnabled(false);
				cbx_IdCLiente.setEnabled(true);
            	cbx_IdCLiente.setVisible(true);
            	txt_IDC.setVisible(false);
            	txt_IDC.setEnabled(false);
            	btn_Buscar.setEnabled(true);
				Principal ir = new Principal();
		        ir.setVisible(true);
		        dispose();
			}
		});
		btn_Regresar.setBounds(335, 415, 89, 23);
		contentPane.add(btn_Regresar);
		btn_Mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion c = new Conexion();
			    Connection con = (Connection) c.Conectar();		    
			    String consulta = "Update  customers  set CompanyName = ? , ContactName = ? , ContactTitle  = ? , Address  = ? , City = ? , Region = ? , PostalCode = ? , Country = ?, Phone = ?, Fax = ?   where CustomerID = ? ";
			     try {
			            PreparedStatement pre =  (PreparedStatement) con.prepareStatement(consulta);
			            pre.setString(1, txt_NombComp.getText());
			            pre.setString(2, txt_NombCont.getText());
			            pre.setString(3, txt_TituloC.getText());
			            pre.setString(4, txt_Dirección.getText());
			            pre.setString(5, txt_Ciudad.getText());
			            pre.setString(6, txt_Región.getText());
			            pre.setString(7, txt_CP.getText());
			            pre.setString(8, txt_Pais.getText());
			            pre.setString(9, txt_Telf.getText());
			            pre.setString(10, txt_Fax.getText());
			            pre.setString(11, cbx_IdCLiente.getSelectedItem().toString());
			            pre.executeUpdate();			           
			            con.close();			        
			            JOptionPane.showMessageDialog(rootPane, "Modificación exitosa");
			            
			            txt_NombComp.setEnabled(false);
						txt_NombCont.setEnabled(false);
						txt_TituloC.setEnabled(false);
						txt_Dirección.setEnabled(false);
						txt_Pais.setEnabled(false);
						txt_Ciudad.setEnabled(false);
						txt_Región.setEnabled(false);
						txt_CP.setEnabled(false);
						txt_Telf.setEnabled(false);
						txt_Fax.setEnabled(false);
						btn_Mod.setEnabled(false);
						btn_Registrar.setEnabled(false);
						btn_Borrar.setEnabled(false);
						cbx_IdCLiente.removeAllItems();
						txt_NombComp.setText("");
						txt_NombCont.setText("");
						txt_TituloC.setText("");
						txt_Dirección.setText("");
						txt_Pais.setText("");
						txt_Ciudad.setText("");
						txt_Región.setText("");
						txt_CP.setText("");
						txt_Telf.setText("");
						txt_Fax.setText("");
			     }
			 catch (Exception ex) {
		           JOptionPane.showMessageDialog(rootPane, "Error al Modificar");
		        }
			}
		});
		
		
		btn_Mod.setEnabled(false);
		btn_Mod.setBounds(11, 360, 89, 23);
		contentPane.add(btn_Mod);
		
		
		btn_Registrar.setEnabled(false);
		btn_Registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				 
				 if(contI==0) {
						JOptionPane.showMessageDialog(rootPane, "Ingrese la informacion que desea registrar");	
						btn_Buscar.setEnabled(false);
			        	cbx_IdCLiente.setEnabled(false);
		            	cbx_IdCLiente.setVisible(false);
		            	txt_IDC.setVisible(true);
		            	txt_IDC.setEnabled(true);
		            	txt_NombComp.setText("");
						txt_NombCont.setText("");
						txt_TituloC.setText("");
						txt_Dirección.setText("");
						txt_Pais.setText("");
						txt_Ciudad.setText("");
						txt_Región.setText("");
						txt_CP.setText("");
						txt_Telf.setText("");
						txt_Fax.setText("");
						contI++;
						}
						else
						{				
							if ( txt_NombComp.getText().isEmpty() || txt_NombCont.getText().isEmpty() || txt_TituloC.getText().isEmpty() || txt_Dirección.getText().isEmpty() || txt_Región.getText().isEmpty() || txt_CP.getText().isEmpty() || txt_Telf.getText().isEmpty() || txt_Fax.getText().isEmpty()) {
					            JOptionPane.showMessageDialog(rootPane, "Rellene Todos Los Campos");
					        }else{					        	
				            	Conexion c = new Conexion();
						        Connection con = c.Conectar();	      						    
						        String consulta = "insert into customers (CustomerID ,CompanyName ,ContactName,ContactTitle,Address,City ,Region ,PostalCode,Country,Phone,Fax)values (?,?,?,?,?,?,?,?,?,?,?)";
						        try {
						        	PreparedStatement pre = (PreparedStatement) con.prepareStatement(consulta);
						        	pre.setString(1, txt_IDC.getText());
						        	pre.setString(2, txt_NombComp.getText());
							        pre.setString(3, txt_NombCont.getText());
							            pre.setString(4, txt_TituloC.getText());
							            pre.setString(5, txt_Dirección.getText());
							            pre.setString(6, txt_Ciudad.getText());
							            pre.setString(7, txt_Región.getText());
							            pre.setString(8, txt_CP.getText());
							            pre.setString(9, txt_Pais.getText());
							            pre.setString(10, txt_Telf.getText());
							            pre.setString(11, txt_Fax.getText());
							          
							            pre.executeUpdate();			           
							            con.close();	
							            JOptionPane.showMessageDialog(rootPane, "Registro exitoso");
							            txt_NombComp.setEnabled(false);
										txt_NombCont.setEnabled(false);
										txt_TituloC.setEnabled(false);
										txt_Dirección.setEnabled(false);
										txt_Pais.setEnabled(false);
										txt_Ciudad.setEnabled(false);
										txt_Región.setEnabled(false);
										txt_CP.setEnabled(false);
										txt_Telf.setEnabled(false);
										txt_Fax.setEnabled(false);
										btn_Mod.setEnabled(false);
										btn_Registrar.setEnabled(false);
										btn_Borrar.setEnabled(false);
										btn_Buscar.setEnabled(true);
							        	cbx_IdCLiente.setEnabled(true);
						            	cbx_IdCLiente.setVisible(true);
						            	txt_IDC.setVisible(false);
						            	txt_IDC.setEnabled(false);
						            	cbx_IdCLiente.removeAllItems();
										txt_NombComp.setText("");
										txt_NombCont.setText("");
										txt_TituloC.setText("");
										txt_Dirección.setText("");
										txt_Pais.setText("");
										txt_Ciudad.setText("");
										txt_Región.setText("");
										txt_CP.setText("");
										txt_Telf.setText("");
										txt_Fax.setText("");
						            
						            contI=0;
						        }
						        catch (Exception ex) {
						            JOptionPane.showMessageDialog(rootPane, "Error al guardar información");
						        }					        						         
					        }					        
						}
			}
		});
		btn_Registrar.setBounds(169, 360, 89, 23);
		contentPane.add(btn_Registrar);
		btn_Borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion c = new Conexion();
			    Connection con = (Connection) c.Conectar(); 			   
			    String consulta = "Delete from customers  where CustomerID = ?";
		        try {		        	
		        	PreparedStatement pre = (PreparedStatement) con.prepareStatement(consulta);		        		
		            pre.setString(1, cbx_IdCLiente.getSelectedItem().toString());			        		
		            pre.executeUpdate();	
		            con.close();
		            JOptionPane.showMessageDialog(rootPane, "Informacion borrada con exito");
		            txt_NombComp.setEnabled(false);
					txt_NombCont.setEnabled(false);
					txt_TituloC.setEnabled(false);
					txt_Dirección.setEnabled(false);
					txt_Pais.setEnabled(false);
					txt_Ciudad.setEnabled(false);
					txt_Región.setEnabled(false);
					txt_CP.setEnabled(false);
					txt_Telf.setEnabled(false);
					txt_Fax.setEnabled(false);
					btn_Mod.setEnabled(false);
					btn_Registrar.setEnabled(false);
					btn_Borrar.setEnabled(false);
					btn_Buscar.setEnabled(true);
		        	cbx_IdCLiente.setEnabled(true);
	            	cbx_IdCLiente.setVisible(true);
	            	txt_IDC.setVisible(false);
	            	txt_IDC.setEnabled(false);
	            	cbx_IdCLiente.removeAllItems();
					txt_NombComp.setText("");
					txt_NombCont.setText("");
					txt_TituloC.setText("");
					txt_Dirección.setText("");
					txt_Pais.setText("");
					txt_Ciudad.setText("");
					txt_Región.setText("");
					txt_CP.setText("");
					txt_Telf.setText("");
					txt_Fax.setText("");
		        }
		        catch (Exception ex) {
		            JOptionPane.showMessageDialog(rootPane, "Error al borrar información");
		        }
			}
		});
		
		
		btn_Borrar.setEnabled(false);
		btn_Borrar.setBounds(335, 360, 89, 23);
		contentPane.add(btn_Borrar);
		
		txt_IDC = new JTextField();
		txt_IDC.setVisible(false);
		txt_IDC.setEnabled(false);
		txt_IDC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
		        boolean LM = n >= 65 && n <= 90;		       		        		      		        
		        boolean letraÑ = n == 209;
		        if (!(LM || letraÑ) || txt_IDC.getText().length() >= 5) {
		            evt.consume();
		        }
			}
		});
		txt_IDC.setBounds(113, 51, 212, 20);
		contentPane.add(txt_IDC);
		txt_IDC.setColumns(10);
		
		txt_Pais = new JTextField();
		txt_Pais.setEnabled(false);
		txt_Pais.setBounds(84, 176, 241, 20);
		contentPane.add(txt_Pais);
		txt_Pais.setColumns(10);
		
		txt_Ciudad = new JTextField();
		txt_Ciudad.setEnabled(false);
		txt_Ciudad.setBounds(84, 201, 241, 20);
		contentPane.add(txt_Ciudad);
		txt_Ciudad.setColumns(10);
		

	}
}
