package AbstractFactory;

import cardfactory.CardFactory;
import cards.Card;
import cards.Maestro;
import cards.Visa;

public class VisaFactory extends AbstractFactory {

    private String name;
    private int number;
    private int cvv;

    public VisaFactory(int number, String Name, int cvv) {
        this.name = name;
        this.number = number;
        this.cvv = cvv;
    }

    @Override
    public Card createCard() {
        return new Visa(number, name, cvv);
    }
}
