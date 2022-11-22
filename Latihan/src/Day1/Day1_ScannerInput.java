package Day1;
import java.util.Scanner;

public class Day1_ScannerInput {
	public static void main(String[] args){
		//int Nilai_A = 15;
		//int Nilai_B = 3;
		int Hasil = 0;
		Scanner Read1 = new Scanner(System.in);
		Scanner Read2 = new Scanner(System.in);
		Scanner Read3 = new Scanner(System.in);
		
		System.out.print("Input Nama    : ");
		String Nama = Read3.nextLine();
		
		System.out.print("Input Nilai A : ");
		int Nilai_A = Read1.nextInt();
		
		System.out.print("Input Nilai B : ");
		int Nilai_B = Read2.nextInt();
		
		Hasil = Nilai_A + Nilai_B ;
		
		System.out.println();
		System.out.println("Nama Anda Adalah : " + Nama);
		System.out.println("Nilai A Adalah " + Nilai_A);
		System.out.println("Nilai B Adalah " + Nilai_B);
		System.out.println("Hasil Penjumlahan " + Nilai_A + " + " + Nilai_B + " Adalah " + Hasil);
		    
	  
	}
}
