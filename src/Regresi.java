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
        
        for (i = 1; i < m.RowEff; i ++) {
            for (j = 0; j < m.ColEff; j++) {
                
            }
        }


    }
}
