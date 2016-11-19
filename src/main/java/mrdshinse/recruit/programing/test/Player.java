package mrdshinse.recruit.programing.test;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;

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

    public Player(@NonNull String name, @NonNull Card card) {
        this.name = name;
        this.card = card;
        this.cardsOnField = new ArrayList<>();
        this.strategy = new DefaultStrategy();
    }

    public Answer guess(@NonNull IndianPorkerConfig config, @NonNull History log) {
        return strategy.guess(this.cardsOnField, config, log);
    }
}
