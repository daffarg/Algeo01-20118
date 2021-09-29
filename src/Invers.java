import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileWriter;

public class Invers {
    public static void inversOBEMethod(Matrix m) {
        // KAMUS LOKAL
        
        // ALGORITMA
        if (m.isSquare(m) && m.determinantCofactor(m) != 0) {
            m.inverseOBE(m).displayMatrix();
        } else {
            System.out.println("Matriks tidak mempunyai matriks balikan.");
        }
    }

    public static void inversOBEMethod(Matrix m, String fileOut) {
        // KAMUS LOKAL
        
        // ALGORITMA
        
        if (m.isSquare(m) && m.determinantCofactor(m) != 0) {
            Matrix.writeFile(fileOut, m.inverseOBE(m));
            System.out.println("Solusi berhasil ditulis ke dalam file.");
        } else {
            try {
                FileWriter myWriter = new FileWriter(fileOut);
                myWriter.write("Matriks tidak mempunyai matriks balikan.");
                myWriter.close();
                System.out.println("Matriks tidak mempunyai matriks balikan. Keterangan berhasil ditulis ke dalam file.");
              } catch (Exception e) {
                e.printStackTrace();
              }
        }
        
    }

    public static void inversOBEMethod(String fileName) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA
        m = new Matrix(fileName);
        if (m.isSquare(m) && m.determinantCofactor(m) != 0) {
            m.inverseOBE(m).displayMatrix();
        } else {
            System.out.println("Matriks tidak mempunyai matriks balikan");
        }
    }

    public static void inversOBEMethod(String fileName, String fileOut) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA
        m = new Matrix(fileName);
        if (m.isSquare(m) && m.determinantCofactor(m) != 0) {
            Matrix.writeFile(fileOut, m.inverseOBE(m));
            System.out.println("Solusi berhasil ditulis ke dalam file.");
        } else {
            try {
                FileWriter myWriter = new FileWriter(fileOut);
                myWriter.write("Matriks tidak mempunyai matriks balikan.");
                myWriter.close();
                System.out.println("Matriks tidak mempunyai matriks balikan. Keterangan berhasil ditulis ke dalam file.");
              } catch (Exception e) {
                e.printStackTrace();
              }
        }
    }

    public static void inverseCofactorMethod(Matrix m) {
        // KAMUS LOKAL

        // ALGORITMA 
        if (m.isSquare(m) && m.determinantCofactor(m) != 0) {
            m.inverseCofaktor(m).displayMatrix();
        } else {
            System.out.println("Matriks tidak mempunyai matriks balikan.");
        }
    }

    public static void inverseCofactorMethod(Matrix m, String fileOut) {
        // KAMUS LOKAL

        // ALGORITMA 
        if (m.isSquare(m) && m.determinantCofactor(m) != 0) {
            Matrix.writeFile(fileOut, m.inverseOBE(m));
            System.out.println("Solusi berhasil ditulis ke dalam file.");
        } else {
            try {
                FileWriter myWriter = new FileWriter(fileOut);
                myWriter.write("Matriks tidak mempunyai matriks balikan.");
                myWriter.close();
                System.out.println("Matriks tidak mempunyai matriks balikan. Keterangan berhasil ditulis ke dalam file.");
              } catch (Exception e) {
                e.printStackTrace();
              }
        }
    }

    public static void inverseCofactorMethod(String fileName) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA 
        m = new Matrix(fileName);
        if (m.isSquare(m) && m.determinantCofactor(m) != 0) {
            m.inverseCofaktor(m).displayMatrix();
        } else {
            System.out.println("Matriks tidak mempunyai matriks balikan.");
        }
    }

    public static void inverseCofactorMethod(String fileName, String fileOut) throws FileNotFoundException {
        // KAMUS LOKAL
        Matrix m;

        // ALGORITMA 
        m = new Matrix(fileName);
        if (m.isSquare(m) && m.determinantCofactor(m) != 0) {
            Matrix.writeFile(fileOut, m.inverseCofaktor(m));
        } else {
            try {
                FileWriter myWriter = new FileWriter(fileOut);
                myWriter.write("Matriks tidak mempunyai matriks balikan.");
                myWriter.close();
                System.out.println("Matriks tidak mempunyai matriks balikan. Keterangan berhasil ditulis ke dalam file.");
              } catch (Exception e) {
                e.printStackTrace();
              }
        }
    }
}
