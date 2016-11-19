package mrdshinse.recruit.programing.test;

import lombok.Getter;
import lombok.NonNull;

/**
 *
 * @author mrdShinse
 */
public class IndianPorkerConfig {

    private final Integer DEFAULT_NUM_OF_CARDS = 5;
    @Getter
    private final Integer NUM_OF_CARDS;

    public IndianPorkerConfig() {
        this.NUM_OF_CARDS = this.DEFAULT_NUM_OF_CARDS;
    }

    public IndianPorkerConfig(@NonNull Integer numOfCards) {
        this.NUM_OF_CARDS = numOfCards;
    }

}
