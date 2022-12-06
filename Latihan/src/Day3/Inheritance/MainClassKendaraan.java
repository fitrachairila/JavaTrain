package Day3.Inheritance;

public class MainClassKendaraan {
	public static void main(String[] args) {
		KendaraanDarat kd1 = new KendaraanDarat();
		KendaraanDarat kd2 = new KendaraanDarat();
		kd1.NamaKendaraan = "Truck";
		kd2.NamaKendaraan = "Bus";

		System.out.println("Nama kendaraan 1 : " + kd1.NamaKendaraan);
		System.out.println("Kendaraan 1 bergerak di : ");
		kd1.bergerak();
		
		System.out.println("");
		System.out.println("Nama kendaraan 2 : " + kd2.NamaKendaraan);
		System.out.println("Kendaraan 2 bergerak di : ");
		kd1.bergerak();
	}
}
