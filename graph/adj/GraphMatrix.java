package adj;

public class GraphMatrix extends UserMatrix {
	
	/**
	 * Toma las lista de usuario general y crea matrices utilizables en el grafo, ademas de tener la funcion de dijkstra
	 *
	 * @author Gerardo
	 */

	
	static int[][] OnMatrix;
	static int[][] AMatrix;
	static String[][] GraphMatrix;
	
	private static void UpdateGraphMatrix(){
		
		int On=0;
		int Count=0;
		
		for (int i=0; i< UserList.length;i++){
			if (UserList[i][4]=="On"){
				On++;
			}
		}
		GraphMatrix = new String[On][];
		for (int i=0; i< UserList.length;i++){
			if (UserList[i][4]=="On"){
				String l=UserList[i][0];
				String m=UserList[i][2];
				String n=UserList[i][3];
				String[] Vertex= new String[3];
				Vertex[0]=l;
				Vertex[1]=m;
				Vertex[2]=n;
				GraphMatrix[Count]= Vertex;
				Count=Count+1;
			}
		}
		On=0;
		Count=0;
	}
	
	///Actualiza la matriz de Usuarios Conectados basados en el estado "On", esta matriz es la de pares ordenados
	
	private static void UpdateOnMatrix(){
		
		int On=0;
		int Count=0;
		
		for (int i=0; i< UserList.length;i++){
			if (UserList[i][4]=="On"){
				On++;
			}
		}
		OnMatrix= new int[On][];
		for (int i=0; i< UserList.length;i++){
			if (UserList[i][4]=="On"){
				int m=Integer.parseInt(UserList[i][2]);
				int n=Integer.parseInt(UserList[i][3]);
				int[] Vertex= new int[2];
				Vertex[0]=m;
				Vertex[1]=n;
				OnMatrix[Count]= Vertex;
				Count=Count+1;
			}
		}
		On=0;
		Count=0;
	}
	
	///Genera la matriz de adyacencia, si la distancia entre nodo i y nodo j es menor a 15 se especifica, sino tiene valor maximo,
	private static void UpdateAMatrix(){
		AMatrix = new int[OnMatrix.length][OnMatrix.length];
		for (int i=0; i<OnMatrix.length;i++){
			for (int j=0; j<OnMatrix.length;j++){
				int V1X= (OnMatrix[i][0]);
				int V1Y= (OnMatrix[i][1]);
				int V2X= (OnMatrix[j][0]);
				int V2Y= (OnMatrix[j][1]);
				if ((Math.abs(V1X-V2X)<15) && (Math.abs(V1Y-V2Y)<15)){
					int Distance = (((V1X-V2X)^2+(V1Y-V2Y)^2));
					Distance= (int) Math.sqrt(Distance);
					AMatrix[i][j]= Distance;
				}
				else{
					AMatrix[i][j]=Integer.MAX_VALUE;
				}
			}
		}
	}
	
	///Da la lista con los nodos a los que hay paso desde el nodo en que se esta,
	private static int[] AvPaths(int i){
		int PN=0;
		int PP=0;
		for (int j=0; j<AMatrix.length;j++){
			if (AMatrix[i][j]<=15){
				PN++;
			}
		}
		int[] AvPaths = new int[PN];

		for (int j=0; j<AMatrix.length;j++){
			if (AMatrix[i][j]<=15){
				AvPaths[PP]=j;
				PP++;
			}
		}
		PN=0;
		PP=0;
		return AvPaths;
	}

	static int[][] PathMatrix;

