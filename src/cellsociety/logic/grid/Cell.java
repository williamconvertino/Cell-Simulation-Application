package cellsociety.logic.grid;

/**
 * a class for representing an individual cell in a Grid class.
 */
public class Cell {

  private int state;
  private int row,collumn;

  public Cell(int row, int collumn, int state) {
    this.row = row;
    this.collumn = collumn;
    this.state = state;
  }

  public int getState() {
    return state;
  }
  public void setState(int state) {
    this.state = state;
  }

  public int getRow() {
    return row;
  }

  public int getCollumn() {
    return collumn;
  }

}
