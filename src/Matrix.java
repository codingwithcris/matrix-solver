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
}