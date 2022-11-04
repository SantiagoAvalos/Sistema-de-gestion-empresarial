package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ordenes extends JFrame {

	private JPanel contentPane;
	private JTextField txt_FO;
	private JTextField txt_FR;
	private JTextField txt_DE;
	private JTextField txt_ViadeEnvio;
	private JTextField txt_Transporte;
	private JTextField txt_NombEnv;
	private JTextField txt_DiccEnv;
	private JTextField txt_CE;
	private JTextField txt_RegionEnv;
	private JTextField txt_EnvCP;
	private JTextField txt_PE;
	JComboBox cbx_IDO = new JComboBox();
	JComboBox cbx_IDC = new JComboBox();
	JComboBox cbx_IDE = new JComboBox();
	JButton btn_Mod = new JButton("Modificar");
	JButton btn_Buscar = new JButton("Buscar");
	JButton btn_Borrar = new JButton("Borrar");
	JButton btn_Registrar = new JButton("Registrar");
	public int cont1 =0;
	public int contI = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ordenes frame = new Ordenes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public void CargarD()
{
	Conexion c = new Conexion();
    Connection con = c.Conectar();
    String consulta = "Select * from  orders  order by OrderID ASC";
    try {
    	PreparedStatement st =  (PreparedStatement) con.prepareStatement(consulta);
        ResultSet r = st.executeQuery();
        
         while(r.next())
         {
        	 cbx_IDO.addItem(r.getString(1));
        	 cbx_IDC.addItem(r.getString(2));
        	 cbx_IDE.addItem(r.getString(3));
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
	public Ordenes() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
           	 
			}
			@Override
			public void windowOpened(WindowEvent e) {
				CargarD();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ordenes");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setBounds(152, 11, 93, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID de Cliente:");
		lblNewLabel_1.setBounds(10, 79, 118, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID de Empleado:");
		lblNewLabel_2.setBounds(10, 104, 118, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de Orden:");
		lblNewLabel_3.setBounds(10, 129, 118, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha requerida:");
		lblNewLabel_4.setBounds(10, 154, 118, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Dia de envío:");
		lblNewLabel_5.setBounds(10, 179, 118, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Vía de envio:");
		lblNewLabel_6.setBounds(10, 204, 118, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Carga:");
		lblNewLabel_7.setBounds(10, 229, 118, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nombre de envio:");
		lblNewLabel_8.setBounds(10, 254, 118, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Dirección de envío:");
		lblNewLabel_9.setBounds(10, 279, 118, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Ciudad de envío:");
		lblNewLabel_10.setBounds(10, 304, 118, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Región de envío:");
		lblNewLabel_11.setBounds(10, 329, 118, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Codigo postal del envío:");
		lblNewLabel_12.setBounds(10, 354, 188, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Pais de envío:");
		lblNewLabel_13.setBounds(10, 379, 118, 14);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("ID de Orden:");
		lblNewLabel_14.setBounds(10, 54, 102, 14);
		contentPane.add(lblNewLabel_14);
		cbx_IDO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cont1!= 0)
				{
				Conexion c = new Conexion();
			    Connection con = c.Conectar();
		        String consulta = "Select * from orders where OrderID = " + cbx_IDO.getSelectedItem().toString();
		        Statement st;
		        try {		        	
		        	st = (Statement) con.createStatement();
		        	ResultSet r = st.executeQuery(consulta);
		            while(r.next())
		            	{						            	
		            	 cbx_IDC.removeAllItems();		            	 	            	
		            	 cbx_IDE.removeAllItems();		            			            	 			        
		            	 cbx_IDC.addItem(r.getString(2));
		            	 cbx_IDE.addItem(r.getString(3));

		            	}
		           		                   
			}
		        catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(rootPane, "No te ondies"); 
                }
			}
				cont1++;
			}
		});
		
		
		cbx_IDO.setBounds(122, 50, 179, 22);
		contentPane.add(cbx_IDO);
		
		
		cbx_IDC.setEnabled(false);
		cbx_IDC.setBounds(125, 75, 176, 22);
		contentPane.add(cbx_IDC);
		
		
		cbx_IDE.setEnabled(false);
		cbx_IDE.setBounds(138, 100, 163, 22);
		contentPane.add(cbx_IDE);
		
		txt_FO = new JTextField();
		txt_FO.setEnabled(false);
		txt_FO.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
		        boolean num = n >= 48 && n <= 57;
		        boolean p = n == 46;
		        boolean guion = n == 45;
		        if (!(num || p || guion) || txt_FO.getText().length() >=10) {
		            evt.consume();
		        }
			}
		});
		txt_FO.setBounds(140, 126, 161, 20);
		contentPane.add(txt_FO);
		txt_FO.setColumns(10);
		
		txt_FR = new JTextField();
		txt_FR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
		        boolean num = n >= 48 && n <= 57;
		        boolean p = n == 46;
		        boolean guion = n == 45;
		        if (!(num || p || guion) || txt_FR.getText().length() >=10) {
		            evt.consume();
		        }
			}
		});
		txt_FR.setEnabled(false);
		txt_FR.setBounds(141, 151, 160, 20);
		contentPane.add(txt_FR);
		txt_FR.setColumns(10);
		
		txt_DE = new JTextField();
		txt_DE.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
		        boolean num = n >= 48 && n <= 57;
		        boolean p = n == 46;
		        boolean guion = n == 45;
		        if (!(num || p || guion) || txt_DE.getText().length() >=10) {
		            evt.consume();
		        }
			}
		});
		txt_DE.setEnabled(false);
		txt_DE.setBounds(122, 176, 179, 20);
		contentPane.add(txt_DE);
		txt_DE.setColumns(10);
		
		txt_ViadeEnvio = new JTextField();
		txt_ViadeEnvio.setEnabled(false);
		txt_ViadeEnvio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
		        boolean num = n >= 48 && n <= 57;
		        if (!(num) || txt_ViadeEnvio.getText().length() >=11) {
		            evt.consume();
		        }
			}
		});
		txt_ViadeEnvio.setBounds(121, 201, 180, 20);
		contentPane.add(txt_ViadeEnvio);
		txt_ViadeEnvio.setColumns(10);
		
		txt_Transporte = new JTextField();
		txt_Transporte.setEnabled(false);
		txt_Transporte.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
		        boolean num = n >= 48 && n <= 57;
		        boolean p = n == 46;
		        if (!(num || p) || txt_Transporte.getText().length() >=20) {
		            evt.consume();
		        }
			}
		});
		txt_Transporte.setBounds(92, 226, 209, 20);
		contentPane.add(txt_Transporte);
		txt_Transporte.setColumns(10);
		
		txt_NombEnv = new JTextField();
		txt_NombEnv.setEnabled(false);
		txt_NombEnv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
				boolean num = n >= 48 && n <= 57;
		        boolean LM = n >= 65 && n <= 90;
		        boolean lm = n >= 97 && n <= 122;
		        boolean letrañ = n == 241;
		        boolean letraÑ = n == 209;
		        boolean p = n == 46;
		        boolean guion = n == 45;
		        boolean espacio = n == 32;
		        if (!(num || LM || lm || letrañ || letraÑ || p || guion || espacio) || txt_NombEnv.getText().length() >=40) {
		            evt.consume();
		        }
			}
		});
		txt_NombEnv.setBounds(144, 251, 157, 20);
		contentPane.add(txt_NombEnv);
		txt_NombEnv.setColumns(10);
		
		txt_DiccEnv = new JTextField();
		txt_DiccEnv.setEnabled(false);
		txt_DiccEnv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
			      char n = evt.getKeyChar();
			        boolean num = n >= 48 && n <= 57;
			        boolean LM = n >= 65 && n <= 90;
			        boolean lm = n >= 97 && n <= 122;
			        boolean letrañ = n == 241;
			        boolean letraÑ = n == 209;
			        boolean p = n == 46;
			        boolean guion = n == 45;
			        boolean espacio = n == 32;
			        boolean coma = n == 44;
			        if (!(num || LM || lm || letrañ || letraÑ || p || guion || espacio || coma) || txt_DiccEnv.getText().length() >=60) {
			            evt.consume();
			        }
			}
		});
		txt_DiccEnv.setBounds(150, 276, 151, 20);
		contentPane.add(txt_DiccEnv);
		txt_DiccEnv.setColumns(10);
		
		txt_CE = new JTextField();
		txt_CE.setEnabled(false);
		txt_CE.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				 char n = evt.getKeyChar();
			        boolean num = n >= 48 && n <= 57;
			        boolean LM = n >= 65 && n <= 90;
			        boolean lm = n >= 97 && n <= 122;
			        boolean letrañ = n == 241;
			        boolean letraÑ = n == 209;
			        if (!(num || LM || lm || letrañ || letraÑ) || txt_RegionEnv.getText().length() >= 15) {
			            evt.consume();
			        }
			}
		});
		txt_CE.setBounds(140, 301, 161, 20);
		contentPane.add(txt_CE);
		txt_CE.setColumns(10);
		
		txt_RegionEnv = new JTextField();
		txt_RegionEnv.setEnabled(false);
		txt_RegionEnv.setBounds(140, 326, 161, 20);
		contentPane.add(txt_RegionEnv);
		txt_RegionEnv.setColumns(10);
		
		txt_EnvCP = new JTextField();
		txt_EnvCP.setEnabled(false);
		txt_EnvCP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				 char n = evt.getKeyChar();
			        boolean num = n >= 48 && n <= 57;
			        boolean LM = n >= 65 && n <= 90;
			        boolean lm = n >= 97 && n <= 122;
			        boolean letrañ = n == 241;
			        boolean letraÑ = n == 209;
			        boolean guion = n == 45;
			        if (!(num || LM || lm || letrañ || letraÑ || guion) || txt_EnvCP.getText().length() >=10) {
			            evt.consume();
			        }
			}
		});
		txt_EnvCP.setBounds(174, 351, 127, 20);
		contentPane.add(txt_EnvCP);
		txt_EnvCP.setColumns(10);
		
		txt_PE = new JTextField();
		txt_PE.setEnabled(false);
		txt_PE.setBounds(126, 376, 175, 20);
		contentPane.add(txt_PE);
		txt_PE.setColumns(10);
		
		JButton btn_Reg = new JButton("Regresar");
		btn_Reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal ir = new Principal();
		        ir.setVisible(true);
		        dispose();
			}
		});
		btn_Reg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
		});
		btn_Reg.setBounds(350, 477, 89, 23);
		contentPane.add(btn_Reg);
		btn_Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbx_IDC.removeAllItems();
				
				CargarD();
				Conexion c = new Conexion();
			    Connection con = c.Conectar();
		        String consulta = "Select * from orders where OrderID = " + cbx_IDO.getSelectedItem().toString();
		        Statement st;
		        try {		        	
		        	st = (Statement) con.createStatement();
		        	ResultSet r = st.executeQuery(consulta);		        	
		            while(r.next())
		            	{				            	
		            	cbx_IDC.setSelectedItem(r.getObject(2));
		            	cbx_IDE.setSelectedItem(r.getInt(3));
		            	txt_FO.setText(r.getString(4));		            	
		            	txt_FR.setText(r.getString(5));
		            	txt_DE.setText(r.getString(6));
		            	txt_ViadeEnvio.setText(r.getString(7));
		            	txt_Transporte.setText(r.getString(8));
		            	txt_NombEnv.setText(r.getString(9));
		            	txt_DiccEnv.setText(r.getString(10));
		            	txt_CE.setText(r.getString(11));
		            	txt_RegionEnv.setText(r.getString(12));
		            	txt_EnvCP.setText(r.getString(13));
		            	txt_PE.setText(r.getString(14));		            	
		            	}		            
		            cbx_IDC.setEnabled(true);
		            cbx_IDE.setEnabled(true);
		            txt_FO.setEnabled(true);
	            	txt_FR.setEnabled(true);
	            	txt_DE.setEnabled(true);
	            	txt_ViadeEnvio.setEnabled(true);
	            	txt_Transporte.setEnabled(true);
	            	txt_NombEnv.setEnabled(true);
	            	txt_DiccEnv.setEnabled(true);
	            	txt_CE.setEnabled(true);
	            	txt_RegionEnv.setEnabled(true);
	            	txt_EnvCP.setEnabled(true);
	            	txt_PE.setEnabled(true);
		            btn_Mod.setEnabled(true);
		            btn_Registrar.setEnabled(true);
		            btn_Borrar.setEnabled(true);		    
		        }
		            catch(Exception ex)
		            {
		                JOptionPane.showMessageDialog(null, "No te ondies"); 
		            }			 		  		        
			}
		});
		
		
		btn_Buscar.setBounds(311, 50, 89, 23);
		contentPane.add(btn_Buscar);
		btn_Mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion c = new Conexion();
			     Connection con = (Connection) c.Conectar();			     
			     String consulta = "UPDATE orders set CustomerID = ?, EmployeeID = ?, OrderDate = ?, RequiredDate = ?, ShippedDate = ?, ShipVia = ?, Freight = ?, ShipName = ?, ShipAddress = ?, ShipCity = ?, ShipRegion = ?, ShipPostalCode = ?, ShipCountry = ? where OrderID = ?";			     
			     try {
			            PreparedStatement pre =  (PreparedStatement) con.prepareStatement(consulta);			          
			            pre.setInt(14, Integer.parseInt(cbx_IDO.getSelectedItem().toString()));
			            pre.setString(1, cbx_IDC.getSelectedItem().toString());
			            pre.setInt(2, Integer.parseInt(cbx_IDE.getSelectedItem().toString()));
			            pre.setString(3, txt_FO.getText());
			            pre.setString(4, txt_FR.getText());
			            pre.setString(5, txt_DE.getText());
			            pre.setInt(6, Integer.parseInt(txt_ViadeEnvio.getText()));
			            pre.setDouble(7, Double.parseDouble(txt_Transporte.getText()));
			            pre.setString(8, txt_NombEnv.getText());
			            pre.setString(9, txt_DiccEnv.getText());
			            pre.setString(10, txt_CE.getText());
			            pre.setString(11, txt_RegionEnv.getText());
			            pre.setString(12, txt_EnvCP.getText());
			            pre.setString(13, txt_PE.getText());		           
			            pre.executeUpdate();			           
			            con.close();
			            JOptionPane.showMessageDialog(rootPane, "Modificación exitosa");
			            
			            cbx_IDC.setEnabled(false);
			            cbx_IDE.setEnabled(false);
			            txt_FO.setEnabled(false);
		            	txt_FR.setEnabled(false);
		            	txt_DE.setEnabled(false);
		            	txt_ViadeEnvio.setEnabled(false);
		            	txt_Transporte.setEnabled(false);
		            	txt_NombEnv.setEnabled(false);
		            	txt_DiccEnv.setEnabled(false);
		            	txt_CE.setEnabled(false);
		            	txt_RegionEnv.setEnabled(false);
		            	txt_EnvCP.setEnabled(false);
		            	txt_PE.setEnabled(false);
			            btn_Mod.setEnabled(false);
			            btn_Registrar.setEnabled(false);
			            btn_Borrar.setEnabled(false);	
			            
			            txt_FO.setText("");
		            	txt_FR.setText("");
		            	txt_DE.setText("");
		            	txt_ViadeEnvio.setText("");
		            	txt_Transporte.setText("");
		            	txt_NombEnv.setText("");
		            	txt_DiccEnv.setText("");
		            	txt_CE.setText("");
		            	txt_RegionEnv.setText("");
		            	txt_EnvCP.setText("");
		            	txt_PE.setText("");			            
			     }
				 catch (Exception ex) {
			           JOptionPane.showMessageDialog(rootPane, "Error al Modificar");
			        }			     	
		            cbx_IDC.removeAllItems();
					cbx_IDE.removeAllItems();
					CargarD();
			}
		});
		
		
		btn_Mod.setEnabled(false);
		btn_Mod.setBounds(10, 432, 89, 23);
		contentPane.add(btn_Mod);
		btn_Borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion c = new Conexion();
			     Connection con = (Connection) c.Conectar(); 
			     String consulta2 = "Delete from orderdetails where OrderID = ?";
			     String consulta = "Delete from orders where OrderID = ?";
			        try {
			        	PreparedStatement pre1 = (PreparedStatement) con.prepareStatement(consulta2);
			        	PreparedStatement pre = (PreparedStatement) con.prepareStatement(consulta);
			        	pre1.setInt(1, Integer.parseInt(cbx_IDO.getSelectedItem().toString()));	
			            pre1.executeUpdate();
			            pre.setInt(1, Integer.parseInt(cbx_IDO.getSelectedItem().toString()));	
			            pre.executeUpdate();
			            con.close();
			            JOptionPane.showMessageDialog(rootPane, "Informacion borrada con exito");
			            cbx_IDC.setEnabled(false);
			            cbx_IDE.setEnabled(false);
			            txt_FO.setEnabled(false);
		            	txt_FR.setEnabled(false);
		            	txt_DE.setEnabled(false);
		            	txt_ViadeEnvio.setEnabled(false);
		            	txt_Transporte.setEnabled(false);
		            	txt_NombEnv.setEnabled(false);
		            	txt_DiccEnv.setEnabled(false);
		            	txt_CE.setEnabled(false);
		            	txt_RegionEnv.setEnabled(false);
		            	txt_EnvCP.setEnabled(false);
		            	txt_PE.setEnabled(false);
			            btn_Mod.setEnabled(false);
			            btn_Registrar.setEnabled(false);
			            btn_Borrar.setEnabled(false);	
			            
			            txt_FO.setText("");
		            	txt_FR.setText("");
		            	txt_DE.setText("");
		            	txt_ViadeEnvio.setText("");
		            	txt_Transporte.setText("");
		            	txt_NombEnv.setText("");
		            	txt_DiccEnv.setText("");
		            	txt_CE.setText("");
		            	txt_RegionEnv.setText("");
		            	txt_EnvCP.setText("");
		            	txt_PE.setText("");	
			        }
			        catch (Exception ex) {
			            JOptionPane.showMessageDialog(rootPane, "Error al borrar información");
			        }			        
			}
		});
		
		
		btn_Borrar.setEnabled(false);
		btn_Borrar.setBounds(311, 432, 89, 23);
		contentPane.add(btn_Borrar);
		btn_Registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contI==0) {
					JOptionPane.showMessageDialog(rootPane, "Ingrese la informacion que desea registrar");
					txt_FO.setText("");
	            	txt_FR.setText("");
	            	txt_DE.setText("");
	            	txt_ViadeEnvio.setText("");
	            	txt_Transporte.setText("");
	            	txt_NombEnv.setText("");
	            	txt_DiccEnv.setText("");
	            	txt_CE.setText("");
	            	txt_RegionEnv.setText("");
	            	txt_EnvCP.setText("");
	            	txt_PE.setText("");
	            	cbx_IDO.setEnabled(false);
					contI++;
					}
					else
					{										
				        Conexion c = new Conexion();
				        Connection con = c.Conectar();	      					        					   
				        String consulta = "Insert into orders (CustomerID,EmployeeID,OrderDate,RequiredDate,ShippedDate,ShipVia,Freight,ShipName,ShipAddress,ShipCity,ShipRegion,ShipPostalCode,ShipCountry) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
				        try {
				        	PreparedStatement pre = (PreparedStatement) con.prepareStatement(consulta);				        	
				        	pre.setString(1, cbx_IDC.getSelectedItem().toString());
				            pre.setInt(2, Integer.parseInt(cbx_IDE.getSelectedItem().toString()));
				            pre.setString(3, txt_FO.getText()+" 00:00:00");
				            pre.setString(4, txt_FR.getText()+" 00:00:00");
				            pre.setString(5, txt_DE.getText()+" 00:00:00");
				            pre.setInt(6, Integer.parseInt(txt_ViadeEnvio.getText()));
				            pre.setDouble(7, Double.parseDouble(txt_Transporte.getText()));
				            pre.setString(8, txt_NombEnv.getText());
				            pre.setString(9, txt_DiccEnv.getText());
				            pre.setString(10, txt_CE.getText());
				            pre.setString(11, txt_RegionEnv.getText());
				            pre.setString(12, txt_EnvCP.getText());
				            pre.setString(13, txt_PE.getText());	
				            pre.executeUpdate();
				            con.close();
				            JOptionPane.showMessageDialog(rootPane, "Registro exitoso");
				            contI=0;
				            
				            cbx_IDC.setEnabled(false);
				            cbx_IDE.setEnabled(false);
				            txt_FO.setEnabled(false);
			            	txt_FR.setEnabled(false);
			            	txt_DE.setEnabled(false);
			            	txt_ViadeEnvio.setEnabled(false);
			            	txt_Transporte.setEnabled(false);
			            	txt_NombEnv.setEnabled(false);
			            	txt_DiccEnv.setEnabled(false);
			            	txt_CE.setEnabled(false);
			            	txt_RegionEnv.setEnabled(false);
			            	txt_EnvCP.setEnabled(false);
			            	txt_PE.setEnabled(false);
				            btn_Mod.setEnabled(false);
				            btn_Registrar.setEnabled(false);
				            btn_Borrar.setEnabled(false);	
				            cbx_IDO.setEnabled(true);
				            
				            txt_FO.setText("");
			            	txt_FR.setText("");
			            	txt_DE.setText("");
			            	txt_ViadeEnvio.setText("");
			            	txt_Transporte.setText("");
			            	txt_NombEnv.setText("");
			            	txt_DiccEnv.setText("");
			            	txt_CE.setText("");
			            	txt_RegionEnv.setText("");
			            	txt_EnvCP.setText("");
			            	txt_PE.setText("");	
				        }
				        catch (Exception ex) {
				            JOptionPane.showMessageDialog(rootPane, "Error al guardar información");
				        }
				        //cbx_IDC.removeAllItems();
						//cbx_IDE.removeAllItems();
						//CargarD();
					}
			}
		});
		
		
		btn_Registrar.setEnabled(false);
		btn_Registrar.setBounds(165, 432, 89, 23);
		contentPane.add(btn_Registrar);
	}

}
