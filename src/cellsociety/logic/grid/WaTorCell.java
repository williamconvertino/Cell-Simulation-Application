package cellsociety.logic.grid;

public class WaTorCell {
    //The state of the cell.
    private Animal animal;

    //The row and column of this cell in the grid.
    private int row,column;

    /**
     * Constructs a cell at the specified position with the
     * specified state.
     *
     * @param row the row where the cell is located.
     * @param column the column where the cell is located.
     * @param animal the type of animal in the cell.
     */
    public WaTorCell(int row, int column, Animal animal) {
        this.row = row;
        this.column = column;
        this.animal = animal;
    }

    /**
     * Returns the state of the cell.
     *
     * @return the animal of the cell.
     */
    public Animal getState() {
        return animal;
    }

    /**
     * Sets the state of the cell.
     *
     * @param animal the animal to which this cell should be set.
     */
    public void setState(Animal animal) {
        this.animal = animal;
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
