package cellsociety.logic.simulations;

import cellsociety.errors.MissingSimulationArgumentError;

import cellsociety.logic.grid.Cell;
import cellsociety.logic.grid.Grid;

import java.util.Collections;
import java.util.Map;
import java.util.Random;

public class WaTorWorld extends Simulation {

    private Random rand;

    public WaTorWorld(int[][] grid, Map<String, String> metadata) throws MissingSimulationArgumentError {
        super(grid, metadata);
        rand = new Random();
    }

    @Override
    protected void updateNextGridFromCell(Cell cell) {

    }


}
