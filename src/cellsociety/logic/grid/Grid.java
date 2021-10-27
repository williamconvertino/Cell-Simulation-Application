package cellsociety.logic.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * A class that keeps a grid of cells and is able to track their
 * states and positions. Also has the ability to find neighboring cells.
 *
 * @author William Convertino
 * @author Alexis Cruz
 *
 * @since 0.0.1
 */
public class Grid {

    //An array of all the cells in the grid.
    private Cell[][] cells;

    //The height of the grid.
    private int height;

    //The width of the grid.
    private int width;

    Stack<Cell> emptyCells = new Stack<>();

    /**
     * Constructs a grid with the specified height and width, and
     * initializes all the states to 0.
     *
     * @param height the height of the grid (the number of rows).
     * @param width the width of the grid (the number of columns).
     */
    public Grid(int height, int width) {
        initializeCells(height, width, 0);
        getCurrentEmptyCells();
    }

    /**
     * Constructs a grid with the specified height and width, and
     * initializes all the states to the specified value.
     *
     * @param height the height of the grid (the number of rows).
     * @param width the width of the grid (the number of columns).
     * @param initialValue the state to which the cells should be initialized.
     */
    public Grid(int height, int width, int initialValue) {

        initializeCells(height, width, initialValue);
        getCurrentEmptyCells();
    }

    /**
     *
     */
    public Grid(int[][] initialValues) {

        initializeCells(initialValues.length, initialValues[0].length, 0);
        for (int r= 0; r < initialValues.length; r++) {
            for (int c = 0; c < initialValues[0].length; c++) {
                this.cells[r][c] = new Cell(r,c,initialValues[r][c]);
            }
        }
        getCurrentEmptyCells();
    }


