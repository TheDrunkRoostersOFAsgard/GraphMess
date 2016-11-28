package Conect;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;

import GUI.VentanaPrincipal;

public class HiloCliente implements Runnable{
	//Declaramos las variables que utiliza el hilo para estar recibiendo y mandando mensajes.
    private Socket socket;
    private DataInputStream entrada;
    private DataOutputStream salida;
    //Lista de los usuarios conectados al servidor.
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();
    
    
    
  //Constructor que recibe el socket que atendera el hilo y la lista de usuarios conectados
    public HiloCliente(Socket soc,LinkedList<Socket> users){
        socket = soc;
        usuarios = users;
    }
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		try {
			VentanaPrincipal.Arbol.insert("1.Hola");
	    	VentanaPrincipal.Arbol.insert("2.Como estas?");
	    	VentanaPrincipal.Arbol.insert("3.Bien");
	    	VentanaPrincipal.Arbol.insert("4.Hola");
	    	VentanaPrincipal.Arbol.insert("2.Pedro se fue al parque");
	    	VentanaPrincipal.Arbol.insert("4.Hola");
	    	VentanaPrincipal.Arbol.insert("6.Hola");
	    	VentanaPrincipal.Arbol.insert("1.Hola");
	    	VentanaPrincipal.Arbol.insert("5.Hola");
	    	VentanaPrincipal.Arbol.insert("1.Hola");
	    	VentanaPrincipal.Arbol.insert("6.Hola");
	    	VentanaPrincipal.Arbol.insert("1.Hola");
	    	VentanaPrincipal.Arbol.insert("3.Hola");
	    	VentanaPrincipal.Arbol.insert("2.Hola");
	    	VentanaPrincipal.Arbol.insert("1.Hola");
	    	VentanaPrincipal.Arbol.insert("4.Hola");
	    	VentanaPrincipal.Arbol.print();
            //Inicializamos los canales de comunicacion y mandamos un mensaje de bienvenida
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
            //Ciclo infinito para escuchar por mensajes del cliente.
            while(true){
            	
            	
            	String MSG;
            	String mensajeRecibido = entrada.readUTF();
            	System.out.println(mensajeRecibido);
            	if (mensajeRecibido.charAt(0)=='J'){
            		MSG = "1."+mensajeRecibido.substring(13);
            		VentanaPrincipal.Arbol.insert(MSG);
            	}else if(mensajeRecibido.charAt(0)=='N'){
            		MSG = "2."+mensajeRecibido.substring(14);
            		VentanaPrincipal.Arbol.insert(MSG);
            	}
            	
               //Cuando se recibe un mensaje se envia a todos los usuarios conectados 
                
                
            	for (int i = 0; i < usuarios.size(); i++) {
                	salida = new DataOutputStream(usuarios.get(i).getOutputStream());
                    salida.writeUTF(mensajeRecibido);
                    
                }
            }
		}catch (IOException e) {
                //Si ocurre un excepcion lo mas seguro es que sea por que el cliente se desconecto asi que lo quitamos de la lista de conectados
                for (int i = 0; i < usuarios.size(); i++) {
                    if(usuarios.get(i) == socket){
                        usuarios.remove(i);
                        break;
                    } 
                }
            }
        }
		
	}
