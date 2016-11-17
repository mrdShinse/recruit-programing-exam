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

    //TODO delete this method.
    public static void main(String[] args) {
        new IndianPorkerManager(new String[]{"A=1", "B=4", "C=5"}).startGame();
    }
}
