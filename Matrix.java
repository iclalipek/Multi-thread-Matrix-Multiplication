import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Matrix {
    
    // Matrisi ekrana yazdırma
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Dosyadan matris okuma
    public static int[][] readMatrixFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int[][] matrix = null;
        int row = 0;

        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(" ");
            if (matrix == null) {
                matrix = new int[tokens.length][tokens.length];
            }
            for (int i = 0; i < tokens.length; i++) {
                matrix[row][i] = Integer.parseInt(tokens[i]);
            }
            row++;
        }
        reader.close();
        return matrix;
    }
}