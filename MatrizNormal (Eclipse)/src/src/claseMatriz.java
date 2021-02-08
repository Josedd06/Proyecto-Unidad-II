package src;

public class claseMatriz {
	
	int filasA; 
    int colA;
    int filasB;
    int colB = colA;

    public int[][] Matriz(int filasA, int colA) {
        int MatrizA[][] = new int[filasA][colA];
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < colA; j++) {
                MatrizA[i][j] = Aleatorio(-9, 9);
            }
        }
        return MatrizA; 
    }

    public int[][] productoMatriz(int MatrizA[][], int MatrizB[][], int filasA, int colA, int filasB, int colB) {
        int resultado[][] = new int[filasA][colB];
//        resultado[0][0] = 0;
            for (int i = 0; i < filasA; i++) {
                for (int j = 0; j < colB; j++) {
                    for (int k = 0; k < colA; k++) {
                        resultado[i][j] += MatrizA[i][k] * MatrizB[k][j];
                    }
                }
            }
        return resultado;
    }

    public void mostrarResultado(int resultado[][]) {
        System.out.println("--------------------------");
        System.out.println("Resultado (Matriz A) x (Matriz B): ");
        for (int fila[] : resultado) {
            for (int columna : fila) {
                System.out.print(columna + " ");
            }
            System.out.println("");
        }
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

    public int getFilasA() {
        return filasA;
    }

    public void setFilasA(int filasA) {
        this.filasA = filasA;
    }

    public int getColA() {
        return colA;
    }

    public void setColA(int colA) {
        this.colA = colA;
    }

    public int getFilasB() {
        return filasB;
    }

    public void setFilasB(int filasB) {
        this.filasB = filasB;
    }

    public int getColB() {
        return colB;
    }

    public void setColB(int colB) {
        this.colB = colB;
    }
	
	
}
