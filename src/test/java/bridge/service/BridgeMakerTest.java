package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("입력 받은 size 크기의 Bridge가 만들어 졌는지 확인")
    @Test
    void test_makedBridgeLength_isSameAsSize(){
        //Given
        int size = 5;

        //When
        List<String> bridge = bridgeMaker.makeBridge(size);

        //Then
        assertEquals(size, bridge.size());
    }

    @DisplayName("생성된 Bridge에 U와 D만 들어있는지 확인")
    @Test
    void test_makedBridgeCase_isOnlyUpOrDown(){
        //Given
        int size = 10;

        //When
        List<String> bridge = bridgeMaker.makeBridge(size);

        //Then
        assertThat(bridge).containsOnly("U", "D");
    }

}