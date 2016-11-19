package mrdshinse.recruit.programing.exam;

import java.util.ArrayList;
import java.util.List;
import lombok.NonNull;

/**
 *
 * @author mrdShinse
 */
public class PlayerFactory {

    public static Player create(@NonNull String arg) {
        String[] playerInfo = arg.split("=");
        return new Player(
                playerInfo[0],
                CardFactory.create(Integer.parseInt(playerInfo[1])));
    }

    public static List<Player> createPlayers(@NonNull String[] args) {
        List<Player> tmpPlayers = new ArrayList<>();
        //カードを配る
        for (String arg : args) {
            tmpPlayers.add(create(arg));
        }
        //他のプレイヤーのカード情報を渡す
        tmpPlayers.stream().forEach(player -> {
            List<Player> others = new ArrayList<>(tmpPlayers);
            others.remove(player);

            others.stream().forEach(other -> {
                player.getCardsOnField().add(other.getCard());
            });
        });

        return tmpPlayers;
    }

}
