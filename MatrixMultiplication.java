public class MatrixMultiplication implements Runnable {
    private final int[][] A;
    private final int[][] B;
    private final int[][] C;
    private final int rowIndex;

    public MatrixMultiplication(int[][] A, int[][] B, int[][] C, int rowIndex) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.rowIndex = rowIndex;
    }

    @Override
    public void run() {
        int n = B.length; // B'nin satır sayısı (veya A'nın sütun sayısı)
        int p = B[0].length; // B'nin sütun sayısı
        for (int j = 0; j < p; j++) {
            for (int k = 0; k < n; k++) {
                C[rowIndex][j] += A[rowIndex][k] * B[k][j];
            }
        }
        System.out.println("Thread " + rowIndex + " tamamlandı");
    }
}