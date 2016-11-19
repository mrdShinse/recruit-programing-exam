package mrdshinse.recruit.programing.test;

import java.util.ArrayList;
import java.util.List;
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
    private Strategy strategy;

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
        this.strategy = new DefaultStrategy();
    }

    public Answer guess(IndianPorkerConfig config, List<AnswerLog> log) {
        return strategy.guess(this.cardsOnField, config, log);
    }
}
