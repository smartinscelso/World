package AbstractFactory;

import cards.Amex;
import cards.Card;
import cards.Maestro;

public class AmexFactory extends AbstractFactory {
    private String name;
    private int number;
    private int cvv;

    public AmexFactory(int number, String Name, int cvv) {
        this.name = name;
        this.number = number;
        this.cvv = cvv;
    }

    @Override
    public Card createCard() {
        return new Amex(number, name, cvv);
    }
}
