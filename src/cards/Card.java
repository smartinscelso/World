package cards;

// Generic card. All common things for cards live here
public abstract class Card {
	
	// Common attributes for all cards
	protected int number;
	protected String name;
	protected int cvv;
	
	// Common methods for all cards
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	// Standar toString method for all cards
	@Override
	public String toString() {
		return "Number: " + getNumber() + ", Name: " + getName();
	}

}
