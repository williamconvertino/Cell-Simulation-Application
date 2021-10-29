package cellsociety.logic.neighborhoodpatterns;

import cellsociety.logic.cells.Cell;
import cellsociety.logic.grid.Coordinate;
import cellsociety.logic.grid.Grid;
import cellsociety.logic.shapes.ShapeManager;
import java.util.List;

public abstract class NeighborhoodPattern {

  public abstract List<Coordinate> getNeighborhoodGroup(Coordinate myCenter, ShapeManager myShape);

}
