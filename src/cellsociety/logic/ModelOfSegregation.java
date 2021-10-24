package cellsociety.logic;

import cellsociety.errors.MissingSimulationArgumentError;

import java.util.Collections;
import java.util.Map;

public class ModelOfSegregation extends Simulation{

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
  }

  @Override
  public void update() {
    for (int x = 0; x < getGrid().getWidth(); x++) {
      for (int y = 0; y < getGrid().getHeight(); y++) {
        if (Collections.frequency(getGrid().getFourNeighbors(x, y), 2)/4 < satisfactionRate) {
          getGrid().setCell(x, y, 2);
        } else if(getGrid().getCell(x, y) == 2) {
          getGrid().setCell(x, y, 0);
        }else {
          getGrid().setCell(x, y, getGrid().getCell(x, y));
        }
      }
    }
    getGrid().updateGrid();
  }
}
