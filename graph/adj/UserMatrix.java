package adj;

public class UserMatrix {
	
	/**
	 * Crea la lista de usuarios para tomar datos para el grafo
	 * Tiene funciones para añadir usuario, remover usuario, actualizar posicion, y actualizar estado
	 *
	 * @author Gerardo
	 */
	
	static String[][] UserList;;
	static int UserListLen=0;
	
	///Añade cada usuario del servidor uno por uno y monta una lista de usuarios para luego utilizar sus datos
	public static void AddUser(String UserName,String UserID,String UserX,String UserY,String LoggedIn){
		String[][] TempUList=UserList;
		UserList= new String[UserListLen+1][];
		String[] User = new String[5];
		User[0]= UserName;
		User[1]= UserID;
		User[2]= UserX;
		User[3]= UserY;
		User[4]= LoggedIn;
		for (int i=0; i<UserListLen;i++){
			UserList[i]=TempUList[i];
		}
		UserList[UserListLen]=User;	
		UserListLen=UserListLen+1;
	}
	
	///Elimina al usuario espericifado, recibe el string del id asi que si se quiere ingresar in deberia parsearse
	public static void RemoveUser(String UserID) {
    	boolean Target;
    	Target = false;
        for(int i=0; i < UserListLen;i++){
        	if (UserID==UserList[i][1]){
        		Target=true;
        	}
        	if (Target==true){
        		if (i!=UserListLen-1){
        			UserList[i]=UserList[i+1];
        		}
        		if (i==UserListLen-1){
        			UserList[i]=null;
        		}
        	}
        }
        String[][] TempUL= new String[UserListLen-1][];
        for (int i=0; i < UserListLen-1;i++){
        	TempUL[i]=UserList[i];
        }
        UserList=TempUL;
        UserListLen=UserListLen-1;
    }
    
    ///Actualiza la posición X y Y del usuario cuya ID se especifíca, Basicamente el server deberia recibir una actualizacion de Pos cada cierto t
    ///Podria y deberia mezclarse con la comprobacion de estado de la funcion siguiente, tipo sino actualiza posicion, esta offline
    public static void UpdatedUserPos(String UserID, String UserX, String UserY){
    	for(int i=0; i < UserListLen;i++){
    		if (UserList[i][1]== UserID){
    			UserList[i][2]= UserX;
    			UserList[i][3]= UserY;
    		}
    	}
    }
    
    ///Actualiza el estado de conexion de los usuarios, esta funcion deberia correrse cada cierto tiempo
    ///El usuario deberia (auto) comprobar su estado cada cierto tiempo y si no responde el servidor deberia marcarlo como offline y llamar esto
    public static void UpdatedUserLog(String UserID, String LoggedIn){
    	for(int i=0; i < UserListLen;i++){
    		if (UserList[i][1]== UserID){
    			UserList[i][4]= LoggedIn;
    		}
    	}
    }
}
