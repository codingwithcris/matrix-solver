package src;

public class Matrix {
    private int rows;
    private int cols;
    private int[][] matrix;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new int[rows][cols];
    }

    public int getColumnSize() { return cols; }
    public int getRowSize() { return rows; }

    public int[] getDimension() {
         return new int[] {
            getRowSize(), 
            getColumnSize()
        };
    }

    public int getElement(int row, int col) {
        if (row == 0 || col == 0) {
            throw new IllegalArgumentException(
                "The row and column must be greater than or equal to one"
            );
        }
        return matrix[row-1][col-1];
    }

    // The method provides row and column numbers starting at 1.
    // Subtract 1 to access the appropriate row and column of the matrix.
    public void setElement(int row, int col, int element) {
        if (row == 0 || col == 0) {
            throw new IllegalArgumentException(
                "The row and column must be greater than or equal to one"
            );
        }
        matrix[row-1][col-1] = element;
    }

    public int determinant() {
        int a = getElement(1, 1);
        int b = getElement(1, 2);
        int c = getElement(2, 1);
        int d = getElement(2, 2);

        return a*d-b*c;
    }

    public Matrix inverse() {
        Matrix inverseMatrix = new Matrix(rows, cols);
        // Procedure to find the inverse matrix for 2x2:
        // Calculate the determinant.
        // Swap the diagonal elements and switch the signs of the off-diagonal elements.
        // Multiply the new matrix by 1/determinant.
        if (this.rows == 2 && this.cols == 2) {            
            int det = determinant();
            int a = getElement(1, 1);
            int b = getElement(1, 2);
            int c = getElement(2, 1);
            int d = getElement(2, 2);
            
            // If the determinant is equal to zero. The matrix is invertible.
            try {
                inverseMatrix.setElement(1, 1, d/det);
                inverseMatrix.setElement(1, 2, -b/det);
                inverseMatrix.setElement(2, 1, -c/det);
                inverseMatrix.setElement(2, 2, a/det); 
            } catch (ArithmeticException e) {
                System.out.println("The inverse matrix does not exist.");
            }
        }

        return inverseMatrix;
    }
}