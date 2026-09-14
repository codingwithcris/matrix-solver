package src;

import src.exceptions.SingularMatrixException;

public class MatrixSolver {
    public int determinant(Matrix matrix) {
        int a = matrix.getElement(1, 1);
        int b = matrix.getElement(1, 2);
        int c = matrix.getElement(2, 1);
        int d = matrix.getElement(2, 2);

        return a*d-b*c;
    }

    public Matrix inverse(Matrix matrix) {
        int[] dimensions = matrix.getDimension();
        int rows = dimensions[0], cols = dimensions[1];
        Matrix inverseMatrix = new Matrix(rows, cols);
        // Procedure to find the inverse for 2x2 matrices:
        // Calculate the determinant.
        // Swap the diagonal elements and switch the signs of the off-diagonal elements.
        // Multiply every element in the new matrix by the reciprocal of the determinant.
        if (rows == 2 && cols == 2) {           
            int determinant = determinant(matrix);
            // If the determinant is equal to zero, then the matrix is non-invertible.
            if (determinant == 0) {
                throw new SingularMatrixException (
                    "The inverse matrix does not exist."
                );
            }

            int a = matrix.getElement(1, 1);
            int b = matrix.getElement(1, 2);
            int c = matrix.getElement(2, 1);
            int d = matrix.getElement(2, 2);

            inverseMatrix.setElement(1, 1, d/determinant);
            inverseMatrix.setElement(1, 2, -b/determinant);
            inverseMatrix.setElement(2, 1, -c/determinant);
            inverseMatrix.setElement(2, 2, a/determinant); 
        }

        return inverseMatrix;
    }

    public Matrix transpose(Matrix matrix) {
        int[] dimension = matrix.getDimension();
        int rows = dimension[0], cols = dimension[1];
        Matrix matrixT = new Matrix(cols, rows);
        
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                int element = matrix.getElement(row, col);
                matrixT.setElement(col, row, element);
            }
        }

        return matrixT;
    }
}