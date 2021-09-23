import java.util.*;

import java.io.*;

public class Matrix {

    // Untuk input data
    Scanner input = new Scanner(System.in);

    /* **** Atribut Matrix **** */
    int RowCap = 100;
    int ColCap = 100;
    int RowEff; // Jumlah baris effektif, minimal 1
    int ColEff; // Jumlah baris efektif minimal 1
    int row, col; // row : baris matrix, col : kolom matrix
    double [][] Content;
    // isi dari matriks. cara mengakses matriks Matrix.Content[row][col]
    // indeks (row) baris dan (col) dimulai dari 0;
    
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
        for (int row = 0; row < m.length; row++)
            for (int col = 0; col < m[0].length; col++)
                this.Content[row][col] = m[row][col];
    }

    // Untuk membaca matriks dari file
    Matrix(String fileName) throws FileNotFoundException{
        ArrayList<ArrayList<Double>> Content = new ArrayList<ArrayList<Double>>();
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        
        int row = 0;
        int col = 0;

        while (scan.hasNextLine()) {
            Content.add(new ArrayList<Double>());
            String rowData = scan.nextLine();
            Scanner scanrowData = new Scanner(rowData);

            while (scanrowData.hasNextDouble()) {
                Content.get(row).add(scanrowData.nextDouble());
            }
            row = row + 1;

        }

        if (row == 0) {
            System.out.println("Tidak ada data dalam file " + fileName);
        } else {
            col = Content.get(0).size();
            this.Content = new double[row][col];
            this.RowEff = row + 1;
            this.ColEff = col;
            for (int i = 0; i <= row; i ++) {
                for (int j = 0; j < col; j ++) {
                    this.Content[i][j] = Content.get(i).get(j);
                }
            }
        }

    }

    /* **** Selektor **** */
    int getLastIdxRow (Matrix m) {
        // Mengembalikan indeks terakhir baris 
        return m.RowEff - 1;
    }

    int getLastIdxCol (Matrix m) {
        // Mengembalikan indeks terakhir kolom
        return m.ColEff - 1;
    }

    int getNumberOfEelement (Matrix m) {
        // Mengembalikan ukuran matriks
        return m.RowEff * m.ColEff;
    }

    /* **** Predikat **** */
    boolean isSquare (Matrix m) {
        // Mengembalikan true jika matriks tersebut adalah matriks bujur sangkar
        return (m.RowEff == m.ColEff);
    }
    boolean isIdentity (Matrix m) {
        // Mengembalikan true jika matriks tersebut adalah matriks identitas 
        int i = 0;
        int j;
        boolean flag = true;

        if (isSquare(m)) {
            while (i < m.RowEff && flag) {
                j = 0;
                while (j < m.ColEff && flag) {
                    if (i == j) {
                        if (m.Content[i][j] != 1) {
                            flag = false;
                        }
                    } else {
                        if (m.Content[i][j] != 0) {
                            flag = false;
                        }
                    }
                    if (flag) {
                        j ++;
                    }
                }
                if (flag) {
                    i ++;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }
}
