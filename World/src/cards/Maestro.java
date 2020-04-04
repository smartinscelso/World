package cards;

// Maestro card. Maestro is a card because extends the class card
public class Maestro extends Card {
	
	// Defining a constructor
	public Maestro(int number, String name, int cvv) {
		this.number = number;
		this.name = name;
		this.cvv = cvv;
		
	}
	
	// Specific implementation for Maestro
	@Override
	public String toString() {
		return "Type: MAESTRO, Number: " + getNumber() + ", Name: " + getName();
		
	}

}
