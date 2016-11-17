package mrdshinse.recruit.programing.test;

import lombok.Getter;

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

    public IndianPorkerConfig(Integer numOfCards) {
        if (numOfCards == null) {
            throw new IllegalArgumentException(String.format("numOfCards:%d", numOfCards));
        }
        this.NUM_OF_CARDS = numOfCards;
    }

}
