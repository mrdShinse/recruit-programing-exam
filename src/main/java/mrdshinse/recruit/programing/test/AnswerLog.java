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
    private final String name;
    @NonNull
    private final Answer answer;

}
