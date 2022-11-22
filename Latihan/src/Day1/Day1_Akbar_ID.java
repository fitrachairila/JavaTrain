package Day1;
import java.util.Scanner;

public class Day1_Akbar_ID {
	public static void main(String[] args){
		//int Nilai_A = 15;
		//int Nilai_B = 3;
		//int Hasil = 0;
		Scanner Read1 = new Scanner(System.in);
		Scanner Read2 = new Scanner(System.in);
		Scanner Read3 = new Scanner(System.in);
		
		System.out.print("Input Nama    : ");
		String Nama = Read3.nextLine();
		
		System.out.print("Input Asal    : ");
		String Asal = Read1.nextLine();
		
		System.out.print("Input Umur    : ");
		int Umur = Read2.nextInt();
		
		//Hasil = Nilai_A + Nilai_B ;
		
		System.out.println();
		System.out.println("Data Input");
		System.out.println("Nama   : " + Nama);
		System.out.println("Asal   : " + Asal);
		System.out.println("Umur   : " + Umur);
		
		Read1.close();
		Read2.close();
		Read3.close();
	}
}
