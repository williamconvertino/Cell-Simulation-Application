package cellsociety.logic.simulations;

import cellsociety.errors.MissingSimulationArgumentError;

import cellsociety.logic.grid.Cell;
import cellsociety.logic.grid.Grid;
import cellsociety.logic.neighborhoodpatterns.NeighborhoodPattern;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * This class implements the FireSpreading simulation. For each cell of state 1, it will
 * "catch on fire" (change to state 2) with a probability set by the user for each fire
 * adjacent to it. Each fire will burn out (to state 0) after the cycle is completed.
 *
 * @author William Convertino
 * @since 0.0.2
 */
public class FireSpreading extends Simulation {

    //The probability of a fire catching.
    private double probCatch;

    //Our random instance.
    private Random rand;

    /**
     * Constructs a new Simulation with a specified starting Grid and a Map of simulation-specific data
     * values.
     *
     * @param grid     the starting grid_LEGACY of the simulation.
     * @param metadata the user-specified values used by the simulation.
     * @throws MissingSimulationArgumentError if the metadata is missing a required argument for the
     *                                        simulation.
     */
    public FireSpreading(Grid grid, NeighborhoodPattern np, Map<String, String> metadata)
            throws MissingSimulationArgumentError {
        super(grid, np, metadata);
        this.probCatch = Double.parseDouble(metadata.get("ProbCatch"));
        rand = new Random();
        setDefaultValue(2);
    }

    /**
     * @see Simulation#updateNextGridFromCell(Cell)
     */
    @Override
    protected void updateNextGridFromCell(Cell cell) {
        if (rand.nextDouble() < probCatch * getNumAdjacentFires(cell) && cell.getCurrentState() == 1) {
            getNextGrid().changeCell(cell, 2);
        } else if (cell.getCurrentState() == 2) {
            getNextGrid().changeCell(cell, 0);
        } else {
            getNextGrid().changeCell(cell, cell.getCurrentState());
        }
    }

    //Returns the number of adjacent fires to a cell.
    private int getNumAdjacentFires(Cell cell) {
        List<Cell> neighbors = getCurrentGrid().getNeighbors(cell, getNeighborhoodPattern());
        neighbors.removeIf(e->e.getCurrentState() == 0 || e.getCurrentState() == 1);
        return neighbors.size();
    }

}
