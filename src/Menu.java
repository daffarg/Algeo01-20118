import java.util.*;

public class Menu {
    public static int menu() throws NoSuchElementException {
        Scanner in = new Scanner(System.in);
        int pilihan = 0;

        System.out.println("\n================================");
        System.out.println("Menu");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks Balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Regresi Linear Berganda");
        System.out.println("6. Keluar\n==============");

        System.out.print("Masukan nomor pilihan: ");

        pilihan = in.nextInt();

        return pilihan;
    }    

    public static int jenisInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n1. Input dari Keyboard");
        System.out.println("2. Input dari File\n==============");
        System.out.print("Masukan: ");

        int pilihan = in.nextInt();

        return pilihan;
    }

    public static String inputFile() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nMasukkan nama file(.txt): ");

        String nameFile = in.nextLine();

        return nameFile;
    }

    public static int menuSpl() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n1. Metode Eliminasi Gauss");
        System.out.println("2. Metode Eliminasi Gauss-Jordan");
        System.out.println("3. Metode Matriks Balikan");
        System.out.println("4. Kaidah Cramer\n==============");
        System.out.print("Masukan: ");

        int pilihan = in.nextInt();

        return pilihan;
    }
    
    public static int MenuDeterminan() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n1. Metode Operasi Baris Elementer");
        System.out.println("2. Metode Matriks Kofaktor\n==============");
        System.out.print("Masukan: ");

        int pilihan = in.nextInt();

        return pilihan;
    }

    public static int MenuInvers() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n1. Metode Adjoin");
        System.out.println("2. Metode Eliminasi Gauss-Jordan\n==============");
        System.out.print("Masukan: ");

        int pilihan = in.nextInt();

        return pilihan;
    }
    
    public static void outputFile(Matrix M) {
        Scanner in = new Scanner(System.in);
        System.out.print("Apakah Anda ingin menyimpan solusi dalam file (y/n)? ");
        char c = in.next().charAt(0);
        if (c == 'y' || c == 'Y') {
            System.out.print("Masukan nama file (.txt): ");
            String file = in.next();
            Matrix.writeFile(file, M);
        }
    }
}