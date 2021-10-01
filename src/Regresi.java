import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class Regresi {
    static Scanner input = new Scanner(System.in);
    public static void readRegresi(Matrix m) {
        // KAMUS LOKAL
        int numOfData, numOfFac;
        int i, j, k;
        double val;
        ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>();

        // ALGORITMA
        System.out.println("Masukkan jumlah peubah: ");
        numOfFac = input.nextInt();
        System.out.println("Masukkan jumlah sampel: ");
        numOfData = input.nextInt();


        // Membaca data sebanyak numOfData dengan peubah sebanyak numOfFac + 1 (tambah 1 karena membaca nilai y juga)
        for (i = 0; i < numOfData; i ++) {
            data.add(new ArrayList<Double>());
            System.out.println("Masukkan data untuk sampel ke-" + (i + 1));
            for (j = 0; j < numOfFac + 1; j ++) {
                val = input.nextDouble();
                data.get(i).add(val);
            }
        }

        m.RowEff = numOfFac + 1;
        m.ColEff = numOfFac + 2; 


        // Mengisi mariks baris pertama
        for (j = 0; j < m.ColEff; j ++) {
            if (j == 0) {
                m.Content[0][j] = numOfData;
            } else {
                m.Content[0][j] = 0;
                for (k = 0; k < numOfData; k ++) {
                    m.Content[0][j] += data.get(k).get(j - 1);
                }
            }
        }

        // Mengisi matriks baris berikutnya
        for (i = 1; i < m.RowEff; i++) {
            for (j = 0; j < m.ColEff; j++) {
                m.Content[i][j] = 0;
                if (j == 0) {
                    for (k = 0; k < numOfData; k++) {
                        m.Content[i][j] += data.get(k).get(i-1);
                    }
                } else {
                    for (k = 0; k < numOfData; k++) {
                        m.Content[i][j] += data.get(k).get(j-1)*data.get(k).get(i-1);
                    }
                }
            }
        } 
    }

    public static void readRegresi(Matrix m, String fileName) throws FileNotFoundException {
        // KAMUS LOKAL
        int i, j, k;
        Matrix mData;

        mData = new Matrix(fileName);


        // Mengisi mariks baris pertama
        for (j = 0; j < m.ColEff; j ++) {
            if (j == 0) {
                m.Content[0][j] = mData.RowEff;
            } else {
                m.Content[0][j] = 0;
                for (k = 0; k < mData.RowEff; k ++) {
                    m.Content[0][j] += mData.Content[k][j - 1];
                }
            }
        }

        // Mengisi matriks baris berikutnya
        for (i = 1; i < m.RowEff; i++) {
            for (j = 0; j < m.ColEff; j++) {
                m.Content[i][j] = 0;
                if (j == 0) {
                    for (k = 0; k < mData.RowEff; k++) {
                        m.Content[i][j] += mData.Content[k][i-1];
                    }
                } else {
                    for (k = 0; k < mData.RowEff; k++) {
                        m.Content[i][j] += mData.Content[k][j-1]*mData.Content[k][i-1];
                    }
                }
            }
        }
    }

    public static double solutionRegression(Matrix m) {
        // KAMUS LOKAL
        ArrayList<Double> valcons;
        ArrayList<Double> dataX;
        int i;
        double xval;
        double est;

        // ALGORITMA

        // Memasukkan solusi SPL ke dalam array list
        m.gaussJordanElimination(m);
        valcons = new ArrayList<Double>();
        for (i = 0; i < m.RowEff; i ++) {
            valcons.add(m.Content[i][m.ColEff-1]);
        }

        // Meminta input user 
        dataX = new ArrayList<Double>();
        System.out.println("Masukkan nilai-nilai x yang akan ditaksir: ");
        for (i = 0; i < m.RowEff-1; i ++) {
            xval = input.nextDouble();
            dataX.add(xval);
        }

        // Menghitung nilai taksiran
        est = valcons.get(0);
        for (i = 1; i < m.RowEff; i ++) {
            est += valcons.get(i)*dataX.get(i-1);
        }
        return est;
    }

    public static void returnEstimate(double x) {
        System.out.println("Taksiran nilai-nilai x = " + x);
    }

    public static void returnEstimate(double x, String fileOut) {
        try {
            FileWriter writer = new FileWriter(fileOut);
            writer.write(String.valueOf("Taksiran nilai-nilai x = " + x));
            writer.close();
            System.out.println("Jawaban berhasil ditulis ke dalam file.");
          } catch (Exception e) {
            e.printStackTrace();
          }
    }
}
