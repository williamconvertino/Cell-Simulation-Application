package cellsociety.logic.simulations;

import cellsociety.errors.MissingSimulationArgumentError;
import cellsociety.logic.grid.Grid;
import java.util.Map;

/**
 * The base simulation class for the individual simulation types. Contains a grid and functionality to
 * update the grid based on the subclass' algorithms.
 *
 * @author Alexis Cruz
 * @author William Convertino
 */
public abstract class Simulation {

    //The current grid state of the simulation.
    protected Grid grid;

    //A map containing the simulation's data collected from the simulation's sim files.
    private Map<String, String> metadata;

    /**
     * Constructs a new Simulation with a specified starting Grid and a Map of
     * simulation-specific data values.
     *
     * @param grid the starting grid of the simulation.
     * @param metadata the user-specified values used by the simulation.
     * @throws MissingSimulationArgumentError if the metadata is missing a required argument for the simulation.
     */
    public Simulation(Integer[][] grid, Map<String, String> metadata) throws MissingSimulationArgumentError {
        makeGrid(grid);
        this.metadata = metadata;
    }

    /**
     * Initializes the grids values using a 2d integer array.
     *
     * @param myGridArray the array of values to initialize with.
     */
    protected void makeGrid(Integer[][] myGridArray) {
        this.grid = new Grid(myGridArray);
    }

    /**
     * Returns the current grid state of the simulation.
     *
     * @return the current grid state of the simulation.
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Returns the metadata of the simulation.
     *
     * @return the metadata of the simulation.
     */
    public Map<String, String> getMetaData() {
        return metadata;
    }

    /**
     * The update function to be run every tick of the game.
     */
    public abstract void update();

}
