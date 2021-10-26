package cellsociety.logic.grid;

public class Shark extends Animal {

    private int energy;

    public Shark() {
        super();
        energy = 0;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
