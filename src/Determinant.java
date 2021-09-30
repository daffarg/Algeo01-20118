import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileWriter;

public class Determinant {
    public static void OBEMethod(Matrix m) {
        // KAMUS LOKAL

        // ALGORITMA
        if (m.isSquare(m)) {
          	System.out.println("Determinan matriks adalah " + m.determinantOBE(m));
        } else {
          	System.out.println("Matriks tidak mempunyai determinan.");
        }
    }

    public static void OBEMethod(Matrix m, String fileOut) {
        // KAMUS LOKAL

        // ALGORITMA
		try {
			FileWriter writer = new FileWriter(fileOut);
			if (m.isSquare(m)) {
				writer.write(String.valueOf(m.determinantOBE(m)));	
				System.out.println("Jawaban berhasil ditulis ke dalam file.");
			} else {
				writer.write("Matriks tidak mempunyai determinan.");
				System.out.println("Matriks tidak mempunyai determinan. Keterangan berhasil ditulis ke dalam file.");
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public static void OBEMethod(String fileName) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA
        m = new Matrix(fileName);
		if (m.isSquare(m)) {
			System.out.println("Determinan matriks adalah " + m.determinantOBE(m));
	  	} else {
			System.out.println("Matriks tidak mempunyai determinan.");
	  	}
    }

    public static void OBEMethod(String fileName, String fileOut) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA
        m = new Matrix(fileName);
        try {
            FileWriter writer = new FileWriter(fileOut);
			if (m.isSquare(m)) {
				writer.write(String.valueOf(m.determinantOBE(m)));
				System.out.println("Jawaban berhasil ditulis ke dalam file.");
			} else {
				writer.write("Matriks tidak mempunyai determinan.");
				System.out.println("Matriks tidak mempunyai determinan. Keterangan berhasil ditulis ke dalam file.");
			}
            writer.close();
          } catch (Exception e) {
            e.printStackTrace();
          }
    }

    public static void cofactorMethod(Matrix m) {
        // KAMUS LOKAL

        // ALGORITMA
		if (m.isSquare(m)) {
			System.out.println("Determinan matriks adalah " + m.determinantCofactor(m));
		} else {
			System.out.println("Matriks tidak mempunyai determinan.");
		}
        
    }

    public static void cofactorMethod(Matrix m, String fileOut) {
        // KAMUS LOKAL

        // ALGORITMA
        try {
            FileWriter writer = new FileWriter(fileOut);
			if (m.isSquare(m)) {
				writer.write(String.valueOf(m.determinantCofactor(m)));
				System.out.println("Jawaban berhasil ditulis ke dalam file.");
			} else {
				System.out.println("Matriks tidak mempunyai determinan. Keterangan berhasil ditulis ke dalam file.");
			}
            writer.close();
          } catch (Exception e) {
            e.printStackTrace();
          }
    }


    public static void cofactorMethod(String fileName) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA
        m = new Matrix(fileName);
		if (m.isSquare(m)) {
			System.out.println("Determinan matriks adalah " + m.determinantCofactor(m));
		} else {
			System.out.println("Matriks tidak mempunyai determinan.");
		}
    }

    public static void cofactorMethod(String fileName, String fileOut) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA
        m = new Matrix(fileName);
        try {
            FileWriter writer = new FileWriter(fileOut);
			if (m.isSquare(m)) {
				writer.write(String.valueOf(m.determinantCofactor(m)));
				System.out.println("Jawaban berhasil ditulis ke dalam file.");
			} else {
				System.out.println("Matriks tidak mempunyai determinan. Keterangan berhasil ditulis ke dalam file.");
			}
            writer.close();
          } catch (Exception e) {
            e.printStackTrace();
          }
    }
}
