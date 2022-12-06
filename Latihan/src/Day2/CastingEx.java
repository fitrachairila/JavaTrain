package Day2;

public class CastingEx {
	public static void main(String[]args) {
		int n1 = 10;
		long n2 = 1000;
		String Xnilai="100";
		
		System.out.println(n1);
		System.out.println(n2);
		
		n2=n1;
		
		System.out.println(n1);
		System.out.println(n2);
		
		n1=(int)n2;
		
		System.out.println(n1);
		System.out.println(n2);
		
		n1=Integer.parseInt(Xnilai);
		
		System.out.println(n1);
		
					
	}

}
