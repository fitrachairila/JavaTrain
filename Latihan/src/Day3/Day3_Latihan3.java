package Day3;

import java.util.Scanner;

public class Day3_Latihan3 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Input Nama Panjang :");
		String name = kb.nextLine();

		// String name = "Arnold Suasana Siregar";
		// Split
		// String Nama2 = "Fitra Chairil Akbar";
		// System.out.println("Hasil Split :");
		// System.out.println(spname[0]);
		// System.out.println(spname[1]);
		// System.out.println(spname[2]);
		
		//Split Character
		String[] spname = name.split(" ");
		for (int i = 0; i < spname.length; i++) {
			String fname = spname[i].substring(0, 1);
			System.out.println(spname[i]);
			System.out.println(fname);
			System.out.println("");
		}
		
		//Split Upercase First Character
		String[] spname2 = name.split(" ");
		for (int x = 0; x < spname2.length; x++) {
			String hd = spname2[x].substring(0, 1).toUpperCase();
			String hs = spname2[x].substring(1);
			System.out.println(hd + hs);
		}
		
		//Split Huruf Awal & Akhir
		String[] spname3 = name.split(" ");
		for (int b = 0; b < spname.length; b++) {
			String hd = spname3[b].substring(0,1).toUpperCase();
			String hb = spname3[b].substring(spname3[b].length()-1).toUpperCase();
			System.out.println(hd+ " " + hb);
		}

		//System.out.println(spname[spname.length - 1]);
		kb.close();

	}

}
