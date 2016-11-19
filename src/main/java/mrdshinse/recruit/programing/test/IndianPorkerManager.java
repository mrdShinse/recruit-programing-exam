package mrdshinse.recruit.programing.test;

/**
 *
 * @author mrdShinse
 */
public class IndianPorkerManager {

    private final IndianPorker PORKER;

    public IndianPorkerManager(String[] args) {
        PORKER = new IndianPorker(args);
    }

    public void startGame() {
        PORKER.play();
    }
}
