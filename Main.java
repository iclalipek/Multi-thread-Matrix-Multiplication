import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            int[][] A = Matrix.readMatrixFromFile("MatrixA.txt");
            int[][] B = Matrix.readMatrixFromFile("MatrixB.txt");

            // Matris boyutlarını kontrol et
            if (A[0].length != B.length) {
                System.err.println("Matris boyutları çarpım için uygun değil");
                return;
            }

            int rowsA = A.length;
            int colsB = B[0].length;
            int[][] C = new int[rowsA][colsB];

            System.out.println("Matris A:");
            Matrix.printMatrix(A);
            System.out.println("Matris B:");
            Matrix.printMatrix(B);

            // Threadleri oluştur ve başlat
            Thread[] threads = new Thread[rowsA];

            for (int i = 0; i < rowsA; i++) {
                threads[i] = new Thread(new MatrixMultiplication(A, B, C, i));
                threads[i].start();
            }

            // Threadlerin tamamlanmasını bekle
            for (int i = 0; i < rowsA; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Sonuç matrisi C:");
            Matrix.printMatrix(C);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}