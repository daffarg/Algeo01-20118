import java.util.*;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Matrix m = new Matrix(3, 3);
        m.readMatrix();
        System.out.println('\n');
        m.displayMatrix();
        System.out.println('\n');
        /*m.gaussJordanElimination(m);
        m.displayMatrix(); */
        System.out.printf("%f", m.determinantCofactor(m));

    }
}
