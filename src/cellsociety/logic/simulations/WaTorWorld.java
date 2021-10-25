package cellsociety.logic.simulations;

import cellsociety.errors.MissingSimulationArgumentError;

import cellsociety.logic.grid.Grid;

import java.util.Collections;
import java.util.Map;
import java.util.Random;

public class WaTorWorld extends Simulation {

    private Random rand;

    public WaTorWorld(Integer[][] grid, Map<String, String> metadata) throws MissingSimulationArgumentError {
        super(grid, metadata);
        rand = new Random();
    }

    /**
     * the update function to be run every tick of the game
     * checks each cell for its neighbors and changes the cell appropriately
     */
    @Override
    public void update() {
        for (int x = 0; x < getGrid().getWidth(); x++) {
            for (int y = 0; y < getGrid().getHeight(); y++) {
                if (getGrid().getCell(x,y).getState() == 1) { //if the cell is a fish

                }
            }
        }
    }
}
