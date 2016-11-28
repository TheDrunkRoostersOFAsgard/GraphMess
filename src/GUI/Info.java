package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
/**
 * 
 * @author Hernaldo
 *
 */
public class Info extends JFrame {

	private JPanel contentPane;
	public static JLabel nombre = new JLabel("");
	public static JLabel estado = new JLabel("");
	public static JTextPane visor = new JTextPane();
	/**
	 * Constructor de la ventana.
	 */
	public Info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMensajes = new JLabel("Mensajes");
		lblMensajes.setBounds(32, 75, 61, 16);
		contentPane.add(lblMensajes);
		
		JButton btnNewButton = new JButton("Atrás");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal.frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(464, 425, 73, 16);
		contentPane.add(btnNewButton);
		
		
		nombre.setBounds(32, 37, 129, 16);
		contentPane.add(nombre);
		
		
		estado.setBounds(322, 37, 129, 16);
		contentPane.add(estado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 103, 479, 310);
		contentPane.add(scrollPane);
		
		
		visor.setEditable(false);
		scrollPane.setViewportView(visor);
	
	}
}
