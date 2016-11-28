package Main;

import java.awt.EventQueue;

import Conect.Server;
import GUI.VentanaPrincipal;

public class Main {

	/**
	 * llama a la ventana principal.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Server servidor= new Server();
        servidor.escuchar();
	}
}
