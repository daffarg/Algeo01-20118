import java.util.*;

public class Variable {
    public void nonParametric(Matrix m) {
        // KAMUS LOKAL
        int i; 
        ArrayList<String> variable;
        // ALGORITMA
        variable = new ArrayList<String>();
        for (i = 0; i < m.RowEff; i ++) {
            variable.add("x" + i + 1);
        }
    }

    public void Parametric(Matrix m) {
        // KAMUS LOKAL
        int i;
        ArrayList<String> parametricList;
        // ALGORITMA
        parametricList = new ArrayList<String>();
        for (i = 0; i < m.RowEff - 1; i ++) {
            parametricList.add("r" + i + 1);
        }
    }   
}
