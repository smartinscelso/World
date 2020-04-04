package cards;

// Mastercard card. Mastercard is a card because extends the class card
public class Mastercard extends Card {
	
	// Defining a constructor
	public Mastercard(int number, String name, int cvv) {
		this.number = number;
		this.name = name;
		this.cvv = cvv;
		
	}
	
	// Specific implementation for Mastercard
	@Override
	public String toString() {
		return "Type: MASTERCARD, Number: " + getNumber() + ", Name: " + getName();
		
	}

}