	/// Devuelve un array de numeros que hacen alusion a los nodos por los que debe pasar el mensaje
	@SuppressWarnings("unused")
	private static int[] SPath(int Node1, int Node2){
		
		///Declaracion de variables
		PathMatrix = new int[AMatrix.length][AMatrix.length*2];
		int[] ToVisit= new int[AMatrix.length-1];
		int[] AvailablePaths;
		int Visiting=0;
		int ToVisitLen=0;
		boolean[] Visited = new boolean[AMatrix.length];
		
		///Declara todos los nodos como no visitados en un principio
		for (int n=0; n<AMatrix.length;n++){
			Visited[n]=false;
		}	
		
		///Primer for, recorre la matriz alternando predecesores y pesos en cada columnas
		for (int n=0; n<AMatrix.length*2;n++){
			
			///Segundo for, recorre la matriz por filas revisando y comparando nodos y pesos
			for (int m=0; m<PathMatrix.length;m++){

				///Condicion inicial, para la primera columna todos deberian ser nulos pues no se ha visitado ningun nodo
				if (n==0){
					PathMatrix[m][n]=-1;
				}
				
				///Condicion inicial, para la segunda columna la distancia del nodo buscado a el mimo es 0, hacia el resto es infinito
				if (n==1){
					if (m==1){
						PathMatrix[Node1][n]=0;
					}else{
						PathMatrix[m][n]=Integer.MAX_VALUE;
					}
				}
				
				///if por para diferenciar de las condiciones iniciales primarias
				if (n!=0 && n!=1){

					///Recorrer todas las columnas es innecesario, asi que solo se recorren pesos
					if (n%2!=0){
						
						///Condicion inicial al visitar el primer nodo, se establece la lista de notos por visitar y los pesos actuales a estos
						if (n==3){
							int[] TempAvPath1=AvPaths(Node1);
							for (int Tempi1=0; Tempi1<TempAvPath1.length; Tempi1++){
								ToVisit[Tempi1]=TempAvPath1[Tempi1];
								ToVisitLen=TempAvPath1.length;
							}
							for (int Tempi2=0; Tempi2<TempAvPath1.length; Tempi2++){
								if (m==TempAvPath1[Tempi2]){
									if (Visited[m]==false){
										PathMatrix[m][n]=AMatrix[Node1][m];
										PathMatrix[m][n-1]=Node1;
									}else{
										PathMatrix[m][n]=PathMatrix[m][n-2];
										PathMatrix[m][n-1]=PathMatrix[m][n-3];
									}
								}else{
									PathMatrix[m][n]=PathMatrix[m][n-2];
									PathMatrix[m][n-1]=PathMatrix[m][n-3];

								}
							}
						}else{

							///ultima condicion a n nodos
							///Se revisa si del nuevo nodo se puede ir a algun nodo que no este en la lista por visitar y se agrega de ser asi.
							int[] TempAvPath2=AvPaths(ToVisit[Visiting]);

							for (int Tempi1=0; Tempi1<TempAvPath2.length; Tempi1++){
								boolean NewPath=true;
								for (int Tempi2=0;Tempi2<ToVisitLen;Tempi2++){
									if (TempAvPath2[Tempi1]==ToVisit[Tempi2]){
										NewPath=false;
									}
								}
								if (NewPath==true){
									ToVisit[ToVisitLen]=TempAvPath2[Tempi1];
									ToVisitLen++;
								}
							}
						}

						///
						int[] TempAvPath2=AvPaths(ToVisit[Visiting]);
						for (int Tempi2=0; Tempi2<TempAvPath2.length; Tempi2++){
							if (m==TempAvPath2[Tempi2]){
								if (Visited[m]==false){
									if (PathMatrix[m][n-2]>AMatrix[ToVisit[Visiting]][m]){
										PathMatrix[m][n]=AMatrix[Node1][m];
										PathMatrix[m][n-1]=m;
									}else{
										PathMatrix[m][n]=PathMatrix[m][n-2];
										PathMatrix[m][n-1]=PathMatrix[m][n-3];
									}
								}else{
									PathMatrix[m][n]=PathMatrix[m][n-2];
									PathMatrix[m][n-1]=PathMatrix[m][n-3];
								}
							}else{
								PathMatrix[m][n]=PathMatrix[m][n-2];
								PathMatrix[m][n-1]=PathMatrix[m][n-3];
							}

						}
					}																							
				}
			}
			if (n==3){
				Visited[Node1]=true;
			}else{
				if (n>3 && n%2!=0){
					Visited[ToVisit[Visiting]]=true;
					Visiting++;
				}
			}
		}
		
		///crea una lista con los nodos en orden de camino de acuerdo a cada uno de sus ultimos mejores caminos
		int[] TempResult=new int[PathMatrix.length];
		for (int f=0; f<PathMatrix.length; f++){
			if (f==0 ){
				TempResult[f]=PathMatrix[Node2][PathMatrix.length*2-2];
			}else{
				if (TempResult[f-1]==-1){
					TempResult[f]=TempResult[f];
				}else{
				    TempResult[f]=PathMatrix[TempResult[f-1]][PathMatrix.length*2-2];
				}
			}
		}
		
		///Verifica el numero de nodos para llegar al inicial
		int Npath=0;
		boolean end=false;
		for (int i=0; i<TempResult.length;i++){
			if (Node1==TempResult[i] || -1==TempResult[i]){
				end=true;
			}else{
				if (end==false){
					Npath++;
				}
			}
		}
		
		///toma la lista final desde el inicial hasta el final
		int[] Result= new int[Npath];
		int index1=1;
		Result[0]=Node1;
		for (int x=Npath-2; x>-1; x--){
			Result[index1]=TempResult[x];
			index1++;
		}
		return Result;
	}
	
	public static void main(String [] args)
	{
    	///Pruebas para esta clase
  
		
		UpdateGraphMatrix();
		UpdateOnMatrix();
		UpdateAMatrix();



	}

}
	




