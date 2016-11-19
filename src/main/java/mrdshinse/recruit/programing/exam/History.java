package mrdshinse.recruit.programing.exam;

import java.util.ArrayList;
import lombok.NonNull;

/**
 *
 * @author mrdShinse
 */
public class History extends ArrayList<AnswerLog> {

    @Override
    public boolean add(@NonNull AnswerLog logUnit) {
        if (this.size() > 1) {
            System.out.print(",");
        }
        System.out.print(String.format(
                "%s =>%s",
                logUnit.getPlayer().getName(),
                logUnit.getAnswer().getName()));
        return super.add(logUnit);
    }
}
