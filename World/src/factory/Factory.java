package factory;
import cards.Amex;
import cards.Card;
import cards.Maestro;
import cards.Mastercard;
import cards.Visa;

public class Factory {

	public static Country getContinent(int cCode, String name, String continent, double surfaceArea, String headOfState) {

		switch (continent)
		{
			case AFRICA:
			case ASIA:
			case SOUTH_AMERICA:
			case NORTH_AMERICA:

		if(type.equals("Mastercard")) {
			return new Mastercard(number, name, cvv);
		}
		else if(type.equals("Visa")) {
			return new Visa(number, name, cvv);
		}
		else if(type.equals("Maestro")) {
			return new Maestro(number, name, cvv);
		}
		else if(type.equals("Amex")) {
			return new Amex(number, name, cvv);
		}
		return null;
		
	}
	
}
