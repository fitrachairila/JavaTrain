package Day2;

public class SwitchEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String lampu = "Yellow";

		switch (lampu) {
		case "Red":
			System.out.println("Berhenti");
			break;
		case "Yellow":
			System.out.println("Bersedia");
			break;
		case "Green":
			System.out.println("Jalan");
			break;
		default:
			System.out.println("Lampu Rusak");
		}
	}
}
