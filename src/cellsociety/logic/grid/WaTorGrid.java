package cellsociety.logic.grid;

public class WaTorGrid extends Grid {

    public WaTorGrid(int height, int width) {
        super(height, width);
    }

    @Override
    //Creates the cells array and initializes each of them to the specified value.
    protected void initializeCells(int height, int width, int value) {
        this.cells = new WaTorCell[width][height];
        this.width = width;
        this.height = height;
        for (int r = 0; r < width; r++) {
            for (int c = 0; c < width; c++) {
                cells[r][c] = new WaTorCell(r,c,value);
            }
        }
    }
}
