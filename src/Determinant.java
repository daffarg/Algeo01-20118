import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileWriter;

public class Determinant {
    public static void OBEMethod(Matrix m) {
        // KAMUS LOKAL

        // ALGORITMA

        System.out.println("Determinan matriks adalah " + m.determinantOBE(m));
    }

    public static void OBEMethod(Matrix m, String fileOut) {
        // KAMUS LOKAL

        // ALGORITMA
        try {
            FileWriter writer = new FileWriter(fileOut);
            writer.write(String.valueOf(m.determinantOBE(m)));
            writer.close();
            System.out.println("Jawaban berhasil ditulis ke dalam file.");
          } catch (Exception e) {
            e.printStackTrace();
          }
    }

    public static void OBEMethod(String fileName) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA
        m = new Matrix(fileName);
        System.out.println("Determinan matriks adalah " + m.determinantOBE(m));
    }

    public static void OBEMethod(String fileName, String fileOut) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA
        m = new Matrix(fileName);
        try {
            FileWriter writer = new FileWriter(fileOut);
            writer.write(String.valueOf(m.determinantOBE(m)));
            writer.close();
            System.out.println("Jawaban berhasil ditulis ke dalam file.");
          } catch (Exception e) {
            e.printStackTrace();
          }
    }

    public static void cofactorMethod(Matrix m) {
        // KAMUS LOKAL

        // ALGORITMA

        System.out.println("Determinan matriks adalah " + m.determinantCofactor(m));
    }

    public static void cofactorMethod(Matrix m, String fileOut) {
        // KAMUS LOKAL

        // ALGORITMA
        try {
            FileWriter writer = new FileWriter(fileOut);
            writer.write(String.valueOf(m.determinantCofactor(m)));
            writer.close();
            System.out.println("Jawaban berhasil ditulis ke dalam file.");
          } catch (Exception e) {
            e.printStackTrace();
          }
    }


    public static void cofactorMethod(String fileName) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA
        m = new Matrix(fileName);
        System.out.println("Determinan matriks adalah " + m.determinantCofactor(m));
    }

    public static void cofactorMethod(String fileName, String fileOut) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA
        m = new Matrix(fileName);
        try {
            FileWriter writer = new FileWriter(fileOut);
            writer.write(String.valueOf(m.determinantCofactor(m)));
            writer.close();
            System.out.println("Jawaban berhasil ditulis ke dalam file.");
          } catch (Exception e) {
            e.printStackTrace();
          }
    }
}
