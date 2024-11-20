package Oving6;

final public class Matrise {
    //immutable variabler
    final private int[][] matrix;
    final private int[][] transposedMatrix;
    
    //konstruktør
    public Matrise(int[][] m) {
        //exception handler
        if (m.length != m[0].length || (m.length > 2 || m[0].length > 2)) {
            throw new IllegalArgumentException("Illegal Argument Error: Dimensions of array is now equal or out of range 2x2.");
        }

        //initialisering
        this.matrix = m;
        this.transposedMatrix = matTrans();
    }

    //returnerer matrise
    public int[][] getMatrix() {
        return this.matrix;
    }

    //returnerer transponert matrise
    public int[][] getTransMatrix() {
        return this.transposedMatrix;
    }

    //sjekker validitet av om matrisene a og b kan adderes
    private boolean checkValidSum(int[][] a, int[][] b) {
        boolean s = (a.length == b.length && a[0].length == b[0].length);
        return s;
    }

    //sjekker validitet av om matrisene a og b kan multipliseres
    private boolean checkValidProd(int[][] a, int[][] b) {
        boolean s = (a[0].length == b.length);
        return s;
    }

    //dyp kopi av et array
    private int[][] deepCopy(int[][] m) {
        int[][] a = new int[m.length][m[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = m[i][j];
            }
        }

        return a;
    }
    
    //sum av matriser
    public int[][] matAdd(int[][] x) {
        int[][] A = deepCopy(this.matrix);
        
        //sjekker validitet
        if (checkValidSum(A, x)) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] += x[i][j];
                }
            }
            return A;
        }
        return null;
    }
    
    //produkt av matrisemultiplikasjon
    public int[][] matProd(int[][] x) {
        int[][] A = deepCopy(this.matrix);

        int[][] res = new int[A.length][x[0].length];

        //sjekker validitet
        if (checkValidProd(A, x)) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    for (int k = 0; k < x[0].length; k++) {
                        res[i][j] += A[i][k] * x[k][j];
                    } 
                }
            }
            return res;
        }
        return null;
    }
    
    //Transponerer matrisen ved å bytte om rad-indeks med kolonne-indeks
    private int[][] matTrans() {
        int[][] A = deepCopy(this.matrix);
        int[][] transArr = new int[A[0].length][A.length]; 

        for (int i = 0; i < transArr.length; i++) {
            for (int j = 0; j < transArr[i].length; j++) {
                transArr[i][j] = A[j][i];
            }
        }

        return transArr;
    }
}
