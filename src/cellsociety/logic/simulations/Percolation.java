package cellsociety.logic.simulations;

import cellsociety.errors.MissingSimulationArgumentError;
import cellsociety.logic.grid.Cell;
import cellsociety.logic.grid.Grid;
import cellsociety.logic.neighborhoodpatterns.NeighborhoodPattern;


import java.util.List;
import java.util.Map;

/**
 * @author Alexis Cruz-Ayala
 *
 * @since 0.0.2
 */
public class Percolation extends Simulation {

  /**
   * Constructs a new Simulation with a specified starting Grid and a Map of simulation-specific data
   * values.
   *
   * @param grid     the starting grid_LEGACY of the simulation.
   * @param metadata the user-specified values used by the simulation.
   * @throws MissingSimulationArgumentError if the metadata is missing a required argument for the
   *                                        simulation.
   */
  public Percolation(Grid grid, NeighborhoodPattern np, Map<String, String> metadata)
          throws MissingSimulationArgumentError {
    super(grid, np, metadata);
//    setDefaultValue(0);
  }

  @Override
  protected void updateNextGridFromCell(Cell cell) {

    List<Cell> neighbors = getGrid().getNeighbors(cell, getNeighborhoodPattern());

    if ((neighbors.get(0).getCurrentState() == 1 || cell.getCurrentState() == 0 ) && cell.getCurrentState() == 0) {
      getGrid().changeCell(cell, 1);
    }  else{
      getGrid().changeCell(cell, cell.getCurrentState());
    }

  }

}
