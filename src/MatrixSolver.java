package src;

import java.util.HashMap;
import java.util.Map;

import src.exceptions.SingularMatrixException;

public class MatrixSolver {
    public int computeDeterminant(Matrix matrix) {
        int a = matrix.getElement(1, 1);
        int b = matrix.getElement(1, 2);
        int c = matrix.getElement(2, 1);
        int d = matrix.getElement(2, 2);
        return a*d-b*c;
    }

    public Matrix computeInverse(Matrix matrix) {
        int[] dim = matrix.getDimension();
        Matrix inverseMatrix = new Matrix(dim[0], dim[1]);
        // Procedure to find the inverse for 2x2 matrices:
        // Calculate the determinant.
        // Swap the diagonal elements and switch the signs of the off-diagonal elements.
        // Multiply every element in the new matrix by the reciprocal of the determinant.
        if (dim[0] == 2 && dim[1] == 2) {           
            int det = computeDeterminant(matrix);
            // If the determinant is equal to zero, then the matrix is non-invertible.
            if (det == 0) {
                throw new SingularMatrixException (
                    "The inverse matrix does not exist."
                );
            }

            int a = matrix.getElement(1, 1);
            int b = matrix.getElement(1, 2);
            int c = matrix.getElement(2, 1);
            int d = matrix.getElement(2, 2);

            inverseMatrix.setElement(1, 1, d/det);
            inverseMatrix.setElement(1, 2, -b/det);
            inverseMatrix.setElement(2, 1, -c/det);
            inverseMatrix.setElement(2, 2, a/det); 
        }

        return inverseMatrix;
    }

    public Matrix computeTranspose(Matrix matrix) {
        int[] dim = matrix.getDimension();
        Matrix tranpose = new Matrix(dim[0], dim[1]);
        
        for (int row = 1; row <= dim[0]; row++) {
            for (int col = 1; col <= dim[1]; col++) {
                int elem = matrix.getElement(row, col);
                tranpose.setElement(col, row, elem);
            }
        }

        return tranpose;
    }

    // public void cofactorExpansion(Matrix m) {
    //     int[] dim = m.getDimension();
    //     Map<Integer, Integer> zerosInRows = new HashMap<>();
    //     Map<Integer, Integer> zerosInCols = new HashMap<>();

    //     // Identify the rows and columns which contains the most zeros
    //     for (int row = 1; row <= dim[0]; row++) {
    //         for (int col = 1; col <= dim[1]; col++) {
    //             int element = m.getElement(row, col);
    //             if (element == 0) {
    //                 if (!zerosInRows.containsKey(row)) {
    //                     zerosInRows.put(row, 1);
    //                 } else {
    //                     zerosInRows.put(row, zerosInRows.get(row) + 1);
    //                 }

    //                 if (!zerosInCols.containsKey(col)) {
    //                      zerosInCols.put(col, 1);
    //                 } else {
    //                     zerosInCols.put(col, zerosInCols.get(col) + 1);
    //                 }
    //             }
    //         }
    //     }
    // }
}