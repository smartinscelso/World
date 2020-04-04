package AbstractFactory;

import cards.Card;
import cards.Maestro;
import cards.Mastercard;

public class MastercardFactory extends AbstractFactory {

    private String name;
    private int number;
    private int cvv;

    public MastercardFactory(int number, String Name, int cvv) {
        this.name = name;
        this.number = number;
        this.cvv = cvv;

    }

    @Override
    public Card createCard() {
        return new Mastercard(number, name, cvv);
    }
}
