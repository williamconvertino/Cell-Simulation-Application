package cellsociety.logic.simulations;

import cellsociety.errors.MissingSimulationArgumentError;

import cellsociety.logic.grid.Cell;
import cellsociety.logic.grid.Grid;

import java.util.Collections;
import java.util.Map;
import java.util.Random;

public class WaTorWorld extends Simulation {

    public WaTorWorld(Integer[][] grid, Map<String, String> metadata) throws MissingSimulationArgumentError {
        super(grid, metadata);
    }

    @Override
    protected void updateNextGridFromCell(Cell cell) {

    }


}
