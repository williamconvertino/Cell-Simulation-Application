package cellsociety.logic.simulations_LEGACY;

import cellsociety.errors.MissingSimulationArgumentError;
import cellsociety.logic.grid.Cell;
import cellsociety.logic.grid.Grid;
import cellsociety.logic.neighborhoodpatterns.NeighborhoodPattern;

import java.util.Map;

/**
 * The base simulation class for the individual simulation types. Contains a grid_LEGACY and functionality to
 * update the grid_LEGACY based on the subclass' algorithms.
 *
 * @author Alexis Cruz
 * @author William Convertino
 *
 * @since 0.0.1
 */
public abstract class Simulation {



    private NeighborhoodPattern neighborhoodPattern;
    //The current grid_LEGACY state of the simulation.
    private Grid currentGrid;
    private int defaultValue;
    //The grid_LEGACY to be set next in the simulation.
    private Grid nextGrid;

    //A map containing the simulation's data collected from the simulation's sim files.
    private Map<String, String> metadata;

    /**
     * Constructs a new Simulation with a specified starting Grid and a Map of
     * simulation-specific data values.
     *
     * @param grid the starting grid_LEGACY of the simulation.
     * @param metadata the user-specified values used by the simulation.
     * @throws MissingSimulationArgumentError if the metadata is missing a required argument for the simulation.
     */
    public Simulation(Grid grid, NeighborhoodPattern np, Map<String, String> metadata) throws MissingSimulationArgumentError {
        makeGrid(grid);
        this.neighborhoodPattern = np;
        this.metadata = metadata;
    }

    /**
     * Initializes the grid values using a 2d integer array.
     *
     * @param newGrid the array of values to initialize with.
     */
    protected void makeGrid(Grid newGrid) {
        this.currentGrid = newGrid;
    }

    /**
     * Returns the current grid_LEGACY state of the simulation.
     *
     * @return the current grid_LEGACY state of the simulation.
     */
    public Grid getGrid() {
        return currentGrid;
    }

//    /**
//     * Returns a 2D array of integers representing the
//     * current states of the cells.
//     *
//     * @return
//     */
//    public int[][] getStateArray() {
//        return currentGrid.getCellStates();
//    }

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
     *  Updates each cell in the grid_LEGACY using the updateCell method.
     */
    public void update() {
//        this.nextGrid = new Grid(currentGrid.getHeight(), currentGrid.getWidth());
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


    public Grid getCurrentGrid() {
        return currentGrid;
    }

    public void setCurrentGrid(Grid currentGrid) {
        this.currentGrid = currentGrid;
    }

    public Grid getNextGrid() {
        return nextGrid;
    }

    public void setNextGrid(Grid nextGrid) {
        this.nextGrid = nextGrid;
    }

    public NeighborhoodPattern getNeighborhoodPattern() {
        return neighborhoodPattern;
    }

    public void setNeighborhoodPattern(NeighborhoodPattern neighborhoodPattern) {
        this.neighborhoodPattern = neighborhoodPattern;
    }


}
