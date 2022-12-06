package Day2;

import java.util.Scanner;

public class Day2_Latihan3 {
	public static void main(String[] args) {
		Scanner baca_nama = new Scanner(System.in);
		Scanner baca_cetak = new Scanner(System.in);

		System.out.print("Input Nama       : ");
		String nama = baca_nama.nextLine();
		System.out.print("Mau Cetak Berapa : ");
		int cetak = baca_cetak.nextInt();

		for (int i = 0; i < cetak; i++) {
			System.out.println(nama);
		}

		baca_nama.close();
		baca_cetak.close();

	}
}
