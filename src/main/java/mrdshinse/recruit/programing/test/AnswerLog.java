package mrdshinse.recruit.programing.test;

import lombok.Getter;

/**
 *
 * @author mrdShinse
 */
public class AnswerLog {

    @Getter
    private final String name;
    @Getter
    private final Answer answer;

    public AnswerLog(String name, Answer answer) {
        if (name == null || answer == null) {
            throw new IllegalArgumentException(String.format("name:%s answer:%s", name, answer));
        }
        this.name = name;
        this.answer = answer;
    }

}
