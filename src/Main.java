import java.util.*;

import java.io.*;

public class Main {
	static Scanner input = new Scanner(System.in);
		public static void main(String[] args) throws FileNotFoundException {
			// KAMUS
			Matrix m = new Matrix(100, 100); // khusus input dari command line
			int selection = -999;
			int selection2 = -999;
			int jenisIn = -999;
			int M, N;

			char jenisOut = ' ';
			String fileName, fileOut;

			// ALGORITMA
			while (selection != 6) {
				selection = Menu.menu();
				if (selection == 1) {
					selection2 = Menu.menuSpl();
					switch (selection2) {
						case 1: 
							jenisIn = Menu.jenisInput();
							while (jenisIn != 1 && jenisIn != 2) { // Menanyakan kepada user sumber input (command line atau file)
								System.out.print("Input salah. Silakan ulangi.");
								jenisIn = input.nextInt();
							}
							if (jenisIn == 1) { // Jika sumber input adalah command line
								// INPUT DARI COMMAND LINE
								System.out.print("Masukkan jumlah baris (M) matriks: ");
								M = input.nextInt();
								System.out.print("Masukkan jumlah kolom (N) matriks: ");
								N = input.nextInt();
								m.RowEff = M;
								m.ColEff = N;
								m.readMatrix();
								SPL.gaussMethod(m);
								jenisOut = Menu.outputFile();
								while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
									System.out.print("Input salah. Silakan ulangi.");
									jenisOut = input.next().charAt(0);
								}
								if (jenisOut == 'y' || jenisOut == 'Y') {
									// OUTPUT KE FILE
									System.out.print("Masukkan nama file (.txt): ");
									fileOut = input.next();
									SPL.printSolution(SPL.returnSolutionGauss(m), fileOut);
								} else {
									// OUTPUT KE LAYAR
									SPL.printSolution(SPL.returnSolutionGauss(m));
								}	
							} else { // Jika sumber input adalah file
								// INPUT DARI FILE
								System.out.print("Masukkan nama file (.txt): ");
								fileName = input.next();
								jenisOut = Menu.outputFile();
								while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
									System.out.print("Input salah. Silakan ulangi.");
									jenisOut = input.next().charAt(0);
								}
								if (jenisOut == 'y' || jenisOut == 'Y') {
									// OUTPUT KE FILE
									System.out.print("Masukkan nama file (.txt): ");
									fileOut = input.next();
									SPL.printSolution(SPL.returnSolutionGauss(SPL.gaussMethod(fileName)), fileOut);
								} else {
									// OUTPUT KE LAYAR
									SPL.printSolution(SPL.returnSolutionGauss(SPL.gaussMethod(fileName)));
								}

							}					
							break;
						case 2: 
							jenisIn = Menu.jenisInput();
							while (jenisIn != 1 && jenisIn != 2) { // Menanyakan kepada user sumber input (command line atau file)
								System.out.print("Input salah. Silakan ulangi.");
								jenisIn = input.nextInt();
							}
							if (jenisIn == 1) { // Jika sumber input adalah command line
								// INPUT DARI COMMAND LINE
								System.out.print("Masukkan jumlah baris (M) matriks: ");
								M = input.nextInt();
								System.out.print("Masukkan jumlah kolom (N) matriks: ");
								N = input.nextInt();
								m.RowEff = M;
								m.ColEff = N;
								m.readMatrix();
								SPL.gaussMethod(m);
								jenisOut = Menu.outputFile();
								while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
									System.out.print("Input salah. Silakan ulangi.");
									jenisOut = input.next().charAt(0);
								}
								if (jenisOut == 'y' || jenisOut == 'Y') {
									// OUTPUT KE FILE
									System.out.print("Masukkan nama file (.txt): ");
									fileOut = input.next();
									SPL.printSolution(SPL.returnSolutionGaussJordan(m), fileOut);
								} else {
									// OUTPUT KE LAYAR
									SPL.printSolution(SPL.returnSolutionGaussJordan(m));
								}	
							} else { // Jika sumber input adalah file
								// INPUT DARI FILE
								System.out.print("Masukkan nama file (.txt): ");
								fileName = input.next();
								jenisOut = Menu.outputFile();
								while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
									System.out.print("Input salah. Silakan ulangi.");
									jenisOut = input.next().charAt(0);
								}
								if (jenisOut == 'y' || jenisOut == 'Y') {
									// OUTPUT KE FILE
									System.out.print("Masukkan nama file (.txt): ");
									fileOut = input.next();
									SPL.printSolution(SPL.returnSolutionGaussJordan(SPL.gaussJordanMethod(fileName)), fileOut);
								} else {
									// OUTPUT KE LAYAR
									SPL.printSolution(SPL.returnSolutionGaussJordan(SPL.gaussJordanMethod(fileName)));
								}
							}					
							break;
						case 3: 
							jenisIn = Menu.jenisInput();
							while (jenisIn != 1 && jenisIn != 2) { // Menanyakan kepada user sumber input (command line atau file)
								System.out.print("Input salah. Silakan ulangi.");
								jenisIn = input.nextInt();
							}
							if (jenisIn == 1) { // Jika sumber input adalah command line
								// INPUT DARI COMMAND LINE
								System.out.print("Masukkan jumlah baris (M) matriks: ");
								M = input.nextInt();
								System.out.print("Masukkan jumlah kolom (N) matriks: ");
								N = input.nextInt();
								m.RowEff = M;
								m.ColEff = N;
								m.readMatrix();
								jenisOut = Menu.outputFile();
								while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
									System.out.print("Input salah. Silakan ulangi.");
									jenisOut = input.next().charAt(0);
								}
								if (jenisOut == 'y' || jenisOut == 'Y') {
									// OUTPUT KE FILE
									System.out.print("Masukkan nama file (.txt): ");
									fileOut = input.next();
									SPL.inversMethod(m, fileOut);
								} else {
									// OUTPUT KE LAYAR
									SPL.inversMethod(m);
								}	
							} else { // Jika sumber input adalah file
								// INPUT DARI FILE
								System.out.print("Masukkan nama file (.txt): ");
								fileName = input.next();
								jenisOut = Menu.outputFile();
								while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
									System.out.print("Input salah. Silakan ulangi.");
									jenisOut = input.next().charAt(0);
								}
								if (jenisOut == 'y' || jenisOut == 'Y') {
									// OUTPUT KE FILE
									System.out.print("Masukkan nama file (.txt): ");
									fileOut = input.next();
									SPL.inversMethod(fileName, fileOut);;
								} else {
									// OUTPUT KE LAYAR
									SPL.inversMethod(fileName);
								}
							}					
							break;
						case 4:
							jenisIn = Menu.jenisInput();
							while (jenisIn != 1 && jenisIn != 2) { // Menanyakan kepada user sumber input (command line atau file)
								System.out.print("Input salah. Silakan ulangi.");
								jenisIn = input.nextInt();
							}
							if (jenisIn == 1) { // Jika sumber input adalah command line
								// INPUT DARI COMMAND LINE
								System.out.print("Masukkan jumlah baris (M) matriks: ");
								M = input.nextInt();
								System.out.print("Masukkan jumlah kolom (N) matriks: ");
								N = input.nextInt();
								m.RowEff = M;
								m.ColEff = N;
								m.readMatrix();
								jenisOut = Menu.outputFile();
								while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
									System.out.print("Input salah. Silakan ulangi.");
									jenisOut = input.next().charAt(0);
								}
								if (jenisOut == 'y' || jenisOut == 'Y') {
									// OUTPUT KE FILE
									System.out.print("Masukkan nama file (.txt): ");
									fileOut = input.next();
									SPL.cramerMethod(m, fileOut);
								} else {
									// OUTPUT KE LAYAR
									SPL.cramerMethod(m);
								}	
							} else { // Jika sumber input adalah file
								// INPUT DARI FILE
								System.out.print("Masukkan nama file (.txt): ");
								fileName = input.next();
								jenisOut = Menu.outputFile();
								while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
									System.out.print("Input salah. Silakan ulangi.");
									jenisOut = input.next().charAt(0);
								}
								if (jenisOut == 'y' || jenisOut == 'Y') {
									// OUTPUT KE FILE
									System.out.print("Masukkan nama file (.txt): ");
									fileOut = input.next();
									SPL.cramerMethod(fileName, fileOut);;
								} else {
									// OUTPUT KE LAYAR
									SPL.cramerMethod(fileName);
								}
							}					
							break;
						default:
							System.out.println("Masukan salah.");	
					}
				} else if (selection == 2) {
					selection2 = Menu.MenuDeterminan();
					switch (selection2) {
						case 1:
							jenisIn = Menu.jenisInput();
							while (jenisIn != 1 && jenisIn != 2) { // Menanyakan kepada user sumber input (command line atau file)
								System.out.print("Input salah. Silakan ulangi.");
								jenisIn = input.nextInt();
							}
							if (jenisIn == 1) { // Jika sumber input adalah command line
								// INPUT DARI COMMAND LINE
								System.out.print("Masukkan jumlah baris (M) matriks: ");
								M = input.nextInt();
								System.out.print("Masukkan jumlah kolom (N) matriks: ");
								N = input.nextInt();
								m.RowEff = M;
								m.ColEff = N;
								m.readMatrix();
								jenisOut = Menu.outputFile();
								while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
									System.out.print("Input salah. Silakan ulangi.");
									jenisOut = input.next().charAt(0);
								}
								if (jenisOut == 'y' || jenisOut == 'Y') {
									// OUTPUT KE FILE
									System.out.print("Masukkan nama file (.txt): ");
									fileOut = input.next();
									Determinant.OBEMethod(m, fileOut);
								} else {
									// OUTPUT KE LAYAR
									Determinant.OBEMethod(m);
								}	
							} else { // Jika sumber input adalah file
								// INPUT DARI FILE
								System.out.print("Masukkan nama file (.txt): ");
								fileName = input.next();
								jenisOut = Menu.outputFile();
								while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
									System.out.print("Input salah. Silakan ulangi.");
									jenisOut = input.next().charAt(0);
								}
								if (jenisOut == 'y' || jenisOut == 'Y') {
									// OUTPUT KE FILE
									System.out.print("Masukkan nama file (.txt): ");
									fileOut = input.next();
									Determinant.OBEMethod(fileName, fileOut);
								} else {
									// OUTPUT KE LAYAR
									Determinant.OBEMethod(fileName);
								}
							}
							break;
						case 2: 
							jenisIn = Menu.jenisInput();
							while (jenisIn != 1 && jenisIn != 2) { // Menanyakan kepada user sumber input (command line atau file)
								System.out.print("Input salah. Silakan ulangi.");
								jenisIn = input.nextInt();
							}
							if (jenisIn == 1) { // Jika sumber input adalah command line
								// INPUT DARI COMMAND LINE
								System.out.print("Masukkan jumlah baris (M) matriks: ");
								M = input.nextInt();
								System.out.print("Masukkan jumlah kolom (N) matriks: ");
								N = input.nextInt();
								m.RowEff = M;
								m.ColEff = N;
								m.readMatrix();
								jenisOut = Menu.outputFile();
								while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
									System.out.print("Input salah. Silakan ulangi.");
									jenisOut = input.next().charAt(0);
								}
								if (jenisOut == 'y' || jenisOut == 'Y') {
									// OUTPUT KE FILE
									System.out.print("Masukkan nama file (.txt): ");
									fileOut = input.next();
									Determinant.cofactorMethod(m, fileOut);
								} else {
									// OUTPUT KE LAYAR
									Determinant.cofactorMethod(m);
								}	
							} else { // Jika sumber input adalah file
								// INPUT DARI FILE
								System.out.print("Masukkan nama file (.txt): ");
								fileName = input.next();
								jenisOut = Menu.outputFile();
								while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
									System.out.print("Input salah. Silakan ulangi.");
									jenisOut = input.next().charAt(0);
								}
								if (jenisOut == 'y' || jenisOut == 'Y') {
									// OUTPUT KE FILE
									System.out.print("Masukkan nama file (.txt): ");
									fileOut = input.next();
									Determinant.cofactorMethod(fileName, fileOut);
								} else {
									// OUTPUT KE LAYAR
									Determinant.cofactorMethod(fileName);
								}
							}
							break;	
						default:
							System.out.println("Masukan salah.");	
				}
			} else if (selection == 3) {
				selection2 = Menu.MenuInvers();
				switch (selection2) {
					case 1:
						jenisIn = Menu.jenisInput();
						while (jenisIn != 1 && jenisIn != 2) { // Menanyakan kepada user sumber input (command line atau file)
							System.out.print("Input salah. Silakan ulangi.");
							jenisIn = input.nextInt();
						}
						if (jenisIn == 1) { // Jika sumber input adalah command line
							// INPUT DARI COMMAND LINE
							System.out.print("Masukkan jumlah baris (M) matriks: ");
							M = input.nextInt();
							System.out.print("Masukkan jumlah kolom (N) matriks: ");
							N = input.nextInt();
							m.RowEff = M;
							m.ColEff = N;
							m.readMatrix();
							jenisOut = Menu.outputFile();
							while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
								System.out.print("Input salah. Silakan ulangi.");
								jenisOut = input.next().charAt(0);
							}
							if (jenisOut == 'y' || jenisOut == 'Y') {
								// OUTPUT KE FILE
								System.out.print("Masukkan nama file (.txt): ");
								fileOut = input.next();
								Invers.inversOBEMethod(m, fileOut);
							} else {
								// OUTPUT KE LAYAR
								Invers.inversOBEMethod(m);
							}	
						} else { // Jika sumber input adalah file
							// INPUT DARI FILE
							System.out.print("Masukkan nama file (.txt): ");
							fileName = input.next();
							jenisOut = Menu.outputFile();
							while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
								System.out.print("Input salah. Silakan ulangi.");
								jenisOut = input.next().charAt(0);
							}
							if (jenisOut == 'y' || jenisOut == 'Y') {
								// OUTPUT KE FILE
								System.out.print("Masukkan nama file (.txt): ");
								fileOut = input.next();
								Invers.inversOBEMethod(fileName, fileOut);
							} else {
								// OUTPUT KE LAYAR
								Invers.inversOBEMethod(fileName);
							}
						}
						break;
					case 2: 
						jenisIn = Menu.jenisInput();
						while (jenisIn != 1 && jenisIn != 2) { // Menanyakan kepada user sumber input (command line atau file)
							System.out.print("Input salah. Silakan ulangi.");
							jenisIn = input.nextInt();
						}
						if (jenisIn == 1) { // Jika sumber input adalah command line
							// INPUT DARI COMMAND LINE
							System.out.print("Masukkan jumlah baris (M) matriks: ");
							M = input.nextInt();
							System.out.print("Masukkan jumlah kolom (N) matriks: ");
							N = input.nextInt();
							m.RowEff = M;
							m.ColEff = N;
							m.readMatrix();
							jenisOut = Menu.outputFile();
							while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
								System.out.print("Input salah. Silakan ulangi.");
								jenisOut = input.next().charAt(0);
							}
							if (jenisOut == 'y' || jenisOut == 'Y') {
								// OUTPUT KE FILE
								System.out.print("Masukkan nama file (.txt): ");
								fileOut = input.next();
								Invers.inverseCofactorMethod(m, fileOut);
							} else {
								// OUTPUT KE LAYAR
								Invers.inverseCofactorMethod(m);
							}	
						} else { // Jika sumber input adalah file
							// INPUT DARI FILE
							System.out.print("Masukkan nama file (.txt): ");
							fileName = input.next();
							jenisOut = Menu.outputFile();
							while (jenisOut != 'y' && jenisOut != 'Y' && jenisOut != 'n' && jenisOut != 'N') {
								System.out.print("Input salah. Silakan ulangi.");
								jenisOut = input.next().charAt(0);
							}
							if (jenisOut == 'y' || jenisOut == 'Y') {
								// OUTPUT KE FILE
								System.out.print("Masukkan nama file (.txt): ");
								fileOut = input.next();
								Invers.inverseCofactorMethod(fileName, fileOut);
							} else {
								// OUTPUT KE LAYAR
								Invers.inverseCofactorMethod(fileName);
							}
						}
						break;	
					default:
						System.out.println("Masukan salah.");	
				}
			}

		}
	}
}
