package cellsociety.logic.grids;

import cellsociety.logic.cells.Cell;
import java.util.Map;

public class Grid {

  //A map of the cells in the grid.
  private Map<Coordinate, Cell> myCells;

  /**
   * Returns the value at the specified coordinates, or null if
   * there is no cell at the coordinates.
   *
   * @param r the row coordinate of the cell to get.
   * @param c the column coordinate of the cell to get.
   * @return the cell at coordinates (r,c), or null if it does not exist.
   */
  public Cell getCell(int r, int c) {
    Coordinate cellCoords = new Coordinate(r,c);
    return myCells.getOrDefault(cellCoords, null);
  }



  //A class to keep track of the coordinate pairs for our map.
  private class Coordinate {

    //The row and column positions of our coordinate.
    private final int r;
    private final int c;

    //Constructs a new coordinate at the specified row and column.
    public Coordinate(int r, int c) {
      this.r=r;
      this.c=c;
    }

    //Overrides the equals method to state that 2 coordinates are equal if they share the same values.
    @Override
    public boolean equals(Object o) {
      if (!(o instanceof Coordinate)) return false;
      Coordinate oCoordinate = (Coordinate) o;
      return this == o || (this.r == oCoordinate.r && this.c == oCoordinate.c);
    }

    //Overrides the hashCode method to create a new hashcode based on the coordinates.
    //This will help distribute our coordinates in the map.
    @Override
    public int hashCode() {
      return (r * 31) + c;
    }
  }
}

