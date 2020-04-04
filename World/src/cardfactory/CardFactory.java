package cardfactory;

import cards.Card;
import cards.Maestro;
import cards.Mastercard;
import cards.Visa;

public class CardFactory {
+    public static Card getCard(int number, String name, int cvv, String type) {

        if (type.equals("Visa")){
            return new Visa(number, name, cvv);
        }
        else if (type.equals("Mastercard")){
            return new Mastercard(number, name, cvv);
        }
        else if (type.equals("Maestro")){
            return new Maestro(number, name, cvv);
        }
        else if (type.equals("Amex")){
            return new Amex(number, name, cvv);
        else {
            return null;
        }
    }
}
