package cellsociety.logic.grid_LEGACY;

/**
 * @author Quentin MacFarlane
 *
 * @since 0.0.2
 */
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
