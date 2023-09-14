package bridge.service;

import bridge.domain.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class BridgeGameTest {
    @DisplayName("사용자가 게임을 진행중인 경우")
    @Test
    void test_Player_playing(){
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String input = "U";

        //when
        int result = bridgeGame.move(input);

        //then
        assertEquals(0, result);
    }

    @DisplayName("사용자가 게임에서 승리한 경우")
    @Test
    void test_Player_win(){
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String[] inputs = {"U", "D", "D", "U"};

        //when
        int round = 1;
        for (String input:inputs) {
            if(bridgeGame.move(input) == 0){
                round++;
            }
        }
        int result = bridgeGame.move("D");

        //then
        assertEquals(bridge.getBridge().size(), round);
        assertEquals(1, result);
    }

    @DisplayName("사용자가 게임에서 패배한 경우")
    @Test
    void test_Player_lose() {
        //given
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String[] inputs = {"U", "D", "D", "D", "D"};

        //when
        int round = 0;
        for (String input:inputs) {
            if(bridgeGame.move(input) == 0){
                round++;
            }
        }

        //then
        assertNotEquals(bridge.getBridge().size(), round);
    }

    @DisplayName("사용자 게임을 재시작한 경우")
    @Test
    void test_Player_retry() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String[] inputs = {"U", "D", "D", "U"};
        for (String input:inputs) {
            bridgeGame.move(input);
        }

        bridgeGame.retry();
        assertEquals(0, bridgeGame.getPlayer().getRound());
    }

}