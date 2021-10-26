package cellsociety.logic.simulations;

import cellsociety.errors.MissingSimulationArgumentError;
import cellsociety.logic.grid.Cell;
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
    protected Grid currentGrid;
    private int defaultValue;
    //The grid to be set next in the simulation.
    protected Grid nextGrid;

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
    public Simulation(int[][] grid, Map<String, String> metadata) throws MissingSimulationArgumentError {
        makeGrid(grid);
        this.metadata = metadata;
    }

    /**
     * Initializes the grids values using a 2d integer array.
     *
     * @param myGridArray the array of values to initialize with.
     */
    protected void makeGrid(int[][] myGridArray) {
        this.currentGrid = new Grid(myGridArray);
    }

    /**
     * Returns the current grid state of the simulation.
     *
     * @return the current grid state of the simulation.
     */
    public Grid getGrid() {
        return currentGrid;
    }

    /**
     * Returns a 2D array of integers representing the
     * current states of the cells.
     *
     * @return
     */
    public Integer[][] getStateArray() {
        return currentGrid.getCellStates();
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
     *  Updates the nextGrid based on the current cell passed.
     *
     * @param cell the cell to update with.
     */
    protected abstract void updateNextGridFromCell (Cell cell);

    /**
     *  Updates each cell in the grid using the updateCell method.
     */
    public void update() {
        this.nextGrid = new Grid(currentGrid.getHeight(), currentGrid.getWidth());
        for (int r = 0; r < currentGrid.getHeight(); r++) {
            for (int c = 0; c < currentGrid.getWidth(); c++) {
                updateNextGridFromCell(currentGrid.getCell(r,c));
            }
        }
        this.currentGrid = this.nextGrid;
    }



    public int getDefaultValue(){
        return defaultValue;
    }

    protected void setDefaultValue(int newDefault){
        defaultValue = newDefault;
    }

}
