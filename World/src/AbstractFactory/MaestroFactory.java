package AbstractFactory;

import cards.Card;
import cards.Maestro;
import cards.Visa;

public class MaestroFactory extends AbstractFactory {
    private String name;
    private int number;
    private int cvv;

    public MaestroFactory(int number, String Name, int cvv) {
        this.name = name;
        this.number = number;
        this.cvv = cvv;
    }

    @Override
    public Card createCard() {
        return new Maestro(number, name, cvv);
    }
}

