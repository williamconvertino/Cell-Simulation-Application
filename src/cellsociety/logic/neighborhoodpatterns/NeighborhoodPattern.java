package cellsociety.logic.neighborhoodpatterns;

import cellsociety.logic.cells.Cell;
import cellsociety.logic.grids.Grid;
import java.util.List;

public abstract class NeighborhoodPattern {

  public abstract List<Cell> getNeighborhoodGroup(Grid myGrid);

}
