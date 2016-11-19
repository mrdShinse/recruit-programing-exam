package mrdshinse.recruit.programing.test;

import lombok.NonNull;
import lombok.Value;

/**
 *
 * @author mrdShinse
 */
@Value
public class AnswerLog {

    @NonNull
    private final Player player;
    @NonNull
    private final Answer answer;

}
