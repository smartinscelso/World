package abstractfactory;

import cards.Card;
import cards.Visa;

public class FactoryVisa extends AbstractFactory{

	private int number;
	private String name;
	private int cvv;
	
	public FactoryVisa(int number, String name, int cvv) {
		this.number = number;
		this.name = name;
		this.cvv = cvv;
	}
	
	@Override
	public Card createCard() {
		return new Visa(number, name, cvv);
	}

}
