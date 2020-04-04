package cardfactory;

import AbstractFactory.CardAbstractFactory;
import AbstractFactory.MaestroFactory;
import cards.Card;

public class Main {

    public static void main(String [] arg) {

        Card myVisa = CardFactory.getCard(124456975, "Celso", 780, "Mastercard");
        System.out.println(myVisa);

        Card myMaestro = CardAbstractFactory.getCard(new MaestroFactory(123456789, "Celso M", 588));
        System.out.println(myMaestro);
    }
}
