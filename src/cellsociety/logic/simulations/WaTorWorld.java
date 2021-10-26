package cellsociety.logic.simulations;

import cellsociety.errors.MissingSimulationArgumentError;

import cellsociety.logic.grid.Cell;
import cellsociety.logic.grid.Grid;

import java.util.Collections;
import java.util.Map;
import java.util.Random;

public class WaTorWorld extends Simulation {

    private int energy;

    public WaTorWorld(Integer[][] grid, Map<String, String> metadata) throws MissingSimulationArgumentError {
        super(grid, metadata);
        for (int r = 0; r < getGrid().getHeight(); r++) {
            for (int c = 0; c < getGrid().getWidth(); c++) {
                if (getGrid().getCell(r,c).getState() == 1) { // if the cell's state is a 1 (meaning it's a fish)

                }
            }
        }
        energy = Integer.parseInt(metadata.get("Energy"));
    }

    @Override
    protected void updateNextGridFromCell(Cell cell) {

    }


}
