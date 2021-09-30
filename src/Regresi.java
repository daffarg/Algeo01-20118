import java.util.*;

import java.io.*;

import java.lang.Math;

public class Regresi {
    static Scanner input = new Scanner(System.in);
    public static void readRegresi(Matrix m) {
        // KAMUS LOKAL
        int numOfData, numOfFac;
        int i, j, k;
        double val;
        ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> dataRow = new ArrayList<Double>();

        // ALGORITMA
        System.out.println("Masukkan jumlah peubah: ");
        numOfFac = input.nextInt();
        System.out.println("Masukkan jumlah sampel: ");
        numOfData = input.nextInt();

        // Inisialisasi array untuk menampung setiap sampel
        for (i = 0; i < numOfFac + 1; i ++) {
            dataRow.add(0.0);
        }

        // Membaca data sebanyak numOfData dengan peubah sebanyak numOfFac + 1 (tambah 1 karena membaca nilai y juga)
        for (i = 0; i < numOfData; i ++) {
            for (j = 0; j < numOfFac + 1; j ++) {
                System.out.println("Masukkan x" + (j + 1) + "untuk sampel ke-" + (i + 1));
                val = input.nextDouble();
                dataRow.set(j, val);
            }
            data.add(dataRow);
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

        // // Mengisi kolom pertama dari baris kedua

        // for (i = 1; i < m.RowEff; i ++) {
        //     m.Content[i][0] = 0;
        //     for (k = 0; k < numOfData; k ++) {
        //         m.Content[i][0] += data.get(k).get(i - 1);
        //     }
        // }

        // // Mengisi elemen matriks sisanya

        // for (i = 1; i < m.RowEff; i ++) {
        //     for (j = 1; j < m.ColEff; j ++) {
        //         m.Content[i][j] = 0;
        //         for (k = 0; k < numOfData; k ++) {
        //             m.Content[i][j] += data.get(k).get(i) * data.get(k).get(i - 1);
        //         }
        //     }
        // }
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

        // // Mengisi kolom pertama dari baris kedua

        // for (i = 1; i < m.RowEff; i ++) {
        //     m.Content[i][0] = 0;
        //     for (k = 0; k < numOfData; k ++) {
        //         m.Content[i][0] += data.get(k).get(i - 1);
        //     }
        // }

        // // Mengisi elemen matriks sisanya

        // for (i = 1; i < m.RowEff; i ++) {
        //     for (j = 1; j < m.ColEff; j ++) {
        //         m.Content[i][j] = 0;
        //         for (k = 0; k < numOfData; k ++) {
        //             m.Content[i][j] += data.get(k).get(i) * data.get(k).get(i - 1);
        //         }
        //     }
        // }
    }
}
