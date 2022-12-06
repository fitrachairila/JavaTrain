package Day3;

import Day3.Ikan;

public class Mainikan {

	public static void main(String[] args) {
		System.out.print("Start");
		
		Ikan Ikan1 = new Ikan();
		Ikan Ikan2 = new Ikan();
		
		Ikan1.nama = "Tongkol";
		Ikan1.habitat = "Laut";
		
		Ikan2.nama = "Lele";
		Ikan2.habitat = "Air Tawar";
		
		System.out.println("Nama Ikan 1    : " + Ikan1.nama);
		System.out.println("Habitat Ikan 1 : " + Ikan1.habitat);
		System.out.print("Bernafas : ");
		Ikan1.bernafas();

		System.out.println(" ");
		System.out.println("Nama Ikan 2    : " + Ikan2.nama);
		System.out.println("Habitat Ikan 2 : " + Ikan2.habitat);
		System.out.print("Bernafas : ");
		Ikan2.bernafas();
		
		System.out.println(" ");
		System.out.print("End");
	}

}
