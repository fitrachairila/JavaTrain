package Day3;

public class ArrayEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Deklarasi Array
				String[]nama = new String[5];
				String[]kota = {"Semarang","Banten","Jakarta"};
				
				nama[0] = "Aldo";
				for (int i=0; i<nama.length; i++) {
					nama[i] = "isi : " + i;
					System.out.println(nama[i]);
				}
				System.out.println();
				for (int i=0; i<kota.length; i++) {
					System.out.println(kota[i]);
				}
				System.out.println(nama[0]);
				System.out.println(kota[0]);
				
			

	}

}
