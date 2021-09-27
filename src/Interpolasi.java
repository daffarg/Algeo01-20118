import java.util.*;
import java.lang.Math;

public class Interpolasi {
    Scanner input = new Scanner(System.in);

    public void interpolasiKeyInput(Matrix m) {
        // KAMUS LOKAL
        int N, i, j;
        double x, elmtx, elmty;

        // ALGORITMA
        System.out.println("Masukkan N: ");
        N = input.nextInt();
        m.RowEff = N + 1;
        m.ColEff = N + 2;

        for (i = 0; i <= N; i ++) {
            System.out.printf("Masukkan titik ke-%d: ", i);
            elmtx = input.nextDouble();
            elmty = input.nextDouble();
            for (j = 0; j <= N; j ++) {
                m.Content[i][j] = Math.pow(elmtx, j);
            }
            m.Content[i][m.ColEff-1] = elmty;
        }

        m.gaussJordanElimination(m);
        System.out.println("Masukkan nilai yang ingin ditaksir: ");
        x = input.nextDouble();

        // Prekondisi satu kasus
    }
}
