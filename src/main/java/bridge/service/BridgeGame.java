package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Player;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private Player player;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        player = new Player();
    }

    public int move(String move) {
        player.addMove(move);
        if(bridge.isSameUserInputAndBridge(move, player.getRound())){
            if(isGameEnd()){
                return 1;   //추후 WIN으로 변경
            }else if(!isGameEnd()){
                return 0;   //추후 PLAYING으로 변경
            }
        }
        return 2; //추후 LOSE로 변경


    }

    public void retry() {
        player.initMove();
        player.countTrys();
    }

    public boolean isGameEnd(){
        return player.getMove().size() == bridge.getBridge().size();
    };

    public Player getPlayer() {
        return player;
    }
}
