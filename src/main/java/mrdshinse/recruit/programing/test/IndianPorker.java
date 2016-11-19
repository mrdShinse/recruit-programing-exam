package mrdshinse.recruit.programing.test;

import java.util.List;

/**
 *
 * @author mrdShinse
 */
public class IndianPorker {

    private final IndianPorkerConfig config;
    private final List<Player> players;
    private final History history;

    public IndianPorker(String[] args) {
        this.config = new IndianPorkerConfig();
        this.players = PlayerFactory.createPlayers(args);
        this.history = new History();
    }

    public void play() {
        boolean isEnd = true;
        int turn = players.size();
        while (isEnd) {
            if (turn != players.size()) {
                System.out.print(",");
            }
            Player player = players.get(turn++ % players.size());
            Answer answer = player.guess(config, history);
            history.add(new AnswerLog(player.getName(), answer));

            //全員？で無限ループを防ぐために暫定対応で100ターン経ったら終了とする。
            if (!Answer.CANT_ANSWER.equals(answer) || turn > 100) {
                isEnd = false;
            }
        }
    }

}
