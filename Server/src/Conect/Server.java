package Conect;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;



public class Server {
	
	//Inicializamos el puerto y el numero maximo de conexciones que acepta el servidor
    private final int puerto = 8080;
    private final int noConexiones = 7;
    //Creamos una lista de sockets, donde guardaremos los sockets que se vayan conectando
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();
    

  //Funcion para que el servidor empieze a recibir conexiones de clientes
    public void escuchar(){
        try {
            //Creamos el socket servidor
        	System.out.println("Iniciando servidor...");
            @SuppressWarnings("resource")
			ServerSocket servidor = new ServerSocket(puerto,noConexiones);
            System.out.println("...Servidor iniciado con éxito.");
            System.out.println("Escuchando....");
            //Ciclo infinito para estar escuchando por nuevos clientes
            while(true){
                //Cuando un cliente se conecte guardamos el socket en nuestra lista
                Socket cliente = servidor.accept();
                System.out.println("Se ha unido un nuevo cliente: "+cliente.getInetAddress());
                usuarios.add(cliente);
                //Instanciamos un hilo que estara atendiendo al cliente y lo ponemos a escuchar
                Runnable  run = new HiloCliente(cliente,usuarios);
                Thread hilo = new Thread(run);
                hilo.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 

}
