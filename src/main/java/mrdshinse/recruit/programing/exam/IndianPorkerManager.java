package mrdshinse.recruit.programing.exam;

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
