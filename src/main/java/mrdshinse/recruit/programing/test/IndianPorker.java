package mrdshinse.recruit.programing.test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrdShinse
 */
public class IndianPorker {

    private final IndianPorkerConfig config;
    private final List<Player> players;
    private final List<AnswerLog> answerLogs;

    public IndianPorker(String[] args) {
        config = new IndianPorkerConfig();
        players = createPlayers(args);
        answerLogs = new ArrayList<>();
    }

    public void play() {
        boolean isEnd = true;
        int turn = players.size();
        while (isEnd) {
            if (turn != players.size()) {
                System.out.print(",");
            }
            Player player = players.get(turn++ % players.size());
            Answer answer = player.guess(config, answerLogs);
            answerLogs.add(new AnswerLog(player.getName(), answer));

            System.out.print(String.format("%s =>%s", player.getName(), answer.getName()));

            //全員？で無限ループを防ぐために暫定対応で100ターン経ったら終了とする。
            if (!Answer.CANT_ANSWER.equals(answer) || turn > 100) {
                isEnd = false;
            }
        }
    }

    private List<Player> createPlayers(String[] args) {
        List<Player> tmpPlayers = new ArrayList<>();
        //カードを配る
        for (String arg : args) {
            tmpPlayers.add(createPlayer(arg));
        }
        //他のプレイヤーのカード情報を渡す
        for (Player player : tmpPlayers) {
            List<Player> others = new ArrayList<>(tmpPlayers);
            others.remove(player);
            for (Player other : others) {
                player.getCardsOnField().add(other.getDigitsOfCard());
            }
        }

        return tmpPlayers;
    }

    private Player createPlayer(String arg) {
        String[] playerInfo = arg.split("=");
        return new Player(
                playerInfo[0],
                Integer.parseInt(playerInfo[1]));
    }

}
