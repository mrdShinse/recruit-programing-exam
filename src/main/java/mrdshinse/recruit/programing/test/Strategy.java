package mrdshinse.recruit.programing.test;

import java.util.List;

/**
 *
 * @author mrdShinse
 */
public interface Strategy {

    Answer guess(List<Card> cardsOnField, IndianPorkerConfig config, History log);
}
