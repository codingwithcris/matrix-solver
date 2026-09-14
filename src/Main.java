package src;

public class Main {
    public static void printMatrix(Matrix matrix) {
        for (int i = 1; i <= matrix.getRowSize(); i++) {
            for (int j = 1; j <= matrix.getColumnSize(); j++) {
                int element = matrix.getElement(i, j);
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MatrixSolver matrixSolver = new MatrixSolver();
        Matrix twoByTwo = new Matrix(2, 2);
        twoByTwo.setElement(1, 1, 3);
        twoByTwo.setElement(1, 2, 1);
        twoByTwo.setElement(2, 1, 2);
        twoByTwo.setElement(2, 2, 1);
        Matrix inverseMatrix = matrixSolver.inverse(twoByTwo);
        printMatrix(inverseMatrix);
    }
}