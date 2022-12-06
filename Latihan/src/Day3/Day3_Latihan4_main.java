package Day3;

public class Day3_Latihan4_main {
	public static void main(String[] args) {
		System.out.print("Start");

		Day3_Latihan4 k1 = new Day3_Latihan4();
		Day3_Latihan4 k2 = new Day3_Latihan4();

		k1.kendaraan = "Mobil";
		k1.bahanbakar = "Pertamax";

		k2.kendaraan = "Motor";
		k2.bahanbakar = "Pertalite";

		System.out.println("Nama Kendaraan 1        : " + k1.kendaraan);
		System.out.println("Bahan Bakar Kendaraan 1 : " + k1.bahanbakar);
				
		System.out.println("Nama Kendaraan 1        : " + k2.kendaraan);
		System.out.println("Bahan Bakar Kendaraan 1 : " + k2.bahanbakar);


		System.out.println(" ");
		System.out.print("End");
	}
}
