package cellsociety.logic;

import cellsociety.logic.grid.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    private Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid(10, 10);
    }

    @Test
    void defaultCellValueTest() {
        for (int i = 0; i < 10 * 10; i++) {
            assertEquals(0, grid.getCell(0, 0), "The cells do not contain their default value of 0");
        }
    }

    @Test
    void setInitialCellValueTest() {
        grid = new Grid(10, 10, 1);
        for (int i = 0; i < 10 * 10; i++) {
            assertEquals(1, grid.getCell(0, 0), "The cells do not contain their specified initial value of 1");
        }
    }

    void setCorners() {
        grid.setCellState(0,0,1);
        grid.setCellState(0,1,2);
        grid.setCellState(1,0,3);

        grid.setCellState(grid.getHeight()-1,0,1);
        grid.setCellState(grid.getHeight() -2,1,2);
        grid.setCellState(grid.getHeight() -2,0,3);

        grid.setCellState(grid.getHeight()-1,grid.getWidth() -1,1);
        grid.setCellState(grid.getHeight() -2,grid.getWidth() -2,2);
        grid.setCellState(grid.getHeight() -2,grid.getWidth() -1,3);

        grid.setCellState(0,grid.getWidth() -1,1);
        grid.setCellState(0,grid.getWidth() -2,2);
        grid.setCellState(1,grid.getWidth() -1,3);
    }


    @Test
    void getNeighborsTest() {

        setCorners();
        System.out.println(grid);
    }

    @Test
    void getWidth() {
        assertEquals(50, grid.getWidth());
    }

    @Test
    void getHeight() {
        assertEquals(50, grid.getHeight());
    }
}