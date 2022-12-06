package Day3;
//import java.util.Scanner;
public class StringOPEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner kb = new Scanner(System.in);
		//String input = kb.nextLine();
		
		String name = "Fitra Chairil Akbar";
		String email = "fitraca@gmail.com";
		System.out.println(email);

		//Panjang String
		System.out.println(name.length());

		//Replace
		email = email.replace("@gmail", "@yahoo");
		System.out.println(email);
		
		//Substring
		String Alamat = "Jalan Raya Bogor";
		System.out.println(Alamat.substring(0,5));
		System.out.println(Alamat.substring(11,16));
		
		//Split
		String Nama2 = "Fitra Chairil Akbar";
		String[]spname=Nama2.split(" ");
		System.out.println(spname.length);
		System.out.println(spname[2]);
		
		//Split Per Karakter
		String title = "Cannondale";
		String[]atitle=title.split("");
		System.out.println(atitle[0]);
		
	}

}
