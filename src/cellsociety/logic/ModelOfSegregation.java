package cellsociety.logic;

import cellsociety.errors.MissingSimulationArgumentError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ModelOfSegregation extends Simulation{

  private List<int[]> empty;
  private double satisfactionRate;
  /**
   * Constructs a new Simulation with a specified starting Grid and a Map of simulation-specific data
   * values.
   *
   * @param grid     the starting grid of the simulation.
   * @param metadata the user-specified values used by the simulation.
   * @throws MissingSimulationArgumentError if the metadata is missing a required argument for the
   *                                        simulation.
   */
  public ModelOfSegregation(Grid grid, Map<String, String> metadata)
      throws MissingSimulationArgumentError {
    super(grid, metadata);
    satisfactionRate = Double.parseDouble(metadata.get("SatisfactionRate"));
    empty = findEmptyCells(grid);
  }

  private List findEmptyCells(Grid grid){
    List<int[]> empty = new ArrayList<>();
    for (int i = 0; i < grid.getWidth(); i++) {
      for (int j = 0; j < grid.getHeight(); j++) {
        if(grid.getCell(i, j) == 0){
          int[] entry = new int[2];
          entry[0] = i;
          entry[1] = j;
          empty.add(entry);
        }
      }
    }
    return empty;
  }

  private void relocateToEmptyCell(int x, int y){
    for (int i = 0; i < getGrid().getWidth(); i++) {
      for (int j = 0; j < getGrid().getHeight(); j++) {
        if(getGrid().getCell(i, j) == 0){
          getGrid().setCell(x, y, getGrid().getCell(x, y));
        }
      }
    }
    getGrid().setCell(x, y, 0);
  }

  @Override
  public void update() {
    for (int x = 0; x < getGrid().getWidth(); x++) {
      for (int y = 0; y < getGrid().getHeight(); y++) {
        if (Collections.frequency(getGrid().getAllNeighbors(x, y), 2)/8 < satisfactionRate) {
          relocateToEmptyCell(x, y);
        } else {
          getGrid().setCell(x, y, getGrid().getCell(x, y));
        }
      }
    }
    getGrid().updateGrid();
  }
}
