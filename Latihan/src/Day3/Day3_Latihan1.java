package Day3;

import java.util.Scanner;

public class Day3_Latihan1 {
	public static void main(String[] args) {
		Scanner Arr = new Scanner(System.in);

		System.out.print("Input Banyak Ikan : ");
		int Count = Arr.nextInt();
		Arr.nextLine();
		String[]Lauk1 = new String[Count];

		for (int i = 0; i < Lauk1.length; i++) {
			System.out.print("Ikan Ke " + (i+1) + " :");
			Lauk1[i] = Arr.nextLine();
		}

		System.out.println("===============");
		System.out.println("Macam Ikan : ");
		for(int i=0;i<Lauk1.length;i++) {
			System.out.println((i+1) + "." + Lauk1[i]+ " ");
		}
		
		Arr.close();
	}
}
