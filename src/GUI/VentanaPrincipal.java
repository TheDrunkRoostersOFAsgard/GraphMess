package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Hernaldo
 *
 */
public class VentanaPrincipal extends JFrame implements Runnable {
	static VentanaPrincipal frame = new VentanaPrincipal();
	private static String[][] grafolist = { { "se", "200", "200" }, { "juan", "100", "100" }, { "manu", "50", "50" },
			{ "Steven", "300", "300" }, { "made", "20", "100", }, { "kfc", "300", "40" } };
	private static int[][] matrizadya = { { 0, 1, 2, 20, 30, 15 }, { 1, 0, 5, 6, 30, 3 }, { 2, 5, 0, 3, 40, 30 },
			{ 20, 6, 3, 0, 20, 90 }, { 30, 30, 40, 20, 0, 80 }, { 15, 2, 30, 90, 90, 0 } };
	private JPanel contentPane;
	private static String UserList[][] = { { "nano", "ola", "", "inactivo" }, { "juan", "hola", "", "activo" },
			{ "gera", "bala", "", "baneado" }, { "manu", "hola", "", "activo" }, { "Steven", "hola", "", "activo" },
			{ "vero", "hola", "", "inactivo" }, { "made", "hola", "", "activo" }, { "kfc", "hola", "", "activo" },
			{ "maria", "hola", "", "inactivo" }, { "angelique", "hola", "", "activo" },
			{ "pedro", "hola", "", "baneado" }, { "melany", "hola", "", "inactivo" },
			{ "deilyn", "hola", "", "activo" }, { "joselyn", "hola", "", "activo" },
			{ "nanda", "hola", "", "inactivo" }, { "luis", "hola", "", "baneado" }, { "ramon", "hola", "", "activo" },
			{ "mariana", "hola", "", "activo" }, { "susan", "hola", "", "activo" }, { "krissia", "hola", "", "activo" },
			{ "lexy", "hola", "", "activo" }, { "roy", "hola", "", "baneado" }, { "adrian", "hola", "", "baneado" },
			{ "antonio", "hola", "", "baneado" }, { "daniel", "hola", "", "baneado" },
			{ "ramiro", "hola", "", "inactivo" }, { "andres", "hola", "", "inactivo" },
			{ "paz", "hola", "", "inactivo" }, { "jimena", "hola", "", "inactivo" },
			{ "rossmery", "hola", "", "activo" } };
	static Info info = new Info();

	private Thread hilo;

