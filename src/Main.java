import java.util.*;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Matrix m = new Matrix(3, 3);
        //Matrix mcopy = new Matrix(3,3);
        m.readMatrix();
        System.out.println('\n');
        m.displayMatrix();
        System.out.println('\n');
        //m.copyMatrix(m, mcopy);
        //mcopy.displayMatrix();
        System.out.println('\n');
        /*m.gaussJordanElimination(m);
        m.displayMatrix(); */
        System.out.printf("%.2f", m.determinantOBE(m));
        //System.out.println('\n');
        //System.out.println(m.getCofactor(m, 1, 0));

    }
}
