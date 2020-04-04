package AbstractFactory;

import cards.Card;

public class CardAbstractFactory {
    public static Card getCard(AbstractFactory factory){
        return factory.createCard();
    }
}
