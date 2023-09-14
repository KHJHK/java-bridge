package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge){
        this.bridge = bridge;
    }

    public List<String> getBridge(){
        return bridge;
    }

    public boolean isSameUserInputAndBridge(String move, int round){
        if(move.equals(bridge.get(round - 1))){
            return true;
        }
        return false;
    }

}
