/*  Matrix multiplication 26.10.14 ver1.0
sat
*/

public class Matrix {

    private int row = -1;
    private int column = -1;
    private int[][] arrM;

    public Matrix(int rows, int columns) {
        arrM = new int[rows][columns];
    }

    public Matrix setRows(int r) throws IllegalArgumentException {
        if (r <= 0) {
            throw new IllegalArgumentException("row=" + r + " is incorrect");
        }
        this.row = r;
        return this;
    }

    public void setColumns(int c) throws IllegalArgumentException {
        if (c <= 0) {
            throw new IllegalArgumentException("columns=" + c + " is incorrect");
        }
        if (this.row <= 0) {
            throw new IllegalArgumentException("row=" + this.row + " is incorrect");
        }

        this.column = c;

    }


    public void fillRandom()  {

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                //arr[i][j]=i*j*100;
                this.arrM[i][j]=(int) (Math.random() * 100);

            }
        }
        //this.arrM=arr;
    }


    public void printMatrix(String nameMatrix)  {
        System.out.println("Matrix="+nameMatrix+" row="+this.row+" col="+this.column);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                System.out.println(this.arrM[i][j]);

            }
        }

    }

    public Matrix multiplication(Matrix toMatrix)    {
        int row_RezMatrix;int col_RezMatrix;

        if (this.row>toMatrix.row){row_RezMatrix=this.row;}
        else {row_RezMatrix=toMatrix.row;}
        if (this.column>toMatrix.column){col_RezMatrix=this.column;}
        else {col_RezMatrix=toMatrix.column;}
        Matrix RezMatrix=new Matrix(row_RezMatrix,col_RezMatrix);
        RezMatrix.setRows(row_RezMatrix).setColumns(col_RezMatrix);
        for (int rw = 0; rw < this.row; rw++) {
            for (int cl = 0; cl < toMatrix.column; cl++) {
                for (int inner = 0; inner < this.column; inner++) {
                    int a;int b;
                    //a=this.arrM[0][0];
                    //b=toMatrix.arrM[0][0];
                    a=this.arrM[rw][inner];
                    b=toMatrix.arrM[inner][cl];
                    RezMatrix.arrM[rw][cl] += a * b;
                }
            }
        }

        return RezMatrix;
    }


    //public class Matrix_Runner {

    public static void main(String[] args) {

        Matrix A = new Matrix(4, 3);
        Matrix B = new Matrix(3, 2);
        Matrix C;

        System.out.println("begin");
        A.setRows(2).setColumns(3);
        A.fillRandom();
        A.printMatrix("first");

        B.setRows(3).setColumns(2);
        B.fillRandom();
        B.printMatrix("second");

        C = A.multiplication(B);
        C.printMatrix("result");
        System.out.println("end");
    }
}