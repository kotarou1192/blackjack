package blackj.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardDeck {
    private final int NUMBER_OF_CARD = 13;
    private final int NUMBER_OF_CARD_TYPE = 4;
    private final String[] NAME_OF_CARD = {"ハート", "クラブ", "スペード", "ダイヤ"};

    private List<List<Integer>> Deck = new ArrayList<List<Integer>>(NUMBER_OF_CARD_TYPE);
    private List<Integer> CardOfHeart = new ArrayList<Integer>(NUMBER_OF_CARD);
    private List<Integer> CardOfSpade = new ArrayList<Integer>(NUMBER_OF_CARD);
    private List<Integer> CardOfDiamond = new ArrayList<Integer>(NUMBER_OF_CARD);
    private List<Integer> CardOfClub = new ArrayList<Integer>(NUMBER_OF_CARD);
    private int CardNumber;
    private int CardTypeNumber;
    private int NumberOfCardDrawn = 0;

    public CardDeck() {
        for (int i = 1; i <= NUMBER_OF_CARD; i++) {
            CardOfHeart.add(i);
            CardOfClub.add(i);
            CardOfSpade.add(i);
            CardOfDiamond.add(i);
        }
        Deck.add(CardOfHeart);
        Deck.add(CardOfClub);
        Deck.add(CardOfSpade);
        Deck.add(CardOfDiamond);
        shuffleDeck();
    }

    private void shuffleDeck() {
        Collections.shuffle(CardOfHeart);
        Collections.shuffle(CardOfClub);
        Collections.shuffle(CardOfSpade);
        Collections.shuffle(CardOfDiamond);
    }

    public int drawCard() {
        CardTypeNumber = new Random().nextInt(Deck.size());
        if (Deck.get(CardTypeNumber).size() == 0) {
            if(NumberOfCardDrawn >= NUMBER_OF_CARD * NUMBER_OF_CARD_TYPE)throw new IndexOutOfBoundsException("引きすぎです");
            return drawCard();
        }
        NumberOfCardDrawn++;
        CardNumber = Deck.get(CardTypeNumber).get(0);
        Deck.get(CardTypeNumber).remove(0);
        return CardNumber;
    }

    public String printCard() {
        if(NumberOfCardDrawn == 0)throw new IndexOutOfBoundsException("1枚は引いてください");
        return NAME_OF_CARD[CardTypeNumber] + "の" + CardNumber;
    }
}