	JButton btnNewButton = new JButton("");
	JButton usu1 = new JButton("");
	JButton usu2 = new JButton("");
	JButton usu3 = new JButton("");
	JButton usu4 = new JButton("");
	JButton usu5 = new JButton("");
	JButton usu6 = new JButton("");
	JButton usu7 = new JButton("");
	JButton usu8 = new JButton("");
	JButton usu9 = new JButton("");
	JButton usu10 = new JButton("");
	JButton usu11 = new JButton("");
	JButton usu12 = new JButton("");
	JButton usu13 = new JButton("");
	JButton usu14 = new JButton("");
	JButton usu15 = new JButton("");
	JButton usu16 = new JButton("");
	JButton usu17 = new JButton("");
	JButton usu18 = new JButton("");
	JButton usu19 = new JButton("");
	JButton usu20 = new JButton("");
	JButton usu21 = new JButton("");
	JButton usu22 = new JButton("");
	JButton usu23 = new JButton("");
	JButton usu24 = new JButton("");
	JButton usu25 = new JButton("");
	JButton usu26 = new JButton("");
	JButton usu27 = new JButton("");
	JButton usu28 = new JButton("");
	JButton usu29 = new JButton("");
	JButton usu30 = new JButton("");
	/**
	 * Funcion para llenar los botones con los nombres de los usuarios
	 */
	public void run() {
		int contusuarios = 0;
		JButton[] listausuarios = { usu1, usu2, usu3, usu4, usu5, usu6, usu7, usu8, usu9, usu10, usu11, usu12, usu13,
				usu14, usu15, usu16, usu17, usu18, usu19, usu20, usu21, usu22, usu23, usu24, usu25, usu26, usu27, usu28,
				usu29, usu30 };
		try {
			while (true) {
				for (int i = 0; i < UserList.length; i++) {
					JButton boton = listausuarios[contusuarios];
					boton.setText((String) UserList[i][0]);
					contusuarios++;
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * Constructor de la ventana.
	 */
	public VentanaPrincipal() {

		setTitle("Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		usu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[0][0]);
				Info.estado.setText(UserList[0][3]);
				dispose();

			}
		});
		usu1.setBounds(26, 69, 117, 29);
		contentPane.add(usu1);
		usu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[1][0]);
				Info.estado.setText(UserList[1][3]);
				dispose();

			}
		});

		usu2.setBounds(26, 99, 117, 29);
		contentPane.add(usu2);
		usu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[2][0]);
				Info.estado.setText(UserList[2][3]);
				dispose();

			}
		});

		usu3.setBounds(26, 132, 117, 29);
		contentPane.add(usu3);
		usu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[3][0]);
				Info.estado.setText(UserList[3][3]);
				dispose();

			}
		});

		usu4.setBounds(26, 164, 117, 29);
		contentPane.add(usu4);
		usu5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[4][0]);
				Info.estado.setText(UserList[4][3]);
				dispose();

			}
		});

		usu5.setBounds(26, 193, 117, 29);
		contentPane.add(usu5);
		usu6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[5][0]);
				Info.estado.setText(UserList[5][3]);
				dispose();

			}
		});

		usu6.setBounds(26, 222, 117, 29);
		contentPane.add(usu6);
		usu7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[6][0]);
				Info.estado.setText(UserList[6][3]);
				dispose();

			}
		});

		usu7.setBounds(26, 254, 117, 29);
		contentPane.add(usu7);
		usu8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[7][0]);
				Info.estado.setText(UserList[7][3]);
				dispose();

			}
		});

		usu8.setBounds(26, 281, 117, 29);
		contentPane.add(usu8);
		usu9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[8][0]);
				Info.estado.setText(UserList[8][3]);
				dispose();

			}
		});

		usu9.setBounds(26, 309, 117, 29);
		contentPane.add(usu9);
		usu10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[9][0]);
				Info.estado.setText(UserList[9][3]);
				dispose();

			}
		});

		usu10.setBounds(26, 337, 117, 29);
		contentPane.add(usu10);
		usu11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[10][0]);
				Info.estado.setText(UserList[10][3]);
				dispose();
			}
		});

		usu11.setBounds(155, 69, 117, 29);
		contentPane.add(usu11);
		usu12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[11][0]);
				Info.estado.setText(UserList[11][3]);
				dispose();
			}
		});

		usu12.setBounds(155, 99, 117, 29);
		contentPane.add(usu12);
		usu13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[12][0]);
				Info.estado.setText(UserList[12][3]);
				dispose();
			}
		});

		usu13.setBounds(155, 132, 117, 29);
		contentPane.add(usu13);
		usu14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[13][0]);
				Info.estado.setText(UserList[13][3]);
				dispose();
			}
		});

		usu14.setBounds(155, 164, 117, 29);
		contentPane.add(usu14);
		usu15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[14][0]);
				Info.estado.setText(UserList[14][3]);
				dispose();
			}
		});

		usu15.setBounds(155, 193, 117, 29);
		contentPane.add(usu15);
		usu16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[15][0]);
				Info.estado.setText(UserList[15][3]);
				dispose();
			}
		});

		usu16.setBounds(155, 222, 117, 29);
		contentPane.add(usu16);
		usu17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[16][0]);
				Info.estado.setText(UserList[16][3]);
				dispose();
			}
		});

		usu17.setBounds(155, 254, 117, 29);
		contentPane.add(usu17);
		usu18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[17][0]);
				Info.estado.setText(UserList[17][3]);
				dispose();
			}
		});

		usu18.setBounds(155, 281, 117, 29);
		contentPane.add(usu18);
		usu19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[18][0]);
				Info.estado.setText(UserList[18][3]);
				dispose();
			}
		});

		usu19.setBounds(155, 309, 117, 29);
		contentPane.add(usu19);
		usu20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[19][0]);
				Info.estado.setText(UserList[19][3]);
				dispose();
			}
		});

		usu20.setBounds(155, 337, 117, 29);
		contentPane.add(usu20);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(181, 30, 61, 16);
		contentPane.add(lblClientes);
		usu21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[20][0]);
				Info.estado.setText(UserList[20][3]);
				dispose();
			}
		});

		usu21.setBounds(274, 69, 117, 29);
		contentPane.add(usu21);
		usu22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[21][0]);
				Info.estado.setText(UserList[21][3]);
				dispose();
			}
		});

		usu22.setBounds(274, 99, 117, 29);
		contentPane.add(usu22);
		usu23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[22][0]);
				Info.estado.setText(UserList[22][3]);
				dispose();
			}
		});

		usu23.setBounds(274, 132, 117, 29);
		contentPane.add(usu23);
		usu24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[23][0]);
				Info.estado.setText(UserList[23][3]);
				dispose();
			}
		});

		usu24.setBounds(274, 164, 117, 29);
		contentPane.add(usu24);
		usu25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[24][0]);
				Info.estado.setText(UserList[24][3]);
				dispose();
			}
		});

		usu25.setBounds(274, 193, 117, 29);
		contentPane.add(usu25);
		usu26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[25][0]);
				Info.estado.setText(UserList[25][3]);
				dispose();
			}
		});

		usu26.setBounds(274, 222, 117, 29);
		contentPane.add(usu26);
		usu27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[26][0]);
				Info.estado.setText(UserList[26][3]);
				dispose();
			}
		});

		usu27.setBounds(274, 254, 117, 29);
		contentPane.add(usu27);
		usu28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[27][0]);
				Info.estado.setText(UserList[27][3]);
				dispose();
			}
		});

		usu28.setBounds(274, 281, 117, 29);
		contentPane.add(usu28);
		usu29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[28][0]);
				Info.estado.setText(UserList[28][3]);
				dispose();
			}
		});

		usu29.setBounds(274, 309, 117, 29);
		contentPane.add(usu29);
		usu30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				info.setVisible(true);
				Info.nombre.setText(UserList[29][0]);
				Info.estado.setText(UserList[29][3]);
				dispose();
			}
		});

		usu30.setBounds(274, 337, 117, 29);
		contentPane.add(usu30);

		JButton button_29 = new JButton("Grafo");
		button_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Grafo grafo = new Grafo();
				grafo.setVisible(true);
				grafo.grafolist = grafolist;
				grafo.matrizadya = matrizadya;
				dispose();
			}
		});
		button_29.setBounds(454, 193, 117, 29);
		contentPane.add(button_29);

		hilo = new Thread(this, "hilito");
		hilo.start();
	}

}
