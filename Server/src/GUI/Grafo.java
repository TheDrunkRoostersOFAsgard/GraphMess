package GUI;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Grafo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtrs = new JButton("Atrás");
	public static String[][] grafolist;
	public static int[][] matrizadya;

	/**
	 * Constructor de la ventana.
	 */
	public Grafo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal.frame.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(713, 724, 63, 20);
		contentPane.add(btnAtrs);

	}
	
	/**
	 * dibuja los nodos y las rutas entre ellos
	 */
	public void paint(Graphics g) {
		for (int i = 0; i < grafolist.length; i++) {
			for (int j = 0; j < grafolist.length; j++) {
				if (matrizadya[i][j] < 15) {
					g.drawLine(Integer.parseInt(grafolist[i][1]) + 10, Integer.parseInt(grafolist[i][2]) + 10,
							Integer.parseInt(grafolist[j][1]) + 10, Integer.parseInt(grafolist[j][2]) + 10);
					g.setColor(Color.WHITE);

					g.fillOval(Integer.parseInt(grafolist[j][1]), Integer.parseInt(grafolist[j][2]), 20, 20);
					g.setColor(Color.BLACK);

					g.drawOval(Integer.parseInt(grafolist[i][1]), Integer.parseInt(grafolist[i][2]), 20, 20);
					g.drawString("" + grafolist[i][0], Integer.parseInt(grafolist[i][1]),
							Integer.parseInt(grafolist[i][2]));

				}else{
					g.drawOval(Integer.parseInt(grafolist[i][1]), Integer.parseInt(grafolist[i][2]), 20, 20);
					g.drawString("" + grafolist[i][0], Integer.parseInt(grafolist[i][1]),
							Integer.parseInt(grafolist[i][2]));
				}
			}

		}
	}

}
