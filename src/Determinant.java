import java.io.FileNotFoundException;
import java.util.*;

public class Determinant {
    public static void OBEMethod(Matrix m) {
        // KAMUS LOKAL

        // ALGORITMA

        System.out.println("Determinan matriks adalah " + m.determinantOBE(m));
    }

    public static void OBEMethod(String fileName) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA
        m = new Matrix(fileName);
        System.out.println("Determinan matriks adalah " + m.determinantOBE(m));
    }

    public static void cofactorMethod(Matrix m) {
        // KAMUS LOKAL

        // ALGORITMA

        System.out.println("Determinan matriks adalah " + m.determinantCofactor(m));
    }

    public static void cofactorMethod(String fileName) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA
        m = new Matrix(fileName);
        System.out.println("Determinan matriks adalah " + m.determinantCofactor(m));
    }
}