    //Creates the cells array and initializes each of them to the specified value.
    private void initializeCells(int height, int width, int value) {
        this.cells = new Cell[height][width];
        this.width = width;
        this.height = height;
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                cells[r][c] = new Cell(r,c,value);
            }
        }
    }

    public void setCell(int r, int c, WaTorCell waTorCell) {
        this.cells[r][c] = waTorCell;
    }

    /**
     * Gets the state of the cell at the specified position.
     *
     * @param r the row of the desired cell
     * @param c the column of the desired cell
     * @return the value held within that cell
     */
    public int getCellState(int r, int c) {
        return cells[r][c].getState();
    }

    /**
     * sets the state of the cell at the specified position.
     *
     * @param r the row of the desired cell
     * @param c the column of the desired cell
     * @param state the state to be set
     */
    public void setCellState(int r, int c, int state) {
        cells[r][c].setState(state);
    }

    /**
     * Finds and returns the neighbor above the specified cell,
     * or null if it does not exist.
     *
     * @param c the cell whose neighbor we find.
     * @return the neighbor above the specified cell, or null if
     * it does not exist.
     */
    public Cell getNeighborUp(Cell c) {
        if (c.getRow() <= 0 || c.getRow() > height - 1) {
            return null;
        }
        return cells[c.getRow()-1][c.getColumn()];
    }

    /**
     * Finds and returns the neighbor below the specified cell,
     * or null if it does not exist.
     *
     * @param c the cell whose neighbor we find.
     * @return the neighbor below the specified cell, or null if
     * it does not exist.
     */
    public Cell getNeighborDown(Cell c) {
        if (c.getRow() < 0 || c.getRow() > height - 2) {
            return null;
        }
        return cells[c.getRow()+1][c.getColumn()];
    }

    /**
     * Finds and returns the neighbor to the left of the specified cell,
     * or null if it does not exist.
     *
     * @param c the cell whose neighbor we find.
     * @return the neighbor to the left of the specified cell, or null if
     * it does not exist.
     */
    public Cell getNeighborLeft(Cell c) {
        if (c.getColumn() <= 0 || c.getColumn() > width - 1) {
            return null;
        }
        return cells[c.getRow()][c.getColumn()-1];
    }

    /**
     * Finds and returns the neighbor to the right of the specified cell,
     * or null if it does not exist.
     *
     * @param c the cell whose neighbor we find.
     * @return the neighbor to the right of the specified cell, or null if
     * it does not exist.
     */
    public Cell getNeighborRight(Cell c) {
        if (c.getColumn() < 0 || c.getColumn() > width - 2) {
            return null;
        }
        return cells[c.getRow()][c.getColumn()+1];
    }

    /**
     * Finds and returns the neighbor up and to the left of the specified cell,
     * or null if it does not exist.
     *
     * @param c the cell whose neighbor we find.
     * @return the neighbor up and to the left of the specified cell, or null if
     * it does not exist.
     */
    public Cell getNeighborUpLeft(Cell c) {
        if (getNeighborLeft(c) == null || getNeighborUp(c) == null) {
            return null;
        }
        return cells[c.getRow()-1][c.getColumn()-1];
    }

    /**
     * Finds and returns the neighbor up and to the right of the specified cell,
     * or null if it does not exist.
     *
     * @param c the cell whose neighbor we find.
     * @return the neighbor up and to the right of the specified cell, or null if
     * it does not exist.
     */
    public Cell getNeighborUpRight(Cell c) {
        if (getNeighborRight(c) == null || getNeighborUp(c) == null) {
            return null;
        }
        return cells[c.getRow()-1][c.getColumn()+1];
    }

    /**
     * Finds and returns the neighbor down and to the left of the specified cell,
     * or null if it does not exist.
     *
     * @param c the cell whose neighbor we find.
     * @return the neighbor down and to the left of the specified cell, or null if
     * it does not exist.
     */
    public Cell getNeighborDownLeft(Cell c) {
        if (getNeighborLeft(c) == null || getNeighborDown(c) == null) {
            return null;
        }
        return cells[c.getRow()+1][c.getColumn()-1];
    }

    /**
     * Finds and returns the neighbor down and to the right of the specified cell,
     * or null if it does not exist.
     *
     * @param c the cell whose neighbor we find.
     * @return the neighbor down and to the right of the specified cell, or null if
     * it does not exist.
     */
    public Cell getNeighborDownRight(Cell c) {
        if (getNeighborRight(c) == null || getNeighborDown(c) == null) {
            return null;
        }
        return cells[c.getRow()+1][c.getColumn()+1];
    }

    /**
     * Returns a list of the 4 directly adjacent cells, with
     * any null neighbors removed.
     *
     * @param c the cell whose neighbors this method returns.
     * @return a list of the 4 directly adjacent cells, with
     * any null neighbors removed.
     */
    public List<Cell> getNeighbors_Four(Cell c) {
        List<Cell> myNeighbors = new ArrayList<>();
        myNeighbors.add(getNeighborUp(c));
        myNeighbors.add(getNeighborDown(c));
        myNeighbors.add(getNeighborLeft(c));
        myNeighbors.add(getNeighborRight(c));
        myNeighbors.removeIf(e -> e==null);
        return myNeighbors;
    }

    /**
     * Returns a list of the 8 directly adjacent cells, with
     * any null neighbors removed.
     *
     * @param c the cell whose neighbors this method returns.
     * @return a list of the 8 directly adjacent cells, with
     * any null neighbors removed.
     */
    public List<Cell> getNeighbors_Eight(Cell c) {
        List<Cell> myNeighbors = getNeighbors_Four(c);
        myNeighbors.add(getNeighborUpLeft(c));
        myNeighbors.add(getNeighborDownLeft(c));
        myNeighbors.add(getNeighborUpRight(c));
        myNeighbors.add(getNeighborDownRight(c));
        myNeighbors.removeIf(e -> e==null);
        return myNeighbors;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString () {
        StringBuilder ret = new StringBuilder();
        for (int c = 0; c < width; c++) {
            for (int r = 0; r < height; r++) {
                ret.append(cells[r][c].getState());
            }
            ret.append("\n");
        }
        return ret.toString();
    }

    /**
     * Returns the width of the grid.
     *
     * @return the width of the grid.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the grid.
     *
     * @return the height of the grid.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the 2d array of cells.
     *
     * @return the 2d array of cells.
     */
    public Cell[][] getCells(){
        return cells;
    }

    public int[][] getCellStates() {
        int[][] states = new int[height][width];
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                states[r][c] = cells[r][c].getState();
            }
        }
        return states;
    }

    /**
     * Returns the cell at the specified location.
     *
     * @param r the row of the desired cell.
     * @param c the column of the desired cell.
     * @return the cell at the specified location.
     */
    public Cell getCell(int r, int c) {
        return cells[r][c];
    }

    public Stack<Cell> getCurrentEmptyCells(){
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if(cells[r][c].getState() == 0)
                    emptyCells.add(cells[r][c]);
            }
        }
        return emptyCells;
    }

    public Cell getNextEmptyCell(){
        return emptyCells.peek();
    }
}
