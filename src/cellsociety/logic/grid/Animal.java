package cellsociety.logic.grid;

import java.util.Random;

public class Animal {

    // amount of ticks that the animal has survived for
    protected int timeSurvived;

    /**
     * Constructs an animal with the default parameters
     */
    public Animal() {
        timeSurvived = 0;
    }

    public int getTimeSurvived() {
        return timeSurvived;
    }

    public void setTimeSurvived(int time) {
        timeSurvived = time;
    }
}
