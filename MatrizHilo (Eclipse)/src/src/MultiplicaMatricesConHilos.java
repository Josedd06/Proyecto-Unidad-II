package src;
import java.util.LinkedList;
import java.util.Scanner;
public class MultiplicaMatricesConHilos {

	public static void main(String[] args) {
		long tiempo; 
        long tiempoInicial;
        MultiplicaMatricesConHilos A = new MultiplicaMatricesConHilos();
        MultiplicaMatricesConHilos B = new MultiplicaMatricesConHilos();
        
 
        tiempoInicial = System.nanoTime();
        Scanner sc = new Scanner(System.in);
        System.out.println("\tProducto de Matrices");
        System.out.println("\t--------------------");
        System.out.println("");
        System.out.println("MATRIZ A");
        System.out.print("Digite las filas para la matriz A: ");
        int filaA = sc.nextInt();
        System.out.print("Digite las columnas: ");
        int colA = sc.nextInt();
        System.out.println("");
        
        System.out.println("MATRIZ B");
        System.out.println("Las columnas de la Matriz A es igual a las filas de la Matriz B...");
        System.out.print("Digite las columnas: ");
        int colB = sc.nextInt();
       
        int [][] m1 = A.Matriz(filaA, colA);
        int [][] m2 = B.Matriz(colA, colB);	
        System.out.println("MATRIZ A: ");
        A.mostrarMatriz(m1);
        System.out.println("MATRIZ B: ");
        B.mostrarMatriz(m2);


        int [][] resultado = new MultiplicaMatricesConHilos().productoMatriz(m1, m2);


// Se saca por consola el resultado.
        System.out.println("");
        System.out.println("Resultado (Matriz A) x (Matriz B): ");
		for (int i=0;i<resultado.length; i++)
		{
			for (int j=0;j<resultado[0].length;j++)
				System.out.print(resultado[i][j]+" ");
			System.out.println(" ");
		}
        tiempo = System.nanoTime() - tiempoInicial; 
        System.out.println("El producto de la Matriz A y B fue calculada en " + tiempo + " nanosegundos...");

		}
		public int[][] productoMatriz (int [][] m1, int [][] m2)
		{

		
	
		int filas = m1.length;
		int columnas = m2[0].length;
		int [][] resultado = new int[filas][columnas];
		
		// Lista con todos los hilos lanzados.
		LinkedList<Thread> hilos = new LinkedList<Thread>();
		
		// Para cada elemento de la matriz resultado, se lanza el hilo
		// correspondiente.
		for (int fila=0; fila<filas; fila++)
			for (int columna=0; columna<columnas; columna++)
			{
				Thread hilo = new Thread(
						new HiloMultiplicador(m1,m2,resultado,fila,columna));
				hilos.add(hilo);
				hilo.start();
			}
		
		// Se espera que terminen todos los hilos
		for (Thread hilo: hilos)
			try {
				hilo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		return resultado;
	}
        public int[][] Matriz(int filas, int col) {
        int Matriz[][] = new int[filas][col];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < col; j++) {
                Matriz[i][j] = Aleatorio(-9, 9);
            }
        }
        return Matriz; 
    }
        public void mostrarMatriz (int matriz[][]) {
        for (int fila[] : matriz) {
            for (int columna : fila) {
                System.out.print(columna + "  ");
            }
            System.out.println("");
        }
    }
        public static int Aleatorio(int min, int max) {
        return (int) Math.floor(Math.random() * (min - (max + 1)) + (max + 1));
    }

}
