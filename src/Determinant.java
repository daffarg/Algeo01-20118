import java.util.*;

public class Determinant {
    Scanner input = new Scanner(System.in);

    public void OBEMethod(Matrix m) {
        System.out.print("Masukan jumlah baris matriks: ");
        int M = input.nextInt();
        System.out.print("Masukan jumlah kolom matriks: ");
        int N = input.nextInt();
        
        m.RowEff = M;
        m.ColEff = N;
        m.readMatrix();

        if (m.isSquare(m)) {
            System.out.println("Determinan matriks adalah " + m.determinantOBE(m));
        } else {
            System.out.println("Matriks bukan matriks persegi.");
        }
    }
}
