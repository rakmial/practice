import java.util.concurrent.ThreadLocalRandom;

class DeckOfCards {
    
    // 13 cards per suit, used to choose card from ordered list to load into deck
    private Card[] deck = Card[52];    
    // Useful for later reference if used for a card game, may refer to sequential 
    // indices for "straights", equal indices for "pairs" etc., and suit array indices for "flushes"
    private Array[] playingCardDeck = {{"2H","3H","4H","5H","6H","7H","8H","9H","10H","JH","QH","KH","AH"},
                                        {"2C","3C","4C","5C","6C","7C","8C","9C","10C","JC","QC","KC","AC"},
                                        {"2S","3S","4S","5S","6S","7S","8S","9S","10S","JS","QS","KS","AS"},
                                        {"2D","3D","4D","5D","6D","7D","8D","9D","10D","JD","QD","KD","AD"}};

    // Ultimately, Cards will be objects with a "value" 2-Ace and "suit"
	public Card[] getDeck() {
		return deck;
	}

    public void setDeck(Card[] deck) {
        this.deck = deck;
    }
    
    // implement "shuffling" later

}

class DeckOfCardsTest {

    public static void main(String[] args) {
    
        
    }
}