
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
        System.out.print("Masukan jumlah baris matriks: ");
        int M = input.nextInt();
        System.out.print("Masukan jumlah kolom matriks: ");
        int N = input.nextInt();
        
        m.RowEff = M;
        m.ColEff = N;
        m.readMatrix();
        
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