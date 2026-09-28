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
        Matrix b = new Matrix(3, 4);
        b.setElement(1, 1, 1);
        b.setElement(1, 2, 0);
        b.setElement(1, 3, 1);
        b.setElement(1, 4, -1);
        
        b.setElement(2, 1, -1);
        b.setElement(2, 2, 2);
        b.setElement(2, 3, 4);
        b.setElement(2, 4, 2);

        b.setElement(3, 1, 3);
        b.setElement(3, 2, 2);
        b.setElement(3, 3, -1);
        b.setElement(3, 4, 0);

        Matrix c = new Matrix(4, 2);
        c.setElement(1, 1, 1);
        c.setElement(2, 1, 0);
        c.setElement(3, 1, 2);
        c.setElement(4, 1, -1);

        c.setElement(1, 2, 3);
        c.setElement(2, 2, 1);
        c.setElement(3, 2, -1);
        c.setElement(4, 2, 5);

        Matrix a = b.multiply(c);
        printMatrix(a);
    }   
}