package Proceso;
/**
 * 
 * @autor Hernaldo
 * Ventana main
 */
import java.awt.EventQueue;

import GUI.VentanaPrincipal;

public class Main {

	/**
	 * Llamada principal.
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
	}
}
