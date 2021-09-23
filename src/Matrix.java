import java.util.*;

import java.io.*;

public class Matrix {

    // Untuk input data
    Scanner input = new Scanner(System.in);

    /* **** Atribut Matrix **** */
    int RowCap = 100;
    int ColCap = 100;
    int RowEff = 1; // Jumlah baris effektif, minimal 1
    int ColEff = 1; // Jumlah baris efektif minimal 1
    int i, j; // i : baris matrix, j : kolom matrix
    double [][] Content;
    // isi dari matriks. cara mengakses matriks Matrix.Content[i][j]
    // indeks (i) baris dan (j) dimulai dari 0;
    
    /* **** Konstruktor Matriks**** */
    Matrix (int RowEff, int ColEff) {
        this.RowEff = RowEff;
        this.ColEff = ColEff;
        this.Content = new double[RowEff][ColEff];
    }   
    
    Matrix(double[][] m) {
        // Konstruktor dari tabel
        this.RowEff = m.length;
        this.ColEff = m[0].length;
        this.Content = new double[m.length][m[0].length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                this.Content[i][j] = m[i][j];
    }
}
