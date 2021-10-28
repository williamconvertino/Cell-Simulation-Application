package cellsociety.logic.grid_LEGACY;

/**
 * @author Quentin MacFarlane
 *
 * @since 0.0.2
 */
public class Shark extends Animal {

    private int energy;

    public Shark(int energy) {
        super();
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
