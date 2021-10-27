package cellsociety.logic.grid;

/**
 * @author Quentin MacFarlane
 *
 * @since 0.0.2
 */
public class WaTorCell extends Cell {
    //The animal of the cell.
    private Animal animal;

    /**
     * Constructs a cell at the specified position with the
     * specified state.
     *
     * @param row the row where the cell is located.
     * @param column the column where the cell is located.
     * @param state the state of the cell.
     */
    public WaTorCell(int row, int column, int state, Animal animal) {
        super(row, column, state);
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }
}
