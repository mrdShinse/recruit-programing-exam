package mrdshinse.recruit.programing.exam;

/**
 *
 * @author mrdShinse
 */
public enum Answer {

    MIN("MIN"), MAX("MAX"), MID("MID"), CANT_ANSWER("?");

    private String name;

    Answer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
