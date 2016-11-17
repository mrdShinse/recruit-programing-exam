package mrdshinse.recruit.programing.test;

import java.util.ArrayList;
import java.util.Collections;
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
    private final Integer digitsOfCard;
    @Getter
    private final List<Integer> cardsOnField;

    public Player(String name, Integer digitsOfCard) {
        if (name == null || digitsOfCard == null) {
            throw new IllegalArgumentException(String.format(
                    "name:%s digitsOfCard:%n",
                    name,
                    digitsOfCard));
        }
        this.name = name;
        this.digitsOfCard = digitsOfCard;
        this.cardsOnField = new ArrayList<>();
    }

    public Answer guess(IndianPorkerConfig config, List<AnswerLog> log) {
        Integer numOfCards = config.getNUM_OF_CARDS();
        Collections.sort(cardsOnField);
        Integer minNumInField = cardsOnField.get(0);
        Integer maxNumInField = cardsOnField.get(cardsOnField.size() - 1);
        List<Integer> numsExpected = new ArrayList<>();
        for (int num = 1; num < config.getNUM_OF_CARDS() - 1; num++) {
            numsExpected.add(num);
        }
        numsExpected.removeAll(cardsOnField);
        Collections.sort(numsExpected);
        Integer minNumExpected = numsExpected.get(0);
        Integer maxNumExpected = numsExpected.get(numsExpected.size() - 1);

        if (minNumExpected != 1 && !Objects.equals(maxNumExpected, numOfCards)) {
            return Answer.MID;
        }

        if (maxNumExpected < minNumInField) {
            return Answer.MIN;
        }
        if (minNumExpected > maxNumInField) {
            return Answer.MAX;
        }

        return Answer.CANT_ANSWER;
    }
}
