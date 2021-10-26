package cellsociety.logic.simulations;

import cellsociety.errors.MissingSimulationArgumentError;

import cellsociety.logic.grid.Cell;
import java.util.Map;
import java.util.Random;

public class FireSpreading extends Simulation {

    private double probCatch;
    private Random rand;

    /**
     * Constructs a new Simulation with a specified starting Grid and a Map of simulation-specific data
     * values.
     *
     * @param grid     the starting grid of the simulation.
     * @param metadata the user-specified values used by the simulation.
     * @throws MissingSimulationArgumentError if the metadata is missing a required argument for the
     *                                        simulation.
     */
    public FireSpreading(Integer[][] grid, Map<String, String> metadata)
            throws MissingSimulationArgumentError {
        super(grid, metadata);
        this.probCatch = Double.parseDouble(metadata.get("ProbCatch"));
        rand = new Random();

    }

    /**
     * @see Simulation#updateNextGridFromCell(Cell)
     */
    @Override
    protected void updateNextGridFromCell(Cell cell) {
        if (rand.nextDouble() < probCatch * getNumAdjacentFires(cell) && cell.getState() == 1) {
            nextGrid.setCellState(cell.getRow(), cell.getColumn(), 2);
        } else if (cell.getState() == 2) {
            nextGrid.setCellState(cell.getRow(), cell.getColumn(), 0);
        } else {
            nextGrid.setCellState(cell.getRow(), cell.getColumn(), cell.getState());
        }

    }

    //Returns the number of adjacent fires to a cell.
    private int getNumAdjacentFires(Cell cell) {
        int total = 0;
        if (currentGrid.getNeighborUp(cell) != null && currentGrid.getNeighborUp(cell).getState() == 2) {
            total ++;
        }
        if (currentGrid.getNeighborDown(cell) != null && currentGrid.getNeighborDown(cell).getState() == 2) {
            total ++;
        }
        if (currentGrid.getNeighborLeft(cell) != null && currentGrid.getNeighborLeft(cell).getState() == 2) {
            total ++;
        }
        if (currentGrid.getNeighborRight(cell) != null && currentGrid.getNeighborRight(cell).getState() == 2) {
            total ++;
        }
        return total;
    }

}
