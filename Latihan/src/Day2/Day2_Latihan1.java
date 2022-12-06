package Day2;

import java.util.Scanner;

public class Day2_Latihan1 {

	public static void main(String[] args) {
		Scanner Read1 = new Scanner(System.in);
		String Hasil = " ";

		System.out.print("Input Bilangan    : ");
		int Bilangan = Read1.nextInt();

		if (Bilangan <= 5) {
			System.out.println("Bilangan Tidak dihitung");
		} else {

			if (Bilangan % 2 == 0) {
				Hasil = "Genap";
			} else
				Hasil = "Ganjil";
			System.out.println("Bilangan " + Bilangan + " Merupakan " + Hasil);
			Read1.close();
		}
	}

}
