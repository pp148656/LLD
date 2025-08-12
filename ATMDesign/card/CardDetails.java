package ATMDesign.card;

public class CardDetails {
    private final String cardNumber;
    private final CardType cardType;
    private final String pin;
    private int balance;
    public CardDetails(String cardNumber, CardType cardType, String pin) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.pin = pin;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public CardType getCardType() {
        return cardType;
    }

}
