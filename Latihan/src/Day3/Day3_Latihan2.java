package Day3;

import java.util.Scanner;

public class Day3_Latihan2 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int[] deretA = { 3, 2, 1, 4, 5, 6, 9, 8, 202};
		//int snum = 4;
		
		System.out.println("Cari Bilangan ? ");
		int snum = kb.nextInt();
		boolean ada = false;

		for (int i = 0; i < deretA.length; i++) {
			if (deretA[i] == snum) {
				ada = true;
			}
		}

		if (ada == true) {
			System.out.println("Bilangan " + snum + " ada dalam Array");
		} else {
			System.out.println("Bilangan " + snum + " tidak ada dalam Array");
		}
		kb.close();
	}

}
