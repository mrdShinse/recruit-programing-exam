package mrdshinse.recruit.programing.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mrdShinse
 */
public class DefaultStrategy implements Strategy {

    private static final Comparator<Card> cardComparator = (Card c1, Card c2) -> {
        return c1.hashCode() - c2.hashCode();
    };

    @Override
    public Answer guess(List<Card> cardsOnField, IndianPorkerConfig config, List<AnswerLog> log) {
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
