package src;

public class HiloMultiplicador implements Runnable {
	private int[][] ma;
	private int[][] mb;
	private int[][] resultado;
	private int fila;
	private int columna;

	public HiloMultiplicador (int[][] ma, int[][]mb, int[][]resultado, int fila, int columna)
	{
		this.ma = ma;
		this.mb = mb;
		this.resultado = resultado;
		this.fila = fila;
		this.columna = columna;
	}

	
	public void run()
	{
		resultado[fila][columna]=0;
		for (int i=0;i<mb.length;i++)
			resultado[fila][columna] += ma[fila][i] * mb[i][columna];
	}

}
