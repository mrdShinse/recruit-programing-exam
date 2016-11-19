package mrdshinse.recruit.programing.test;

import lombok.NonNull;

/**
 *
 * @author mrdShinse
 */
public class CardFactory {

    public static Card create(@NonNull Integer num) {
        return new Card(num);
    }

}
