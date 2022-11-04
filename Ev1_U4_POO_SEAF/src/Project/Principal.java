package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvendio al sistema de gestion empresarial Northwind");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(47, 11, 523, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Que area desea administrar?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(174, 36, 258, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btn_Productos = new JButton("Productos");
		btn_Productos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Productos ir = new Productos();
			        ir.setVisible(true);
			        dispose();
			}
		});
		btn_Productos.setBounds(151, 92, 97, 41);
		contentPane.add(btn_Productos);
		
		JButton btn_Ordenes = new JButton("Ordenes");
		btn_Ordenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Ordenes ir = new Ordenes();
			        ir.setVisible(true);
			        dispose();
			}
		});
		btn_Ordenes.setBounds(292, 92, 102, 41);
		contentPane.add(btn_Ordenes);
		
		JButton btn_Clientes = new JButton("Clientes");
		btn_Clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes ir = new Clientes();
		        ir.setVisible(true);
		        dispose();
			}
		});
		btn_Clientes.setBounds(220, 174, 102, 41);
		contentPane.add(btn_Clientes);
	}

}
