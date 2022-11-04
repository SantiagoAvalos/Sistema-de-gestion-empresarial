package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Productos extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Nombre;
	private JTextField txt_CPU;
	private JTextField txt_PrecioU;
	private JTextField txt_UnidadenS;
	private JTextField txt_UnidadesPE;
	private JTextField txt_NivReord;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos frame = new Productos();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static JComboBox cbx_Idproducto = new JComboBox();
	public static JComboBox cbx_proveedor = new JComboBox();
	public static JComboBox cbx_Categoria = new JComboBox();
	public static JRadioButton rdb_Si = new JRadioButton("Si");
	public static JRadioButton rdb_no = new JRadioButton("No");
	JButton btn_Modificar = new JButton("Modificar");
	JButton btn_Registrar = new JButton("Registrar");
	JButton btn_Borrar = new JButton("Borrar");
	public static int cont1 = 0;
	public static int contI = 0;
	
	public static void CargarD()
	{
		Conexion c = new Conexion();
        Connection con = c.Conectar();
        String consulta = "Select * from products order by ProductID ASC";
        try {
        	PreparedStatement st =  (PreparedStatement) con.prepareStatement(consulta);
            ResultSet r = st.executeQuery();     
             while(r.next())
             {           	
            	 cbx_Idproducto.addItem(r.getString(1)); 
            	 cbx_proveedor.addItem(r.getString(3)); 
            	 cbx_Categoria.addItem(r.getString(4));
             }
            
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "No te ondies"); 
        }
	}
	public void Buscar()
	{
		Conexion c = new Conexion();
	    Connection con = c.Conectar();
        String consulta = "Select * from products where ProductID = " + cbx_Idproducto.getSelectedItem().toString();
        Statement st;
        try {		        	
        	st = (Statement) con.createStatement();
        	ResultSet r = st.executeQuery(consulta);
            while(r.next())
            	{			
            	txt_Nombre.setText(r.getString(2));
				txt_CPU.setText(r.getString(5));
				txt_PrecioU.setText(r.getString(6));
				txt_UnidadenS.setText(r.getString(7));
				txt_UnidadesPE.setText(r.getString(8));
				txt_NivReord.setText(r.getString(9));
				if(r.getString(10).equals("0"))
				{
					rdb_no.setSelected(true);
				}
				else
				{
					rdb_Si.setSelected(true);
				}
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
	public Productos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			       		          
				CargarD();			
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Productos\r\n");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setBounds(137, 11, 177, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID del producto:\r\n");
		lblNewLabel_1.setBounds(10, 64, 129, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(10, 89, 85, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID del proveedor:");
		lblNewLabel_3.setBounds(10, 114, 109, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ID de Categoria: ");
		lblNewLabel_4.setBounds(10, 139, 129, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad por unidad:\r\n");
		lblNewLabel_5.setBounds(10, 164, 131, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Precio unitario:\r\n\r\n");
		lblNewLabel_6.setBounds(10, 189, 129, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Unidades en stock:");
		lblNewLabel_7.setBounds(10, 214, 129, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Unidades por encargo:");
		lblNewLabel_8.setBounds(10, 239, 129, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Nivel de reordenamiento:");
		lblNewLabel_9.setBounds(10, 264, 149, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("¿Descontinuado?");
		lblNewLabel_10.setBounds(10, 289, 109, 14);
		contentPane.add(lblNewLabel_10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar();
				CargarD();
				cbx_proveedor.setEnabled(true);
				cbx_Categoria.setEnabled(true);
				txt_Nombre.setEnabled(true);
				txt_CPU.setEnabled(true);
				txt_PrecioU.setEnabled(true);
				txt_UnidadenS.setEnabled(true);
				txt_UnidadesPE.setEnabled(true);
				txt_NivReord.setEnabled(true);
				rdb_Si.setEnabled(true);
				rdb_no.setEnabled(true);
				btn_Modificar.setEnabled(true);
				btn_Registrar.setEnabled(true);
				btn_Borrar.setEnabled(true);
			}
		});
		btnNewButton.setBounds(289, 60, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btn_Reg = new JButton("Regresar");
		btn_Reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal ir = new Principal();
				txt_Nombre.setEnabled(false);
				txt_CPU.setEnabled(false);
				txt_PrecioU.setEnabled(false);
				txt_UnidadenS.setEnabled(false);
				txt_UnidadesPE.setEnabled(false);
				txt_NivReord.setEnabled(false);
				rdb_Si.setEnabled(false);
				rdb_no.setEnabled(false);
		        ir.setVisible(true);
		        dispose();
			}
		});
		btn_Reg.setBounds(289, 377, 89, 23);
		contentPane.add(btn_Reg);
		
		JButton btn_Categoria = new JButton("Categorias");
		btn_Categoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categorias ir = new Categorias();
		        ir.setVisible(true);
		        dispose();
			}
		});
		btn_Categoria.setBounds(10, 377, 109, 23);
		contentPane.add(btn_Categoria);
		cbx_Idproducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cont1!= 0)
				{
				Conexion c = new Conexion();
			    Connection con = c.Conectar();
		        String consulta = "Select * from products where ProductID = " + cbx_Idproducto.getSelectedItem().toString();
		        Statement st;
		        try {		        	
		        	st = (Statement) con.createStatement();
		        	ResultSet r = st.executeQuery(consulta);
		            while(r.next())
		            	{						            	
		            	 cbx_proveedor.removeAllItems();		            	 	            	
		            	 cbx_Categoria.removeAllItems();		            			            	 			        
		            	 cbx_proveedor.addItem(r.getString(3));
		            	 cbx_Categoria.addItem(r.getString(4));

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
		
		cbx_Idproducto.setBounds(105, 60, 161, 22);
		contentPane.add(cbx_Idproducto);		
		
		txt_Nombre = new JTextField();
		txt_Nombre.setEnabled(false);
		txt_Nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				 char n = evt.getKeyChar();
			        boolean num = n >= 48 && n <= 57;
			        boolean LM = n >= 65 && n <= 90;
			        boolean lm = n >= 97 && n <= 122;
			        boolean letrañ = n == 241;
			        boolean letraÑ = n == 209;
			        boolean p = n == 46;
			        boolean espacio = n == 32;
			        boolean coma = n == 44;
			        if (!(num || LM || lm || letrañ || letraÑ || p || espacio || coma) || txt_Nombre.getText().length() >=40) {
			            evt.consume();
			        }
			}
		});
		txt_Nombre.setBounds(66, 86, 200, 20);
		contentPane.add(txt_Nombre);
		txt_Nombre.setColumns(10);
		cbx_proveedor.setEnabled(false);
		
		
		cbx_proveedor.setBounds(118, 110, 148, 22);
		contentPane.add(cbx_proveedor);
		cbx_Categoria.setEnabled(false);
		cbx_Categoria.setBounds(103, 135, 163, 22);
		contentPane.add(cbx_Categoria);
		
		txt_CPU = new JTextField();
		txt_CPU.setEnabled(false);
		txt_CPU.addKeyListener(new KeyAdapter() {
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
		        if (!(num || LM || lm || letrañ || letraÑ || p || guion || espacio || coma) || txt_CPU.getText().length() >= 20) {
		            evt.consume();
		        }
			}
		});
		txt_CPU.setBounds(134, 161, 132, 20);
		contentPane.add(txt_CPU);
		txt_CPU.setColumns(10);
		
		txt_PrecioU = new JTextField();
		txt_PrecioU.setEnabled(false);
		txt_PrecioU.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				 char n = evt.getKeyChar();
			        boolean num = n >= 48 && n <= 57;
			        boolean p = n == 46;
			        if (!(num || p) || txt_PrecioU.getText().length() >= 20) {
			            evt.consume();
			        }
			}
		});
		txt_PrecioU.setBounds(105, 186, 161, 20);
		contentPane.add(txt_PrecioU);
		txt_PrecioU.setColumns(10);
		
		txt_UnidadenS = new JTextField();
		txt_UnidadenS.setEnabled(false);
		txt_UnidadenS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
		        boolean num = n >= 48 && n <= 57;
		        if (!(num) || txt_UnidadenS.getText().length() >= 6) {
		            evt.consume();
		        }
			}
		});
		txt_UnidadenS.setBounds(124, 211, 142, 20);
		contentPane.add(txt_UnidadenS);
		txt_UnidadenS.setColumns(10);
		
		txt_UnidadesPE = new JTextField();
		txt_UnidadesPE.setEnabled(false);
		txt_UnidadesPE.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				 char n = evt.getKeyChar();
			        boolean num = n >= 48 && n <= 57;
			        if (!(num) || txt_UnidadesPE.getText().length() >= 6) {
			            evt.consume();
			        }
			}
		});
		txt_UnidadesPE.setBounds(142, 236, 124, 20);
		contentPane.add(txt_UnidadesPE);
		txt_UnidadesPE.setColumns(10);
		
		txt_NivReord = new JTextField();
		txt_NivReord.setEnabled(false);
		txt_NivReord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char n = evt.getKeyChar();
		        boolean num = n >= 48 && n <= 57;
		        if (!(num) || txt_NivReord.getText().length() >= 6) {
		            evt.consume();
		        }
			}
		});
		txt_NivReord.setBounds(162, 261, 104, 20);
		contentPane.add(txt_NivReord);
		txt_NivReord.setColumns(10);
		
		
		rdb_Si.setEnabled(false);
		buttonGroup.add(rdb_Si);
		rdb_Si.setBounds(137, 285, 40, 23);
		contentPane.add(rdb_Si);
		
		
		rdb_no.setEnabled(false);
		buttonGroup.add(rdb_no);
		rdb_no.setBounds(220, 285, 46, 23);
		contentPane.add(rdb_no);
		btn_Modificar.setEnabled(false);
		
		
		btn_Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Conexion c = new Conexion();
			     Connection con = (Connection) c.Conectar(); 
			     int IdP = Integer.parseInt(cbx_Idproducto.getSelectedItem().toString());
			     String Nombre = txt_Nombre.getText(), CantPU = txt_CPU.getText();
			     int ProvID = Integer.parseInt(cbx_proveedor.getSelectedItem().toString());
			     int CatID = Integer.parseInt(cbx_Categoria.getSelectedItem().toString());
			     int UniES = Integer.parseInt(txt_UnidadenS.getText()), UniPE = Integer.parseInt(txt_UnidadesPE.getText());
			     int NivR = Integer.parseInt(txt_NivReord.getText());
			     double PU = Double.parseDouble(txt_PrecioU.getText());
			     String consulta = "Update products set ProductName = ? , SupplierID = ? , CategoryID = ? , QuantityPerUnit = ? , UnitPrice = ? , UnitsInStock = ? , UnitsOnOrder = ? , ReorderLevel = ? , Discontinued = ?  where ProductID = ? ";
			     try {
			            PreparedStatement pre =  (PreparedStatement) con.prepareStatement(consulta);
			            pre.setString(1, Nombre);
			            pre.setInt(2, ProvID);
			            pre.setInt(3, CatID);
			            pre.setString(4, CantPU);
			            pre.setDouble(5, PU);
			            pre.setInt(6, UniES);
			            pre.setInt(7, UniPE);
			            pre.setInt(8, NivR);
			            if(rdb_Si.isSelected())
			            {
			            	pre.setInt(9, 1);
			            }
			            else
			            {
			            	pre.setInt(9, 0);
			            }
			            pre.setInt(10, IdP);			           
			            pre.executeUpdate();			           
			            con.close();
			            cbx_proveedor.setEnabled(false);
			            cbx_Categoria.setEnabled(false);
			        	txt_Nombre.setEnabled(false);
						txt_CPU.setEnabled(false);
						txt_PrecioU.setEnabled(false);
						txt_UnidadenS.setEnabled(false);
						txt_UnidadesPE.setEnabled(false);
						txt_NivReord.setEnabled(false);
						rdb_Si.setEnabled(false);
						rdb_no.setEnabled(false);
						btn_Modificar.setEnabled(false);
						btn_Registrar.setEnabled(false);
						btn_Borrar.setEnabled(false);
						
						txt_Nombre.setText("");
						txt_CPU.setText("");
						txt_PrecioU.setText("");
						txt_UnidadenS.setText("");
						txt_UnidadesPE.setText("");
						txt_NivReord.setText("");
						rdb_Si.setSelected(false);
						rdb_no.setSelected(false);
			            JOptionPane.showMessageDialog(rootPane, "Modificación exitosa");
			     }
			 catch (Exception ex) {
		           JOptionPane.showMessageDialog(rootPane, "Error al Modificar");
		        }
			     cbx_Idproducto.removeAllItems();
			}
		});
		btn_Modificar.setBounds(10, 331, 89, 23);
		contentPane.add(btn_Modificar);
		btn_Registrar.setEnabled(false);
		
		
		btn_Registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txt_Nombre.getText().isEmpty() || txt_CPU.getText().isEmpty() || txt_PrecioU.getText().isEmpty() || txt_UnidadenS.getText().isEmpty() || txt_UnidadesPE.getText().isEmpty() || txt_NivReord.getText().isEmpty() || (rdb_Si.isSelected() == false && rdb_no.isSelected() == false)) {
		            JOptionPane.showMessageDialog(rootPane, "Rellene Todos Los Campos");
		        }
				else {
				if(contI==0) {
				JOptionPane.showMessageDialog(rootPane, "Ingrese la informacion que desea registrar");
				cbx_Idproducto.setEnabled(false);
				txt_Nombre.setText("");
				txt_CPU.setText("");
				txt_PrecioU.setText("");
				txt_UnidadenS.setText("");
				txt_UnidadesPE.setText("");
				txt_NivReord.setText("");
				rdb_Si.setSelected(false);
				rdb_no.setSelected(false);
				contI++;
				}
				else
				{				
			        Conexion c = new Conexion();
			        Connection con = c.Conectar();	      
				     String Nombre = txt_Nombre.getText(), CantPU = txt_CPU.getText();
				     int ProvID = Integer.parseInt(cbx_proveedor.getSelectedItem().toString());
				     int CatID = Integer.parseInt(cbx_Categoria.getSelectedItem().toString());
				     int UniES = Integer.parseInt(txt_UnidadenS.getText()), UniPE = Integer.parseInt(txt_UnidadesPE.getText());
				     int NivR = Integer.parseInt(txt_NivReord.getText());
				     double PU = Double.parseDouble(txt_PrecioU.getText());
			        String consulta = "insert into products(ProductName,SupplierID,CategoryID,QuantityPerUnit,UnitPrice,UnitsInStock,UnitsOnOrder,ReorderLevel,Discontinued)values (?,?,?,?,?,?,?,?,?)";
			        try {
			        	PreparedStatement pre = (PreparedStatement) con.prepareStatement(consulta);
			            pre.setString(1, Nombre);
			            pre.setInt(2, ProvID);
			            pre.setInt(3, CatID);
			            pre.setString(4, CantPU);
			            pre.setDouble(5, PU);
			            pre.setInt(6, UniES);
			            pre.setInt(7, UniPE);
			            pre.setInt(8, NivR);
			            if(rdb_Si.isSelected())
			            {
			            	pre.setInt(9, 1);
			            }
			            else
			            {
			            	pre.setInt(9, 0);
			            }			           
			            pre.executeUpdate();			           
			            con.close();
			            cbx_proveedor.setEnabled(false);
			            cbx_Categoria.setEnabled(false);
			            cbx_Idproducto.setEnabled(true);
			        	txt_Nombre.setEnabled(false);
						txt_CPU.setEnabled(false);
						txt_PrecioU.setEnabled(false);
						txt_UnidadenS.setEnabled(false);
						txt_UnidadesPE.setEnabled(false);
						txt_NivReord.setEnabled(false);
						rdb_Si.setEnabled(false);
						rdb_no.setEnabled(false);
						
						txt_Nombre.setText("");
						txt_CPU.setText("");
						txt_PrecioU.setText("");
						txt_UnidadenS.setText("");
						txt_UnidadesPE.setText("");
						txt_NivReord.setText("");
						rdb_Si.setSelected(false);
						rdb_no.setSelected(false);
						btn_Modificar.setEnabled(false);
						btn_Registrar.setEnabled(false);
						btn_Borrar.setEnabled(false);
			            JOptionPane.showMessageDialog(rootPane, "Registro exitoso");
			            contI=0;
			        }
			        catch (Exception ex) {
			            JOptionPane.showMessageDialog(rootPane, "Error al guardar información");
			        }
			        cbx_Idproducto.removeAllItems();
				}
			}
			}
		});
		btn_Registrar.setBounds(137, 331, 89, 23);
		contentPane.add(btn_Registrar);
		
	
		btn_Borrar.setEnabled(false);
		btn_Borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Conexion c = new Conexion();
			     Connection con = (Connection) c.Conectar(); 
			     int IdP = Integer.parseInt(cbx_Idproducto.getSelectedItem().toString());
			     String consulta1 = "Delete from orderdetails where ProductID = ?";
			     String consulta2 = "Delete from products where ProductID = ?";
			        try {
			        	PreparedStatement pre = (PreparedStatement) con.prepareStatement(consulta1);
			        	PreparedStatement pre2 = (PreparedStatement) con.prepareStatement(consulta2);
			        	pre.setInt(1, IdP);	
			        	pre2.setInt(1, IdP);	
			            pre.executeUpdate();	
			            pre2.executeUpdate();	
			            con.close();
			            JOptionPane.showMessageDialog(rootPane, "Informacion borrada con exito");
			            cbx_proveedor.setEnabled(false);
			            cbx_Categoria.setEnabled(false);
			        	txt_Nombre.setEnabled(false);
						txt_CPU.setEnabled(false);
						txt_PrecioU.setEnabled(false);
						txt_UnidadenS.setEnabled(false);
						txt_UnidadesPE.setEnabled(false);
						txt_NivReord.setEnabled(false);
						rdb_Si.setEnabled(false);
						rdb_no.setEnabled(false);
						btn_Modificar.setEnabled(false);
						btn_Registrar.setEnabled(false);
						btn_Borrar.setEnabled(false);							
						
						txt_Nombre.setText("");
						txt_CPU.setText("");
						txt_PrecioU.setText("");
						txt_UnidadenS.setText("");
						txt_UnidadesPE.setText("");
						txt_NivReord.setText("");
						rdb_Si.setSelected(false);
						rdb_no.setSelected(false);
			        }
			        catch (Exception ex) {
			            JOptionPane.showMessageDialog(rootPane, "Error al borrar información");
			        }
			        cbx_Idproducto.removeAllItems();
			}
		});
		btn_Borrar.setBounds(269, 331, 89, 23);
		contentPane.add(btn_Borrar);
		
		
	}
	
}
