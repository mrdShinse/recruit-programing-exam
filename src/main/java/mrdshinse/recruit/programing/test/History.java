package mrdshinse.recruit.programing.test;

import java.util.ArrayList;

/**
 *
 * @author mrdShinse
 */
public class History extends ArrayList<AnswerLog> {

    @Override
    public boolean add(AnswerLog logUnit) {
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
