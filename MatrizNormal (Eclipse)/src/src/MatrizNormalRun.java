package src;
import java.util.Scanner;

public class MatrizNormalRun {

	public static void main(String[] args) {
		 long tiempo; 
	        long tiempoInicial;
	  
	        Scanner sc = new Scanner(System.in);
	        claseMatriz matrizA = new claseMatriz();
	        claseMatriz matrizB= new claseMatriz();
	        claseMatriz matrizC = new claseMatriz();
	       
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
	        
	        System.out.println("");
	        

	        //EJECUCIÓN NORMAL         
	        tiempoInicial = System.nanoTime();
	        System.out.println("MATRIZ A: ");
	        int a [][] = matrizA.Matriz(filaA, colA);
	        matrizA.mostrarMatriz(a);
	        System.out.println("MATRIZ B: ");
	        int b [][] = matrizB.Matriz(colA, colB);
	        matrizB.mostrarMatriz(b);
	        int [][] resultado = matrizC.productoMatriz(a, b, filaA, colA, colA, colB);
	        matrizC.mostrarResultado(resultado);
	        tiempo = System.nanoTime() - tiempoInicial; 
	        System.out.println("El producto de la Matriz A y B fue calculada en " + tiempo + " nanosegundos...");

	}

}
