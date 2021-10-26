package cellsociety.logic.grid;

import java.util.Random;

public class Animal {

    // amount of ticks that the animal has survived for
    protected int timeSurvived;

    // probabilities that the animals move to a certain spot in the grid
    protected Random moveLeftProb;
    protected Random moveRightProb;
    protected Random moveUpProb;
    protected Random moveDownProb;

    /**
     * Constructs an animal with the default parameters
     */
    public Animal() {
        timeSurvived = 0;
        moveLeftProb = new Random();
        moveRightProb = new Random();
        moveUpProb = new Random();
        moveDownProb = new Random();
    }

    public int getTimeSurvived() {
        return timeSurvived;
    }

    public void setTimeSurvived(int time) {
        timeSurvived = time;
    }
}
