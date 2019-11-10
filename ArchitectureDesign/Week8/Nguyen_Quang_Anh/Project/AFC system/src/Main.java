import hust.soict.se.customexception.InvalidIDException;
import hust.soict.se.scanner.CardScanner;

public class Main {
    public static void main(String[] args) {
        String pseudoBarCode = "ABCDEFGH";
        CardScanner cardScanner = CardScanner.getInstance();
        try {
            String cardId = cardScanner.process(pseudoBarCode);
            System.out.println(cardId);
        } catch (InvalidIDException e) {
            e.printStackTrace();
        }

    }
}
