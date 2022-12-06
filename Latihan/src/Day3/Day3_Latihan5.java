package Day3;

public class Day3_Latihan5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Kepegawaian pegawai1 = new Kepegawaian();
		Kepegawaian pegawai2 = new Kepegawaian();
		
		pegawai1.nama = "Fitra Chairil Akbar";
		pegawai1.nip = "111111";
		pegawai1.alamat = "Bumi";
		
		pegawai2.nama = "Sena Amarta";
		pegawai2.nip = "123456";
		pegawai2.alamat = "Cianjur";
		
		System.out.println("Nama Pegawai 1  : " + pegawai1.nama );
		System.out.println("Nip Pegawai 1  : " + pegawai1.nip);
		System.out.println("Alamat Pegawai 1  : " + pegawai1.alamat);
		System.out.print("Status Kepegawaian : " );
//		pegawai1.status();
		
		System.out.println();
		System.out.println();
		System.out.println("Nama Pegawai 2  : " + pegawai2.nama );
		System.out.println("Nip Pegawai 2  : " + pegawai2.nip);
		System.out.println("Alamat Pegawai 2  : " + pegawai2.alamat);
		System.out.print("Status Kepegawaian : " );
//		pegawai2.status();
	}

}


