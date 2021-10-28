package cellsociety.logic.grids;

public class Grid {


  Map<Coordinate, Cell>


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
  }
}

