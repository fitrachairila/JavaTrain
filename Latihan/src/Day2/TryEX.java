package Day2;

public class TryEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start");
		int Hasil=0;
		
		try {
			Hasil = 100/0;
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println(Hasil);
		System.out.println("End");
	}

}
