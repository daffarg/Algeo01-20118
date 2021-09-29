import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.lang.Math;
import java.io.File;

public class Interpolasi {
    static Scanner input = new Scanner(System.in);

    public static Object[] fileToMatrix (String fileName) throws FileNotFoundException {
        // KAMUS LOKAL
        int i, j;
        ArrayList<ArrayList<Double>> arrayPoint = new ArrayList<ArrayList<Double>>();
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        Matrix m;

        // ALGORITMA

        int row = 0;

        while (scan.hasNextLine()) {
            arrayPoint.add(new ArrayList<Double>());
            String rowData = scan.nextLine();
            Scanner scanrowData = new Scanner(rowData);

            while (scanrowData.hasNextDouble()) {
                arrayPoint.get(row).add(scanrowData.nextDouble());
            }
            row = row + 1;
        }

        m = new Matrix(row, row + 1);

        for (i = 0; i < row; i ++) {
            for (j = 0; j < row; j ++) {
                m.Content[i][j] = Math.pow(arrayPoint.get(i).get(0), j);
            }
            m.Content[i][m.ColEff-1] = arrayPoint.get(i).get(1);
        }

        Object[] tuple = new Object[2];
        tuple[0] = m;
        tuple[1] = row;

        return tuple;
    }

    public static void interpolasiKeyInput(Matrix m) {
        // PREKONDISI: SPL mempunyai solusi tunggal
        // KAMUS LOKAL
        ArrayList<Double> valcons;
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
        valcons = new ArrayList<Double>();
        for (i = 0; i < m.RowEff; i ++) {
            valcons.add(m.Content[i][m.ColEff-1]);
        }

        System.out.println("Masukkan nilai yang ingin ditaksir: ");
        x = input.nextDouble();

        int result = 0;
        for (i = 0; i < valcons.size(); i ++) {
            result += Math.pow(x, i) * valcons.get(i);
        }
        System.out.println("Nilai fungsi pada x = " + x + " dapat ditaksir dengan nilai " + result);
    }

    public static void interpolasiKeyInput(Matrix m, String fileOut) {
        // PREKONDISI: SPL mempunyai solusi tunggal
        // KAMUS LOKAL
        ArrayList<Double> valcons;
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
        valcons = new ArrayList<Double>();
        for (i = 0; i < m.RowEff; i ++) {
            valcons.add(m.Content[i][m.ColEff-1]);
        }

        System.out.println("Masukkan nilai yang ingin ditaksir: ");
        x = input.nextDouble();

        int result = 0;
        for (i = 0; i < valcons.size(); i ++) {
            result += Math.pow(x, i) * valcons.get(i);
        }
        try {
            FileWriter writer = new FileWriter(fileOut);
            writer.write(String.valueOf("Nilai fungsi pada x = " + x + " dapat ditaksir dengan nilai " + result));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void interpolasiKeyInput(String fileName) throws FileNotFoundException {
        // PREKONDISI: SPL mempunyai solusi tunggal
        // KAMUS LOKAL
        ArrayList<Double> valcons;
        int i;
        double x;
        Object[] t = new Object[2];
        Matrix m;

        // ALGORITMA
        t = fileToMatrix(fileName);
        m = new Matrix((Integer)t[1], (Integer)(t[1])+1);
        m.copyMatrix((Matrix)t[0], m);

        m.gaussJordanElimination(m);
        valcons = new ArrayList<Double>();
        for (i = 0; i < m.RowEff; i ++) {
            valcons.add(m.Content[i][m.ColEff-1]);
        }

        System.out.println("Masukkan nilai yang ingin ditaksir: ");
        x = input.nextDouble();

        int result = 0;
        for (i = 0; i < valcons.size(); i ++) {
            result += Math.pow(x, i) * valcons.get(i);
        }
        System.out.println("Nilai fungsi pada x = " + x + " dapat ditaksir dengan nilai " + result);
    }

    public static void interpolasiKeyInput(String fileName, String fileOut) throws FileNotFoundException {
        // PREKONDISI: SPL mempunyai solusi tunggal
        // KAMUS LOKAL
        ArrayList<Double> valcons;
        int i;
        double x;
        Object[] t = new Object[2];
        Matrix m;

        // ALGORITMA
        t = fileToMatrix(fileName);
        m = new Matrix((Integer)t[1], (Integer)(t[1])+1);
        m.copyMatrix((Matrix)t[0], m);

        m.gaussJordanElimination(m);
        valcons = new ArrayList<Double>();
        for (i = 0; i < m.RowEff; i ++) {
            valcons.add(m.Content[i][m.ColEff-1]);
        }

        System.out.println("Masukkan nilai yang ingin ditaksir: ");
        x = input.nextDouble();

        int result = 0;
        for (i = 0; i < valcons.size(); i ++) {
            result += Math.pow(x, i) * valcons.get(i);
        }
        try {
            FileWriter writer = new FileWriter(fileOut);
            writer.write(String.valueOf("Nilai fungsi pada x = " + x + " dapat ditaksir dengan nilai " + result));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
