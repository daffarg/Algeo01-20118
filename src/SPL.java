
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileWriter;

public class SPL {
    static Scanner input = new Scanner(System.in);

    public static void printSolution(ArrayList<String> s) {
        // KAMUS LOKAL
        int i;
        // ALGORITMA
        for (i = 0; i < s.size(); i ++) {
            System.out.println(s.get(i));
        }
    }

    public static void printSolution(ArrayList<String> s, String fileOut) {
        // KAMUS LOKAL
        int i;
        // ALGORITMA
        try {
            FileWriter writer = new FileWriter(fileOut);
            for (i = 0; i < s.size(); i ++) {
                writer.write(s.get(i) + "\n");
            }
            writer.close();
            System.out.println("Jawaban berhasil ditulis ke dalam file.");
          } catch (Exception e) {
            e.printStackTrace();
          }
    }

    public static ArrayList<String> returnSolutionGauss(Matrix m) {
        // KAMUS LOKAL
        int i, j, k, countRow0; 
        int count0 = 0;
        ArrayList<String> solution;
        boolean found;

        // ALGORITMA
        solution = new ArrayList<String>();
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
            if (flag) {
                i ++;
            }
        }

        if (count0 ==  m.ColEff - 1) {
            solution.add("SPL tidak mempunyai solusi");
        } else if (count0 == m.ColEff) {
            m.gaussJordanElimination(m);
            k = 0;
            if (m.RowEff + 1 < m.ColEff) {
                for (i = m.RowEff; i < m.ColEff - 1; i ++) {
                    k++;
                    solution.add("x" + (i + 1) + " = " + "r" + k);
                }
            }
            for (i = m.RowEff-1; i >= 0; i --) {
                countRow0 = 0;
                found = false;
                j = 0;
                while (j < m.ColEff && !found) {
                    if (m.Content[i][j] != 0) {
                        found = true;
                    } else {
                        j++;
                        countRow0 += 1;
                    }
                }

                int NextCountRow0 = countRow0;
                int col;
                for (col = j+1; col < m.ColEff; col++) {
                    if (m.Content[i][col] == 0) {
                        NextCountRow0 += 1;
                    }
                } 
                if (countRow0 == m.ColEff) {
                    k += 1;
                    solution.add("x" + (i + 1) + " = " + "r" + k);
                } else if (NextCountRow0 == m.ColEff - 1) {
                    solution.add("x" + (i + 1) + " = " + 0);
                } else {
                    String temp = "";
                    if (m.Content[i][m.ColEff-1] != 0) {
                        temp += String.valueOf(m.Content[i][m.ColEff-1]);
                    }
                    for (int kol = j+1; kol < m.ColEff-1; kol ++) {
                        if (m.Content[i][kol] != 0) {
                            temp += " + " + (-m.Content[i][kol]) + "r" + (m.ColEff - 1 - kol) ;
                        }
                    }
                    solution.add("x" + (i + 1) + " = " + temp);
                } 
            } 
        } else {
            double xvalue;
            ArrayList<Double> xvalueList = new ArrayList<Double>();
            for (i = m.RowEff-1; i >= 0; i --) {
                String temp2 = "x" + (i + 1) + " = ";
                xvalue = m.Content[i][m.ColEff-1];
                for (j = i + 1; j < m.ColEff - 1; j ++) {
                    xvalue -= m.Content[i][j]*xvalueList.get(m.ColEff - j - 2);
                }
                xvalueList.add(xvalue);
                temp2 += xvalue;
                solution.add(temp2);
                //System.out.println(solution.get(i));
            }
        }
        return solution;
    }

    public static ArrayList<String> returnSolutionGaussJordan(Matrix m) {
        // KAMUS LOKAL
        int i, j, k, countRow0; 
        int count0 = 0;
        ArrayList<String> solution;
        boolean found;

        // ALGORITMA
        solution = new ArrayList<String>();
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
            if (flag) {
                i ++;
            }
        }

        if (count0 ==  m.ColEff - 1) {
            solution.add("SPL tidak mempunyai solusi");
        } else if (count0 == m.ColEff) {
            /* k = 1;
            int row, kol;
            int parameter = 1;
            String temp;
            for (j = m.ColEff - 2; j >= 0; j--) {
                countRow0 = 0;
                found = false;
                row = 0;
                kol = 0;
                while (m.Content[row][kol] != 1 && kol < j) {
                    row ++;
                    kol ++;
                    if (m.Content[row][kol] != 0) {
                        break;
                    }
                }
                temp = "";
                if (kol == j && m.Content[row][kol] == 1) {
                    temp = String.valueOf(m.Content[row][m.ColEff - 1]);
                    for (k = kol; k < m.ColEff - 1; k ++) {
                        temp += " + " + (-m.Content[row][kol]) + "r" + (m.ColEff - 1 - kol);
                    }
                    solution.add(temp);
                } else {
                    solution.add("x" + (j + 1) + " = " + "r" + parameter);
                }
            } */
            k = 0;
            for (i = m.RowEff-1; i >= 0; i --) {
                countRow0 = 0;
                found = false;
                j = 0;
                while (j < m.ColEff && !found) {
                    if (m.Content[i][j] != 0) {
                        found = true;
                    } else {
                        j++;
                        countRow0 += 1;
                    }
                }

                int NextCountRow0 = countRow0;
                int col;
                for (col = j+1; col < m.ColEff; col++) {
                    if (m.Content[i][col] == 0) {
                        NextCountRow0 += 1;
                    }
                } 

                //System.out.println(countRow0);
                if (countRow0 == m.ColEff) {
                    k += 1;
                    solution.add("x" + (i + 1) + " = " + "r" + k);
                    //System.out.println(solution);
                } else if (NextCountRow0 == m.ColEff - 1) {
                    solution.add("x" + (i + 1) + " = " + 0);
                } else {
                    String temp = "";
                    if (m.Content[i][m.ColEff-1] != 0) {
                        temp += String.valueOf(m.Content[i][m.ColEff-1]);
                    }
                    for (int kol = j+1; kol < m.ColEff-1; kol ++) {
                        //System.out.println(kol);
                        if (m.Content[i][kol] != 0) {
                            temp += " + " + (-m.Content[i][kol]) + "r" + (m.ColEff - 1 - kol) ;
                            System.out.println(temp);
                        }
                    }
                    solution.add("x" + (i + 1) + " = " + temp);
                    //System.out.println(solution); 
                } 
            } 
        } else {
            for (i = m.RowEff-1; i >= 0; i --) {
                String temp2 = "x" + (i + 1) + " = " + m.Content[i][m.ColEff-1];
                solution.add(temp2);
            }
        }
        return solution;
    }

    public static void gaussMethod(Matrix m) {
        // KAMUS LOKAL

        // ALGORITMA

        m.gaussElimination(m);
    }

    public static Matrix gaussMethod(String fileName) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        //ALGORITMA
        m = new Matrix(fileName);
        m.gaussElimination(m);
        return m;
    }

    public static void gaussJordanMethod(Matrix m) {
        // KAMUS LOKAL

        // ALGORITMA
        m.gaussJordanElimination(m);
        m.displayMatrix();
    }

    public static Matrix gaussJordanMethod(String fileName) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA
        m = new Matrix(fileName);
        m.gaussJordanElimination(m);
        return m;
    }

    public static void inversMethod(Matrix m) {
        // Memecahkan SPL dengan metode matriks balikan
        // KAMUS LOKAL
        Matrix minv, mcons, mhasil;
        int i, j;

        // ALGORITMA
        
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
            for (i = 0; i < mhasil.RowEff; i ++) {
                for (j = 0; j < mhasil.ColEff; j ++) {
                    System.out.println("x" + (i + 1) + " = " + mhasil.Content[i][j]);
                }
            }
        } else {
            System.out.println("Matriks tidak mempunyai invers.");
        }
    }

    public static void inversMethod(Matrix m, String fileOut) {
        // Memecahkan SPL dengan metode matriks balikan
        // KAMUS LOKAL
        Matrix minv, mcons, mhasil;
        int i, j;

        // ALGORITMA
        
        minv = new Matrix(m.RowEff, m.ColEff-1);

        for (i = 0; i < minv.RowEff; i ++) {
            for (j = 0; j < minv.ColEff; j ++) {
                minv.Content[i][j] = m.Content[i][j];
            }
        }

        try {
            FileWriter writer = new FileWriter(fileOut);
            if (minv.isSquare(minv) && minv.determinantCofactor(minv) != 0) {
                minv = minv.inverseCofaktor(minv);
                mcons = new Matrix(m.RowEff, 1);
                for (i = 0; i < m.RowEff; i ++) {
                    mcons.Content[i][0] = m.Content[i][m.ColEff-1];
                }
                mhasil = new Matrix(m.RowEff, 1);
                mhasil = minv.multiplyMatrix(minv, mcons);
                for (i = 0; i < mhasil.RowEff; i ++) {
                    for (j = 0; j < mhasil.ColEff; j ++) {
                        writer.write(String.valueOf("x" + (i + 1) + " = " + mhasil.Content[i][j] + "\n"));
                    }
                }
                writer.close();
            } else {
                System.out.println("Matriks tidak mempunyai invers. Keterangan berhasil ditulis ke dalam file.");
                writer.write("Matriks tidak mempunyai invers.");
                writer.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void inversMethod(String fileName) throws FileNotFoundException {
        // Memecahkan SPL dengan metode matriks balikan
        // KAMUS LOKAL
        Matrix m, minv, mcons, mhasil;
        int i, j;

        // ALGORITMA
        m = new Matrix(fileName);
        
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
            for (i = 0; i < mhasil.RowEff; i ++) {
                for (j = 0; j < mhasil.ColEff; j ++) {
                    System.out.println("x" + (i + 1) + " = " + mhasil.Content[i][j]);
                }
            }
        } else {
            System.out.println("Matriks tidak mempunyai invers.");
        }
    }

    public static void inversMethod(String fileName, String fileOut) throws FileNotFoundException {
        // Memecahkan SPL dengan metode matriks balikan
        // KAMUS LOKAL
        Matrix m, minv, mcons, mhasil;
        int i, j;

        // ALGORITMA
        m = new Matrix(fileName);
        
        minv = new Matrix(m.RowEff, m.ColEff-1);

        for (i = 0; i < minv.RowEff; i ++) {
            for (j = 0; j < minv.ColEff; j ++) {
                minv.Content[i][j] = m.Content[i][j];
            }
        }

        try {
            FileWriter writer = new FileWriter(fileOut);
            if (minv.isSquare(minv) && minv.determinantCofactor(minv) != 0) {
                minv = minv.inverseCofaktor(minv);
                mcons = new Matrix(m.RowEff, 1);
                for (i = 0; i < m.RowEff; i ++) {
                    mcons.Content[i][0] = m.Content[i][m.ColEff-1];
                }
                mhasil = new Matrix(m.RowEff, 1);
                mhasil = minv.multiplyMatrix(minv, mcons);
                for (i = 0; i < mhasil.RowEff; i ++) {
                    for (j = 0; j < mhasil.ColEff; j ++) {
                        writer.write(String.valueOf("x" + (i + 1) + " = " + mhasil.Content[i][j] + "\n"));
                    }
                }
                writer.close();
            } else {
                System.out.println("Matriks tidak mempunyai invers. Keterangan berhasil ditulis ke dalam file.");
                writer.write("Matriks tidak mempunyai invers.");
                writer.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void cramerMethod(Matrix m) {
        // KAMUS LOKAL 
        ArrayList<Double> arrayHasil;
        int i, k, l;
        Matrix mTest;

        // ALGORITMA

        mTest = new Matrix(m.RowEff, m.ColEff - 1);
        arrayHasil = new ArrayList<Double>();

        for (k = 0; k < mTest.RowEff; k ++) {
            for (l = 0; l < mTest.ColEff; l ++) {
                mTest.Content[k][l] = m.Content[k][l];
            }
        }

        if (mTest.isSquare(mTest) && mTest.determinantCofactor(mTest) != 0) {
            arrayHasil = m.cramerRule(m);
            for (i = 0; i < arrayHasil.size(); i ++) {
                System.out.println("x" + (i + 1) + " = " + arrayHasil.get(i));
            }
        } else {
            System.out.println("Determinan matriks sama dengan nol. Tidak bisa menggunakan metode cramer.");
        }
        

    }   

    public static void cramerMethod(Matrix m, String fileOut) {
        // KAMUS LOKAL 
        ArrayList<Double> arrayHasil;
        int i, k, l;
        Matrix mTest;

        // ALGORITMA

        mTest = new Matrix(m.RowEff, m.ColEff - 1);
        arrayHasil = new ArrayList<Double>();

        for (k = 0; k < mTest.RowEff; k ++) {
            for (l = 0; l < mTest.ColEff; l ++) {
                mTest.Content[k][l] = m.Content[k][l];
            }
        }

        try {
            FileWriter writer = new FileWriter(fileOut);
            if (mTest.isSquare(mTest) && mTest.determinantCofactor(mTest) != 0) {
                arrayHasil = m.cramerRule(m);
                for (i = 0; i < arrayHasil.size(); i ++) {
                    writer.write(String.valueOf("x" + (i + 1) + " = " + arrayHasil.get(i) + "\n"));
                }
                writer.close();
            } else {
                System.out.println("Determinan matriks sama dengan nol. Tidak bisa menggunakan metode cramer.\nKeterangan berhasil ditulis ke dalam file.");
                writer.write("Determinan matriks sama dengan nol. Tidak bisa menggunakan metode cramer.");
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   

    public static void cramerMethod(String fileName) throws FileNotFoundException {
        // KAMUS LOKAL 
        int i, k, l;
        Matrix m, mTest;
        ArrayList<Double> arrayHasil;

        // ALGORITMA
        m = new Matrix(fileName);
        mTest = new Matrix(m.RowEff, m.ColEff - 1);
        arrayHasil = new ArrayList<Double>();

        for (k = 0; k < mTest.RowEff; k ++) {
            for (l = 0; l < mTest.ColEff; l ++) {
                mTest.Content[k][l] = m.Content[k][l];
            }
        }

        if (mTest.isSquare(mTest) && mTest.determinantCofactor(mTest) != 0) {
            arrayHasil = m.cramerRule(m);
            for (i = 0; i < arrayHasil.size(); i ++) {
                System.out.println("x" + (i + 1) + " = " + arrayHasil.get(i));
            }
        } else {
            System.out.println("Determinan matriks sama dengan nol. Tidak bisa menggunakan metode cramer.");
        }
        

    }   

    public static void cramerMethod(String fileName, String fileOut) throws FileNotFoundException {
        // KAMUS LOKAL 
        ArrayList<Double> arrayHasil;
        int i, k, l;
        Matrix m, mTest;

        // ALGORITMA
        m = new Matrix(fileName);
        mTest = new Matrix(m.RowEff, m.ColEff - 1);
        arrayHasil = new ArrayList<Double>();

        for (k = 0; k < mTest.RowEff; k ++) {
            for (l = 0; l < mTest.ColEff; l ++) {
                mTest.Content[k][l] = m.Content[k][l];
            }
        }

        try {
            FileWriter writer = new FileWriter(fileOut);
            if (mTest.isSquare(mTest) && mTest.determinantCofactor(mTest) != 0) {
                arrayHasil = m.cramerRule(m);
                for (i = 0; i < arrayHasil.size(); i ++) {
                    writer.write(String.valueOf("x" + (i + 1) + " = " + arrayHasil.get(i) + "\n"));
                }
                writer.close();
            } else {
                System.out.println("Determinan matriks sama dengan nol. Tidak bisa menggunakan metode cramer.\nKeterangan berhasil ditulis ke dalam file.");
                writer.write("Determinan matriks sama dengan nol. Tidak bisa menggunakan metode cramer.");
                writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
}