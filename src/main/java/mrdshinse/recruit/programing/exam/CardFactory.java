package mrdshinse.recruit.programing.exam;

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
