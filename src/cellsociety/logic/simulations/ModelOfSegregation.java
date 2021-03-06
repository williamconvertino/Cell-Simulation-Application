package cellsociety.logic.simulations;

import cellsociety.errors.MissingSimulationArgumentError;

import cellsociety.logic.grid.Cell;
import cellsociety.logic.grid.Grid;
import cellsociety.logic.neighborhoodpatterns.NeighborhoodPattern;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This class simulates Schelling's Model of Segregation. For each cell, it will attempt to move
 * to an adjacent empty cell if the ratio of similar to different states among its neighbors is less
 * than the satisfaction rate set by the user.
 *
 * @autahor William Convertino
 * @author Tim Jang
 * @author Quentin MacFarlane
 *
 * @since 0.0.2
 */
public class ModelOfSegregation extends Simulation {

    //The ratio at which a cell will not attempt to move.
    private double satisfactionRate;

    /**
     * Constructs a new Simulation with a specified starting Grid and a Map of simulation-specific data
     * values.
     *
     * @param grid     the starting grid_LEGACY of the simulation.
     * @param metadata the user-specified values used by the simulation.
     * @throws MissingSimulationArgumentError if the metadata is missing a required argument for the
     *                                        simulation.
     */
    public ModelOfSegregation(Grid grid, NeighborhoodPattern np, Map<String, String> metadata)
            throws MissingSimulationArgumentError {
        super(grid, np, metadata);
        satisfactionRate = Double.parseDouble(metadata.get("SatisfactionRate"));
        setDefaultValue(2);
    }

    /**
     * @see Simulation#updateNextGridFromCell(Cell)
     */
    @Override
    protected void updateNextGridFromCell(Cell cell) {
        List<Cell> myNeighbors = getGrid().getNeighbors(cell, getNeighborhoodPattern());
        myNeighbors.removeIf(Objects::isNull);
        double similar = 0;
        double different = 0;
        for (Cell c: myNeighbors) {
            if (c.getCurrentState() != 0 && c.getCurrentState() == cell.getCurrentState()) {
                similar++;
            } else if (c.getCurrentState()!=0) {
                different++;
            }
        }
        //Given the neighbor list, remove all non-zero entries in either this or the next iterations, and pick
        //a new location from there.
        myNeighbors.removeIf(e->e.getNextState() != 0 ||  e.getCurrentState()!=0 );
        //myNeighbors.removeIf(e->e.getCurrentState()!=0 );//|| nextGrid.getCellState(e.getRow(), e.getColumn()) != 0);
        //myNeighbors.removeIf(e->getGrid().getCell(e.getCoordinates().r(), e.getCoordinates().c()).getCurrentState()!=0);
        if (different != 0 && (similar/different) < satisfactionRate && myNeighbors.size() > 0) {
            Collections.shuffle(myNeighbors);
            getGrid().changeCell(myNeighbors.get(0), cell.getCurrentState(), cell.getAltStates());
        } else {
            getGrid().changeCell(cell, cell.getCurrentState(), cell.getAltStates());
        }
    }

}
