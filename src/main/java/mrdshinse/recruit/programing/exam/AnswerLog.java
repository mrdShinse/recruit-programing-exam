package mrdshinse.recruit.programing.exam;

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
