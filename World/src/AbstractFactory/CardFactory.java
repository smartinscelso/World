package abstractfactory;

import cards.Card;

public class CardFactory {

	public static Card getCard(AbstractFactory factory) {
		return factory.createCard();
	}
	
}
