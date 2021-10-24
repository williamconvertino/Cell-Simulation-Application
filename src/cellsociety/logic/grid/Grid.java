package cellsociety.logic.grid;

import java.util.ArrayList;


/**
 * The Grid class for the grid of cells in each of the games
 * @author Alexis Cruz
 */
public class Grid {

    //An array of all the cells in the grid.
    private Cell[][] cells;

    //The height of the grid.
    private int height;

    //The width of the grid.
    private int width;

    public enum Neighbors {
        UP, DOWN, LEFT, RIGHT, UP_LEFT, DOWN_LEFT, UP_RIGHT, DOWN_RIGHT;
    }

    //constructor that sets the width and height of the current
    //and previous grid and initializes all values to 0
    public Grid(int height, int width) {
        initializeCells(height, width, 0);
    }

    //constructor that sets the width and height of the current
    // and previous grid and initializes all values to initialValue
    public Grid(int height, int width, int initialValue) {
        initializeCells(height, width, initialValue);
    }

    private void initializeCells(int height, int width, int value) {
        initializeCells(width, height);
        for (int r = 0; r < width; r++) {
            for (int c = 0; c < width; c++) {
                cells[r][c] = new Cell(r,c,value);
            }
        }
    }

    private void initializeCells(int width, int height) {
        this.cells = new Cell[width][height];
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the value of the cell at (x,y) from the current grid
     * @param x the x position of the desired cell
     * @param y the y position of the desired cell
     * @return the value held within that cell
     */
    public int getCellState(int x, int y) {
        return cells[x][y].getState();
    }

    /**
     * sets the value of the cell at (x,y) for the future grid
     * @param r the x position of the desired cell
     * @param c the y position of the desired cell
     * @param newVal the value to be held within that cell
     */
    public void setCellState(int r, int c, int newVal) {
        cells[r][c].setState(newVal);
    }

    public Cell getNeighborUp(Cell c) {
        if (c.getRow() <= 0 || c.getRow() > height - 1) {
            return null;
        }
        return cells[c.getRow()-1][c.getCollumn()];
    }

    public Cell getNeighborDown(Cell c) {
        if (c.getRow() < 0 || c.getRow() > height - 2) {
            return null;
        }
        return cells[c.getRow()+1][c.getCollumn()];
    }

    public Cell getNeighborLeft(Cell c) {
        if (c.getCollumn() <= 0 || c.getCollumn() > width - 1) {
            return null;
        }
        return cells[c.getRow()][c.getCollumn()-1];
    }

    public Cell getNeighborRight(Cell c) {
        if (c.getCollumn() < 0 || c.getCollumn() > width - 2) {
            return null;
        }
        return cells[c.getRow()][c.getCollumn()+1];
    }

    public Cell getNeighborUpLeft(Cell c) {
        if (getNeighborLeft(c) == null || getNeighborUp(c) == null) {
            return null;
        }
        return cells[c.getRow()-1][c.getCollumn()-1];
    }

    public Cell getNeighborUpRight(Cell c) {
        if (getNeighborRight(c) == null || getNeighborUp(c) == null) {
            return null;
        }
        return cells[c.getRow()-1][c.getCollumn()+1];
    }

    public Cell getNeighborDownLeft(Cell c) {
        if (getNeighborLeft(c) == null || getNeighborDown(c) == null) {
            return null;
        }
        return cells[c.getRow()+1][c.getCollumn()-1];
    }
    public Cell getNeighborDownRight(Cell c) {
        if (getNeighborLeft(c) == null || getNeighborUp(c) == null) {
            return null;
        }
        return cells[c.getRow()+1][c.getCollumn()+1];
    }

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
     * @return the width of the Grid
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height of the grid
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return gets the current grid
     */
    public Cell[][] getCells(){
        return cells;
    }

    public Integer[][] getCellStates() {
        Integer[][] states = new Integer[height][width];
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                states[r][c] = cells[r][c].getState();
            }
        }
        return states;
    }

    public Cell getCell(int r, int c) {
        return cells[r][c];
    }
}
