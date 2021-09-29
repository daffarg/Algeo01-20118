import java.util.*;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        int M, N;
        Matrix m;

        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah baris dan kolom matriks : ");
        M = input.nextInt();
        N = input.nextInt();
        m = new Matrix(M, N);
        System.err.print("\n");

        
        //Matrix mcopy = new Matrix(3,3);
        m.readMatrix();
        System.out.println('\n');
        m.displayMatrix();
        System.out.println('\n');
        System.out.println("Masukkan nama file: ");
        String namaFile;
        namaFile = input.next();

        Invers.inversOBEMethod(m, namaFile);
        //m.copyMatrix(m, mcopy);
        //mcopy.displayMatrix();
        //System.out.println('\n');
        /*m.gaussJordanElimination(m);
        m.displayMatrix(); */
        // System.out.printf("%.2f", m.determinantOBE(m));
        //System.out.println('\n');
        //System.out.println(m.getCofactor(m, 1, 0));
        //if (m.determinantCofactor(m) != 0) {
          //  m.inverseOBE(m).displayMatrix();
        //} else {
        //    System.out.println("Matriks tidak memiliki invers");
        //}
        //SPL.gaussMethod(m);
        //SPL.printSolution(SPL.returnSolution(m));
        //System.out.println("\n");
        //SPL.cramerMethod(m);
        //System.out.println("\n");
    }
}
