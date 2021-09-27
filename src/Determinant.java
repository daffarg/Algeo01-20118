import java.io.FileNotFoundException;
import java.util.*;

public class Determinant {
    Scanner input = new Scanner(System.in);

    public void OBEMethod(Matrix m) {
        // KAMUS LOKAL

        // ALGORITMA
        System.out.print("Masukan jumlah baris dan kolom matriks: ");
        int N = input.nextInt();
        
        m.RowEff = N;
        m.ColEff = N;
        m.readMatrix();

        System.out.println("Determinan matriks adalah " + m.determinantOBE(m));
    }

    public void OBEMethod(String fileName) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;
        // ALGORITMA
        
        m = new Matrix(fileName);

        System.out.println("Determinan matriks adalah " + m.determinantOBE(m));
    }

    public void cofactorMethod(Matrix m) {
        // KAMUS LOKAL

        // ALGORITMA
        System.out.print("Masukan jumlah baris dan kolom matriks: ");
        int N = input.nextInt();
        
        m.RowEff = N;
        m.ColEff = N;
        m.readMatrix();

        System.out.println("Determinan matriks adalah " + m.determinantCofactor(m));
    }

    public void cofactorMethod(String fileName) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;
        // ALGORITMA
        
        m = new Matrix(fileName);
        
        System.out.println("Determinan matriks adalah " + m.determinantCofactor(m));
    }
}
