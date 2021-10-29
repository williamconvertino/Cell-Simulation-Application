package cellsociety.logic.grid;

import cellsociety.logic.cells.Cell;
import cellsociety.logic.neighborhoodpatterns.NeighborhoodPattern;
import cellsociety.logic.shapes.ShapeManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Grid {

  //A map of the cells in the grid.
  private Map<Coordinate, Cell> myCells;

  //The shape manager of the grid - determines how the cell's interact.
  private ShapeManager myShapeManager;

  /**
   * Constructs a new grid with a specified array of states
   *
   * @param states
   * @param shapeManager
   */
  public Grid (int[][] states, ShapeManager shapeManager) {
    this.myShapeManager = shapeManager;
    initializeGrid(states);
  }

  //Initializes the grid using a 2D array of states.
  private void initializeGrid(int[][] states) {
    this.myCells = new HashMap<>();
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

  /**
   * Given a cell and a neighborhood pattern, returns a list of the neighboring cells.
   *
   * @param cell the cell whose neighbors we find.
   * @param myPattern the neighborhood pattern that dictates what is considered a neighbord.
   * @return a list of the neighboring cells.
   */
  public abstract List<Cell> getNeighbors(Cell cell, NeighborhoodPattern myPattern);

  /**
   *  Moves a cell to the specified location.
   *
   * @param sourceCell the cell to move.
   * @param r the row to move the cell.
   * @param c the column to move the cell.
   */
  public void moveCellTo(Cell sourceCell, int r, int c){
    moveCellTo(sourceCell, getCell(r,c));
  }

  /**
   *  Moves a cell's states to another cell.
   *
   * @param sourceCell the cell to move.
   * @param targetCell the destination where the cell should move.
   */
  public void moveCellTo(Cell sourceCell, Cell targetCell){
    targetCell.setNextState(sourceCell.getCurrentState());
    targetCell.setNextAltState(sourceCell.getCurrentAltState());
    sourceCell.setNextState(0);
    sourceCell.setNextAltState(0);
  }

}

