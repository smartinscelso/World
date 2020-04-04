package cards;

// Visa card. Visa is a card because extends the class card
public class Visa extends Card {
	
	// Defining a constructor
	public Visa(int number, String name, int cvv) {
		this.number = number;
		this.name = name;
		this.cvv = cvv;
		
	}
	
	// Specific implementation for Visa
	@Override
	public String toString() {
		return "Type: VISA, Number: " + getNumber() + ", Name: " + getName();
		
	}

}
