package src;

import src.exceptions.MismatchedDimensionException;

public class Matrix {
    private int rows;
    private int cols;
    private int[][] matrix;

    public Matrix(int rows, int cols) {
        if (rows < 1) {
            throw new IllegalArgumentException( 
                "Row must be greater than or equal to one."
            );
        }

        if (cols < 1) {
            throw new IllegalArgumentException(
                "Column must be greater than or equal to one."
            );
        }

        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }

    public int getColumnSize() { return this.cols; }
    public int getRowSize() { return this.rows; }
    public int[] getDimension() {
         return new int[] {
            getRowSize(), 
            getColumnSize()
        };
    }

    public int getElement(int row, int col) {
        if (row < 1 || row > this.rows) {
            throw new ArrayIndexOutOfBoundsException(
                this.rows == 1
                    ? "Row must be 1"
                    : "Row must be between 1 and " + this.rows
            );
        }

         if (col < 1 || col > this.cols) {
            throw new ArrayIndexOutOfBoundsException(
                this.cols == 1
                    ? "Column must be 1"
                    : "Column must be between 1 and " + this.cols
            );
        }

        return this.matrix[row-1][col-1];
    }

    // The method provides row and column numbers starting at 1.
    // Subtract 1 to access the appropriate row and column of the matrix.
    public void setElement(int row, int col, int element) {
        if (row < 1 || row > this.rows) {
            throw new ArrayIndexOutOfBoundsException(
                this.rows == 1
                    ? "Row must be 1"
                    : "Row must be between 1 and " + this.rows
            );
        }

         if (col < 1 || col > this.cols) {
            throw new ArrayIndexOutOfBoundsException(
                this.cols == 1
                    ? "Column must be 1"
                    : "Column must be between 1 and " + this.cols
            );
        }
        
        this.matrix[row-1][col-1] = element;
    }

    public Matrix scale(int scalar) {
        Matrix scaledMatrix = new Matrix(this.rows, this.cols);
        for (int row = 1; row <= this.rows; row++) {
            for (int col = 1; col <= this.cols; col++) {
                scaledMatrix.setElement(
                    row, col, 
                    this.getElement(row, col) * scalar
                );
            }
        }
        return scaledMatrix;
    }

    public Matrix add(Matrix other) {
        int[] dim = other.getDimension();
        if (this.rows != dim[0] || this.cols != dim[1]) {
            throw new MismatchedDimensionException(
                "Cannot add matrices with different dimensions."
            );
        }

        Matrix sum = new Matrix(this.rows, this.cols);
        for (int row = 1; row <= this.rows; row++) {
            for (int col = 1; col <= this.cols; col++) {
                int elem = this.getElement(row, col) 
                           + other.getElement(row, col);
                sum.setElement(row, col, elem);
            }
        }
        return sum;
    }

    public Matrix subtract(Matrix other) {
        int[] dim = other.getDimension();
        if (this.rows != dim[0] || this.cols != dim[1]) {
            throw new MismatchedDimensionException(
                "Cannot subtract matrices with different dimensions."
            );
        }

        Matrix difference = new Matrix(this.rows, this.cols);
        for (int row = 1; row <= this.rows; row++) {
            for (int col = 1; col <= this.cols; col++) {
                int elem = this.getElement(row, col) 
                           - other.getElement(row, col);
                difference.setElement(row, col, elem);
            }
        }
        return difference;
    }

    public Matrix multiply(Matrix other) {
        int[] dim = other.getDimension();
        if (this.cols != dim[0]) {
            throw new MismatchedDimensionException(
                "Cannot multiply matrices because the column size " 
                + "of the first matrix does not correspond "
                + "with the row size of the second matrix"
            );
        }

        Matrix product = new Matrix(this.rows, dim[1]);
        for (int row = 1; row <= this.rows; row++) {
            for (int col = 1; col <= dim[1]; col++) {
                
                int sum = 0;

                for (int i = 1; i <= this.cols; i++) {
                    sum += this.getElement(row, i)
                            * other.getElement(i, col);
                }

                product.setElement(row, col, sum);
            }
        }
        return product;
    }
}