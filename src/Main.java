import java.util.*;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Matrix m = new Matrix(3, 4);
        m.readMatrix();
        System.out.println('\n');
        m.displayMatrix();
        System.out.println('\n');
        m.gaussElimination(m);
        m.displayMatrix();
    }
}
