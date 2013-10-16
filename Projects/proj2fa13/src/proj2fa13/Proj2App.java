package proj2fa13;

public class Proj2App {
	
	public static void main(String[] args) {
		Card test = new Card(12);
		System.out.println(test.toString());
		System.out.println(Card.createJoker().toString());
	}
}
