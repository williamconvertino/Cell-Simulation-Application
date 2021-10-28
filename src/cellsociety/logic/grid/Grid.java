package cellsociety.logic.grid;

import cellsociety.logic.bordertypes.BorderType;
import cellsociety.logic.bordertypes.StaticBorder;
import cellsociety.logic.cells.Cell;
import java.util.HashMap;
import java.util.Map;

public class Grid {

  //A map of the cells in the grid.
  private Map<Coordinate, Cell> myCells;

  //The border type of our grid.
  private BorderType myBorderType;


  public Grid (int[][] states,BorderType borderType) {
    this.myBorderType = borderType;
    this.myCells = new HashMap<>();
    initializeGrid(states);
  }

  public Grid(int[][] states) {
    this(states, new StaticBorder());
  }

  private void initializeGrid(int[][] states) {
    for (int r = 0; r < states.length; r++) {
      for (int c = 0; c < states[0].length; c++) {
        addCellIfAbsent(r,c,states[r][c]);
      }
    }
  }

  /**
   * Adds a cell to the grid at the specified location with the specified
   * state, if it does not already exist.
   *
   * @param r the row coordinate of the new cell.
   * @param c the column coordinate of the new cell.
   * @param state the state of the new cell.
   */
  public void addCellIfAbsent(int r, int c, int state) {
    myCells.putIfAbsent(new Coordinate(r,c), new Cell(r,c,state));
  }

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

  public void moveCellTo(Cell cell, int r, int c){
    Cell targetCell = myCells.get(new Coordinate(r,c));
    targetCell.setNextState(cell.getCurrentState());
    cell.setNextState(0);
  }

}

