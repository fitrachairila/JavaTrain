package Day2;

public class Method_NoStatic {
	public void cetak(){
		System.out.println("Panggil Dari Method");
			}

	public static void main(String[]args) {
		System.out.println("Mulai");
		//Construct
		Method_NoStatic MS = new Method_NoStatic();
		MS.cetak();
	}
}
