package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<String> move;
    private int trys;

    public Player(){
        this.move = new ArrayList<>();
        this.trys = 0;
    }

    public void initMove(){
        this.move.clear();
    }

    public void countTrys(){
        this.trys++;
    }

    public void addMove(String move){
        this.move.add(move);
    }

    public List<String> getMove(){
        return this.move;
    }

    public int getTrys(){
        return trys;
    }

    public int getRound(){
        return this.move.size();
    };
}
