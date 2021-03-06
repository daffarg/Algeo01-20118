import java.util.*;
import java.io.*;
import java.lang.Math;

public class Matrix {
    // Untuk input data
    Scanner input = new Scanner(System.in);

    /* **** Atribut Matrix **** */
    int RowCap = 100;
    int ColCap = 100;
    int RowEff; // Jumlah baris effektif, minimal 1
    int ColEff; // Jumlah baris efektif minimal 1
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
            this.RowEff = row;
            this.ColEff = col;
            for (int i = 0; i < row; i ++) {
                for (int j = 0; j < col; j ++) {
                    this.Content[i][j] = Content.get(i).get(j);
                }
            }
        }

    }

    /* **** Selektor **** */
    public int getLastIdxRow (Matrix m) {
    // Mengembalikan indeks terakhir baris 
    // KAMUS LOKAL
    // ALGORITMA
    return m.RowEff - 1;
    }

    public int getLastIdxCol (Matrix m) {
    // Mengembalikan indeks terakhir kolom
    // KAMUS LOKAL
    // ALGORITMA
    return m.ColEff - 1;
    }

    public int getNumberOfElement (Matrix m) {
    // Mengembalikan ukuran matriks
    // KAMUS LOKAL
    // ALGORITMA
        return m.RowEff * m.ColEff;
    }

    /* **** Predikat **** */
    public boolean isEqual (Matrix m1, Matrix m2) {
    // Mengembalikan true jika jumlah baris dan kolom m1 sama dengan 
    // dan setiap elemen m1 sama dengan elemen m2
    // KAMUS LOKAL
        int i, j;
        boolean flag;
    // ALGORITMA 
        i = 0;
        flag = true;
        if (m1.RowEff == m2.RowEff && m1.ColEff == m2.ColEff) {
            while (i < m1.RowEff && flag) {
                j = 0;
                while (j < m1.ColEff && flag) {
                    if (m1.Content[i][j] != m2.Content[i][j]) {
                        flag = false;
                    } else {
                        j ++;
                    }
                } if (flag) {
                    i ++;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean isSquare (Matrix m) {
    // Mengembalikan true jika matriks tersebut adalah matriks bujur sangkar
    // KAMUS LOKAL
    // ALGORITMA
        return (m.RowEff == m.ColEff);
    }

    public boolean isIdentity (Matrix m) {
    // Mengembalikan true jika matriks tersebut adalah matriks identitas 
    // KAMUS LOKAL
        int i = 0;
        int j;
    // ALGORITMA
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

    /* **** Assignment Matriks **** */

    public void copyMatrix(Matrix mIn, Matrix mOut) {
    // I.S. mIn terdefinisi, mOut sembarang
    // F.S. mOut terdefinisi dengan ukuran dan elemen yang sama dengan mIn

    // KAMUS LOKAL 
        int i, j;

    // ALGORITMA 
        mOut.RowEff = mIn.RowEff;
        mOut.ColEff = mIn.ColEff;
        mOut.Content = new double[mIn.RowEff][mIn.ColEff];

        for (i = 0; i < mIn.RowEff; i ++) {
            for (j = 0; j < mIn.ColEff; j ++ ) {
                mOut.Content[i][j] = mIn.Content[i][j];
            }
        }
    }

    /* **** Create Jenis-Jenis Matriks **** */
    public Matrix createMatrixIdentitas(int N) {
    // Membuat matriks identitas
    // KAMUS LOKAL
        int i,j;
        Matrix I = new Matrix(N,N);
    // ALGORITMA
        for (i = 0; i < I.ColEff; i++) {
            for (j = 0; j < I.RowEff; j++) {
                if (i == j) {
                    I.Content[i][j] = 1;
                } else {
                    I.Content[i][j] = 0;
                }
            }
        }
        return I;
    }

    public Matrix createMatrixHilbert(int N) {
    // Membuat matriks Hilbert
    // KAMUS LOKAL
        int i,j;
        Matrix H = new Matrix(N,N);
    // ALGORITMA
        for (i = 0; i < H.RowEff; i++) {
            for (j = 0; j < H.ColEff; j++) {
                H.Content[i][j] = 1.0/(i+j+1);
            }
        }
        return H;
    }
    
    /* **** Input Output Matriks **** */
    public void readMatrix() {
    // I.S. Matriks terdefinisi
    // F.S. Elemen matriks terisi sesuai input user

    // KAMUS LOKAL
        int i, j;
    // ALGORITMA
        System.out.println("Masukkan elemen matriks: ");
        for (i = 0; i < this.RowEff; i++) {
            for (j = 0; j < this.ColEff; j++) {
                this.Content[i][j] = input.nextDouble();
            }
        }

    }

    public void displayMatrix() {
    // I.S. Matriks terdefinisi
    // F.S. Matriks tampil di layar user
    // KAMUS LOKAL
        int i, j;
    // ALGORITMA
        for (i = 0; i < this.RowEff; i++) {
            for (j = 0; j < this.ColEff; j++) {
                System.out.printf("%.2f ",this.Content[i][j]);
            } 
            System.out.print("\n");
        }
    }

    public static void writeFile(String file, Matrix M) {
        try {
            File F = new File(file);
            if (!(F.exists())) {
                F.createNewFile();
            }

            FileWriter FF = new FileWriter(file);
            PrintWriter print = new PrintWriter(FF);

            for (int i = 0; i < M.RowEff; i++) {
                for (int j = 0; j < M.ColEff; j++) {
                    M.Content[i][j] += 0;
                    print.printf("%.2f ", M.Content[i][j]);
                }
                print.printf("\n");
            }

            print.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* **** Operasi-Operasi Matriks Dasar **** */
    public Matrix multiplyMatrix (Matrix m1, Matrix m2) {
    // Mengalikan matriks m1 dengan m2
    // KAMUS LOKAL
        int i, j, k;
        Matrix mHasil = new Matrix(m1.RowEff, m2.ColEff);
    // ALGORITMA
        for (i = 0; i < m1.RowEff; i++) {
            for (j = 0; j < m2.ColEff; j++) {
                mHasil.Content[i][j] = 0;
                for (k = 0; k < m1.ColEff; k++) {
                    mHasil.Content[i][j] += m1.Content[i][k] * m2.Content[k][j];
                }
            }
        }
        return mHasil;
    }

    public Matrix multiplyConst (Matrix m1, double k) {
    // Mengalikan matriks m1 dengan k
    // KAMUS LOKAL
        Matrix mHasil = new Matrix(m1.RowEff,m1.ColEff);
        int i, j;
    // ALGORITM
        for (i = 0; i < m1.RowEff; i++) {
            for (j = 0; j < m1.ColEff; j++) {
                mHasil.Content[i][j] = m1.Content[i][j]*k;
            }
        }
        return mHasil;
    }

    public Matrix multiplyConst (Matrix m1, float k) {
    // Mengalikan matriks m1 dengan k
    // KAMUS LOKAL
        Matrix mHasil = new Matrix(m1.RowEff,m1.ColEff);
        int i, j;
    // ALGORITM
        for (i = 0; i < m1.RowEff; i++) {
            for (j = 0; j < m1.ColEff; j++) {
                mHasil.Content[i][j] = m1.Content[i][j]*k;
            }
        }
        return mHasil;
    }
    
    public Matrix addMatrix(Matrix m1, Matrix m2) {
    // KAMUS LOKAL menambah matrix m1 dengan m2
        int i, j;
        Matrix mHasil = new Matrix(m1.RowEff,m1.ColEff);
    // ALGORITMA
        for (i = 0; i < mHasil.RowEff; i++) {
            for (j = 0; j < mHasil.ColEff; j++) {
                mHasil.Content[i][j] = m1.Content[i][j] + m2.Content[i][j];
            }

        }
        return mHasil;
    }
    
    public Matrix subtractMatrix(Matrix m1, Matrix m2) {
    // Mengurangi matrix m1 dengan m2
    // KAMUS LOKAL
        int i,j;
        Matrix mHasil = new Matrix(m1.RowEff,m1.ColEff);
    // ALGORITMA
        for (i = 0; i < mHasil.RowEff; i++) {
            for (j = 0; j < mHasil.ColEff; j++) {
                mHasil.Content[i][j] = m1.Content[i][j] - m1.Content[i][j];
            }
        }
        return mHasil;
    }
    
    /* **** Operasi-Operasi Baris Elementer **** */
    public void swapRow(int row1, int row2) {
    // I.S. row1 dan row2 memiliki total elemen yang sama
    // F.S. row1 dan row2 tertukar semua elemennya satu sama lain
    
    // KAMUS LOKAL
        double[] temp = Content[row1];
    // ALGORITMA
        Content[row1] = Content[row2];
        Content[row2] = temp;
    }

    public void multiplyRow(int row, double k) {
    // I.S. row dan k terdefinisi
    // F.S. semua elemen pada row nilainya menjadi nilai elemen tersebut dikali dengan k

    // KAMUS LOKAL
        int j;
    // ALGORITMA
        for (j = 0; j < this.ColEff; j++) {
            Content[row][j] *= k;
        }
    }

    public void plusRow(int row1, int row2, double k) {
    // I.S. row 1, row2, dan k terdefinisi
    //      jumlah elemen row1 sama dengan row2
    // F.S. setiap elemen row1 nilainya menjadi elemen tersebut ditambah dengan k kali elemen row2
    
    // KAMUS LOKAL
        int j;
    // ALGORITMA
        for (j = 0; j < this.ColEff; j++) {
            Content[row1][j] += Content[row2][j]*k;
        }
    }

    /* **** Operasi-Operasi Matriks Tunggal **** */
    public Matrix transpose(Matrix m) {
    // Menghasilkan transpose dari matriks m
    // KAMUS LOKAL
        int i,j;
        Matrix mcopy;
    // ALGORITMA
        mcopy = new Matrix(m.ColEff,m.RowEff);
            
        for (i = 0; i < m.RowEff; i++) {
            for (j = 0; j < m.ColEff; j++) {
                mcopy.Content[j][i] = m.Content[i][j];
            }
        }
        return mcopy;
    }

    public void gaussElimination(Matrix m) {
    // Melakukan metode eliminasi gauss pada matriks m
    // KAMUS LOKAL
        int i,j;
        int[] count0 = new int[m.RowEff];
        int temp;
        int row, col;
    // ALGORITMA
        // Mengurutkan baris Matriks berdasarkan banyaknya angka nol yang berurutan di bagian kolom kiri
        // sebelum angka bukan 0;
        for (i = 0; i < m.RowEff; i++) {
            count0[i] = 0;
            j = 0;
            while (j < m.ColEff && m.Content[i][j] == 0) {
                count0[i] += 1;
                j++;        
            }
        }

        // Menukar baris
        for (i = 0; i < m.RowEff; i++) {
            for (j = 0; j < m.RowEff - 1; j++) {
                if (count0[j] > count0[j+1]) {
                    m.swapRow(j, j+1);
                    temp = count0[j+1];
                    count0[j+1] = count0[j];
                    count0[j] = temp;
                }
            }
        }

        // Mencari kolom yang nilainya bukan 0;
        
        for (i = 0; i < m.RowEff; i++) {
            col = 0;
            while (col < m.ColEff) {
                if (m.Content[i][col] == 0) {
                    col++;
                } else {
                    break;
                }
            }

            // Membagi baris ke-i agar elemen pertama dari kiri setelah 0 bernilai 1
            if (col != m.ColEff) {
                double x = m.Content[i][col];
                for (j = col; j < m.ColEff; j++) {
                    m.Content[i][j] = m.Content[i][j] / x;
                }
            }

            // Mengurangi baris [i+1..m.RowEff-1] matriks 
            row = i+1;
            while (row < m.RowEff && col < m.ColEff) {
                if (m.Content[row][col] != 0) {
                    m.plusRow(row, i, -m.Content[row][col]);
                }
                row++;
            }        
        }
        
        for (i = 0; i < m.RowEff; i++) {
            count0[i] = 0;
            j = 0;
            while (j < m.ColEff && m.Content[i][j] == 0) {
                count0[i] += 1;
                j++;        
            }
        }

        // Menukar baris lagi jika terdapat sebuah baris yang elemennya 0 semua, tetapi baris berikutnya tidak 0 semua
        for (i = 0; i < m.RowEff; i++) {
            for (j = 0; j < m.RowEff - 1; j++) {
                if (count0[j] > count0[j+1]) {
                    m.swapRow(j, j+1);
                    temp = count0[j+1];
                    count0[j+1] = count0[j];
                    count0[j] = temp;
                }
            }
        }
    }

    public void gaussJordanElimination (Matrix m) {
        // Melakukan metode eliminasi Gauss-Jordan pada matriks m
        // KAMUS LOKAL
        int i, row, col;
        // ALGORITMA
        gaussElimination(m);
        for (i = m.RowEff-1; i >= 1; i --) {
            col = 0;
            while (col < m.ColEff) {
                if (m.Content[i][col] != 1) {
                    col ++;
                } else {
                    break;
                }
            } 
            if (col != m.ColEff) {
                for (row = i-1; row >= 0; row --) {
                    m.plusRow(row, i, -m.Content[row][col]);
                }   
            }
        }
    }

    public double determinantCofactor (Matrix m) {
        // Mengembalikan nilai determinan matriks m dengan metode ekspansi kofaktor
        // KAMUS LOKAL
        int i, j, k, colkof, rowkof, sign;
        double det;
        Matrix minor;

        // ALGORITMA 
        sign = 1; 
        det = 0; 
        if (m.RowEff == 1) {
            det = m.Content[0][0];
        } else if (m.RowEff == 2) {
            det = m.Content[0][0] * m.Content[1][1] - m.Content[0][1] * m.Content[1][0];
        } else {    
            for (k = 0; k < m.RowEff; k ++) {     
                rowkof = 0;
                colkof = 0;
                minor = new Matrix(m.RowEff-1, m.ColEff-1);
                for (i = 0; i < m.RowEff; i ++) {
                    for (j = 0; j < m.ColEff; j ++) {
                        if (i != 0 && j != k) {
                            minor.Content[rowkof][colkof] = m.Content[i][j];
                            colkof = colkof + 1;
                            if (colkof == minor.ColEff) {
                                colkof = 0;
                                rowkof = rowkof + 1;
                            }
                        } 
                    }
                }
                
                det = det + sign * determinantCofactor(minor) * m.Content[0][k];
                sign = sign * -1;
            } 
        }
        return det;
    }

    public double determinantOBE (Matrix m) {
    // Mengembalikan nilai determinan matriks m dengan metode reduksi baris
    // menjadikan matriks m menjadi matriks segitiga atas

    // KAMUS LOKAL
        double det;
        int i,j;
        int[] count0 = new int[m.RowEff];
        int temp, countSwap;
        Matrix mcopy;
    // ALGORITMA
        mcopy = new Matrix(m.RowEff, m.ColEff);
        m.copyMatrix(m, mcopy);
        det = 1;
        for (i = 0; i < mcopy.RowEff; i++) {
            count0[i] = 0;
            j = 0;
            while (j < mcopy.ColEff && mcopy.Content[i][j] == 0) {
                count0[i] += 1;
                j++;        
            }
        }

        // Menukar baris
        countSwap = 0;
        for (i = 0; i < mcopy.RowEff; i++) {
            for (j = 0; j < mcopy.RowEff - 1; j++) {
                if (count0[j] > count0[j+1]) {
                    mcopy.swapRow(j, j+1);
                    countSwap ++;
                    temp = count0[j+1];
                    count0[j+1] = count0[j];
                    count0[j] = temp;
                }
            }
        }
        

        // Menjadikan matriks segitiga bawah
        for (i = 0; i < mcopy.RowEff; i ++) {
            for (j = i + 1; j < mcopy.RowEff; j ++) {
                if (mcopy.Content[i][i] != 0) {
                    mcopy.plusRow(j, i, -mcopy.Content[j][i] / mcopy.Content[i][i]);
                } else {
                    break;
                } 
            }
        }

        // Mengalikan seluruh diagonal utama untuk mendapatkan determinan
        for (i = 0; i < mcopy.RowEff; i ++) {
            det = det * mcopy.Content[i][i];
        }
        return det * Math.pow(-1, countSwap);
    }

    public double getCofactor (Matrix m, int row, int col) {
        // Mengembalikan minor dari matriks m sesuai baris row dan kolom col
        // KAMUS LOKAL
        Matrix minor;
        int i, j;
        int rowmin, colmin;
        // ALGORITMA 
        rowmin = 0;
        colmin = 0;
        minor = new Matrix(m.RowEff-1, m.ColEff-1);
        for (i = 0; i < m.RowEff; i ++) {
            for (j = 0; j < m.ColEff; j ++) {
                if (i != row && j != col) {
                    minor.Content[rowmin][colmin] = m.Content[i][j];
                    colmin = colmin + 1;
                    if (colmin == minor.ColEff) {
                        colmin = 0;
                        rowmin = rowmin + 1;
                    }
                } 
            }
        }
        return Math.pow(-1, row + col) * determinantCofactor(minor);
    }

    public Matrix inverseCofaktor (Matrix m) {
    // Prekondisi determinan matriks m != 0 dan m adalah matriks persegi
    // Mengembalikan inverse dari matriks m
    // KAMUS LOKAL
        int i, j;
        double det;
        Matrix mInvers;
    // ALGORITMA
        // Menyalin matriks m ke matriks mcopy
        mInvers = new Matrix(m.RowEff,m.ColEff);
        det =  determinantCofactor(m);

        // Mengisi matriks mcopy dengan elemen kofaktor matriks m
        for (i = 0; i < m.RowEff; i++) {
            for (j = 0; j < m.ColEff; j++) {
                mInvers.Content[i][j] = getCofactor(m, i, j);
            }
        }
        // adjoin dari matriks
        mInvers = transpose(mInvers);
    
        // mengalikan mcopy dengan 1/det(m)
        mInvers = multiplyConst(mInvers, 1/det);
        
        return mInvers;   
    }

    public Matrix inverseOBE (Matrix m) {
    // Pre kondisi determinan matriks m != 0 dan m merupakan matriks persegi 
    // Menghasilkan inverse matriks dari m dengan metode Eliminasi Gaus-Jordan
    // KAMUS LOKAL
        Matrix mInvers, mConcat;
        int i, j;
    // ALGORITMA
        // Inisialisasi matriks mInvers dengan matriks identitas
        mInvers =  new Matrix(m.RowEff,m.ColEff);
        mInvers = mInvers.createMatrixIdentitas(m.RowEff);
        
        // Inisialisasi matriks mConcat dengan gabungan dari matriks m dan matriks mInvers
        mConcat = new Matrix(m.RowEff,2*m.ColEff);
        
        for (i = 0; i < m.RowEff; i++) {
            for (j = 0; j < m.ColEff; j++) {
                mConcat.Content[i][j] = m.Content[i][j];
            }
        }
        
        for (i = 0; i < mInvers.RowEff; i++) {
            for (j = 0; j < mInvers.ColEff; j++) {
                mConcat.Content[i][j+m.ColEff] = mInvers.Content[i][j];
            }
        }

        // Operasi Elementer 
        gaussJordanElimination(mConcat);
            
        // Menyalin invers matriks m dari matriks mConcat ke matriks mInvers
        for (i = 0; i < mInvers.RowEff; i++) {
            for (j = 0; j < mInvers.ColEff; j++) {
                mInvers.Content[i][j] = mConcat.Content[i][j+m.ColEff];
            }
        }
    
        return mInvers;
    }

    public ArrayList<Double> cramerRule (Matrix m) {
    // Prekondisi: determinan matriks m != 0
    // Mengembalikan solusi dari SPL dalam bentuk ArrayList
    // KAMUS LOKAL
        Matrix mCopy;
        int i, j, k;
        ArrayList<Double> solution;
    // ALGORITMA
        // Inisialisasi ArrayList solution untuk menampung solusi dari SPL
        solution = new ArrayList<Double>();
        // Inisialisasi mCopy dengan ukuran kolom yg lebih kecil satu daripada m
        mCopy = new Matrix(m.RowEff, m.ColEff - 1);

        for (k = 0; k < m.ColEff - 1; k ++) {
            for (i = 0; i < m.RowEff; i ++) {
                for (j = 0; j < m.ColEff - 1; j ++) {
                    if (k == j) {
                        mCopy.Content[i][j] = m.Content[i][m.ColEff-1];
                    } else {
                        mCopy.Content[i][j] = m.Content[i][j];
                    }
                }
            }
            // Menambahkan setiap solusi SPL yang didaptkan  ke dalam solution
            solution.add(mCopy.determinantCofactor(mCopy) / m.determinantCofactor(m));
        }
        return solution;
    }
}