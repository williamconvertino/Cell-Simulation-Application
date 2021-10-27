package cellsociety.logic.simulations;

import cellsociety.errors.MissingSimulationArgumentError;

import cellsociety.logic.grid.Cell;
import cellsociety.logic.grid.Grid;
import cellsociety.logic.grid.WaTorCell;

import java.util.Collections;
import java.util.Map;
import java.util.Random;

public class WaTorWorld extends Simulation {

    private int energy;
    private int reproductionTime;

    public WaTorWorld(int[][] grid, Map<String, String> metadata) throws MissingSimulationArgumentError {
        super(grid, metadata);
        for (int r = 0; r < getGrid().getHeight(); r++) {
            for (int c = 0; c < getGrid().getWidth(); c++) {
                //getGrid().setCell(new WaTorCell());
            }
        }
        energy = Integer.parseInt(metadata.get("Energy"));
        reproductionTime = Integer.parseInt(metadata.get("ReproductionTime"));
    }

    @Override
    protected void updateNextGridFromCell(Cell cell) {

    }


}
