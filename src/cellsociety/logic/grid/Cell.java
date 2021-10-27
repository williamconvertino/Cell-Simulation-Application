package cellsociety.logic.grid;

/**
 * A class that keeps track of the state and position of one square
 * in the grid.
 *
 * @author William Convertino
 *
 * @since 0.0.2
 */
public class Cell {

  //The state of the cell.
  private int state;

  //The row and column of this cell in the grid.
  private int row,column;

  /**
   * Constructs a cell at the specified position with the
   * specified state.
   *
   * @param row the row where the cell is located.
   * @param column the column where the cell is located.
   * @param state the state of the cell.
   */
  public Cell(int row, int column, int state) {
    this.row = row;
    this.column = column;
    this.state = state;
  }

  /**
   * Returns the state of the cell.
   *
   * @return the state of the cell.
   */
  public int getState() {
    return state;
  }

  /**
   * Sets the state of the cell.
   *
   * @param state the state to which this cell should be set.
   */
  public void setState(int state) {
    this.state = state;
  }

  /**
   * Returns the row where this cell is located.
   *
   * @return the row where this cell is located.
   */
  public int getRow() {
    return row;
  }


  /**
   * Returns the column where this cell is located.
   *
   * @return the column where this cell is located.
   */
  public int getColumn() {
    return column;
  }

}