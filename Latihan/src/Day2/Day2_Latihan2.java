package Day2;

import java.util.Scanner;

public class Day2_Latihan2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner Read1 = new Scanner(System.in);
		System.out.print("Input Huruf    : ");
		String Huruf = Read1.nextLine();
		String Hasil = "";

		switch (Huruf.toUpperCase()) {
		case "A":
		case "I":
		case "U":
		case "E":
		case "O":
			Hasil = "Vokal";
			break;
		default:
			Hasil = "Konsonan";
		}
		System.out.println("Huruf " + Huruf + " Merupakan Huruf " + Hasil);
		Read1.close();
	}
}
