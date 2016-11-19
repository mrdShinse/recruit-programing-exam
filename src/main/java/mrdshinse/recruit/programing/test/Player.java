package mrdshinse.recruit.programing.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import lombok.Getter;

/**
 *
 * @author mrdShinse
 */
public class Player {

    @Getter
    private final String name;
    @Getter
    private final Card card;
    @Getter
    private final List<Card> cardsOnField;

    private static final Comparator<Card> cardComparator = (Card c1, Card c2) -> {
        return c1.hashCode() - c2.hashCode();
    };

    public Player(String name, Card card) {
        if (name == null || card == null) {
            throw new IllegalArgumentException(String.format(
                    "name:%s card:%s",
                    name,
                    card));
        }
        this.name = name;
        this.card = card;
        this.cardsOnField = new ArrayList<>();
    }

    public Answer guess(IndianPorkerConfig config, List<AnswerLog> log) {
        Integer numOfCards = config.getNUM_OF_CARDS();
        Collections.sort(cardsOnField, cardComparator);
        Card minNumInField = cardsOnField.get(0);
        Card maxNumInField = cardsOnField.get(cardsOnField.size() - 1);
        List<Card> numsExpected = new ArrayList<>();
        for (int num = 1; num < config.getNUM_OF_CARDS() - 1; num++) {
            numsExpected.add(new Card(num));
        }
        numsExpected.removeAll(cardsOnField);
        Collections.sort(numsExpected, cardComparator);
        Card minNumExpected = numsExpected.get(0);
        Card maxNumExpected = numsExpected.get(numsExpected.size() - 1);

        if (minNumExpected.getNumber() != 1 && !Objects.equals(maxNumExpected.getNumber(), numOfCards)) {
            return Answer.MID;
        }

        if (maxNumExpected.getNumber() < minNumInField.getNumber()) {
            return Answer.MIN;
        }
        if (minNumExpected.getNumber() > maxNumInField.getNumber()) {
            return Answer.MAX;
        }

        return Answer.CANT_ANSWER;
    }
}
