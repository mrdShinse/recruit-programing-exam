package mrdshinse.recruit.programing.test;

import lombok.NonNull;

/**
 *
 * @author mrdShinse
 */
public class IndianPorkerManager {

    private final IndianPorker PORKER;

    public IndianPorkerManager(@NonNull String[] args) {
        PORKER = new IndianPorker(args);
    }

    public void startGame() {
        PORKER.play();
    }
}
