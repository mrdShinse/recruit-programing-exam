package mrdshinse.recruit.programing.test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrdShinse
 */
public class PlayerFactory {

    public static Player create(String arg) {
        if (arg == null) {
            throw new IllegalArgumentException(String.format("arg:%s", arg));
        }

        String[] playerInfo = arg.split("=");
        return new Player(
                playerInfo[0],
                new Card(Integer.parseInt(playerInfo[1])));
    }

    public static List<Player> createPlayers(String[] args) {
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
