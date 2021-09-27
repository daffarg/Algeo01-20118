
import java.util.*;

public class SPL {
    Scanner input = new Scanner(System.in);

    public void gaussMethod(Matrix m) {
        System.out.print("Masukan jumlah baris matriks: ");
        int M = input.nextInt();
        System.out.print("Masukan jumlah kolom matriks: ");
        int N = input.nextInt();
        
        m.RowEff = M;
        m.ColEff = N;
        m.readMatrix();
        m.gaussElimination(m);
    }

    public void gaussJordanMethod(Matrix m) {
        System.out.print("Masukan jumlah baris matriks: ");
        int M = input.nextInt();
        System.out.print("Masukan jumlah kolom matriks: ");
        int N = input.nextInt();
        
        m.RowEff = M;
        m.ColEff = N;
        m.readMatrix();
        m.gaussJordanElimination(m);
    }

    public void inversMethod(Matrix m) {
        // Memecahkan SPL dengan metode matriks balikan
        // KAMUS LOKAL
        Matrix minv, mcons, mhasil;
        int i, j;

        // ALGORITMA
        System.out.print("Masukan jumlah baris matriks: ");
        int M = input.nextInt();
        System.out.print("Masukan jumlah kolom matriks: ");
        int N = input.nextInt();
        
        m.RowEff = M;
        m.ColEff = N;
        m.readMatrix();
        
        minv = new Matrix(m.RowEff, m.ColEff-1);

        for (i = 0; i < minv.RowEff; i ++) {
            for (j = 0; j < minv.ColEff; j ++) {
                minv.Content[i][j] = m.Content[i][j];
            }
        }

        if (minv.isSquare(minv) && minv.determinantCofactor(minv) != 0) {
            minv = minv.inverseCofaktor(minv);
            mcons = new Matrix(m.RowEff, 1);
            for (i = 0; i < m.RowEff; i ++) {
                mcons.Content[i][0] = m.Content[i][m.ColEff-1];
            }
            mhasil = new Matrix(m.RowEff, 1);
            mhasil = minv.multiplyMatrix(minv, mcons);
        } else {
            System.out.println("Matriks tidak mempunyai invers.");
        }
    }

    public void tulisSPL(Matrix m) {
        int i, j;
        int count0 = 0;
        
        i = 0;
        boolean flag = true;
        while (i < m.RowEff && flag) {
            count0 = 0;
            j = 0;
            while (j < m.ColEff - 1 && flag) {
                if (m.Content[i][j] == 0) {
                    count0 += 1;
                }
                if (count0 == m.ColEff - 1 && j == m.ColEff - 2) {
                    if (m.Content[i][j+1] != 0) {
                        flag = false;
                    } else {
                        count0 += 1;
                        flag = false;
                    }
                } else {
                    j++;
                }
            }
        }

        if (count0 ==  m.ColEff - 1) {
            System.out.println("SPL tidak mempunyai solusi");
        } else if (count0 == m.ColEff) {
            System.out.println("SPL memiliki solusi banyak");
        }
    }
}