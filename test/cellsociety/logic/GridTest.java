package cellsociety.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    private Grid grid;

    @BeforeEach
    void setUp(){
        grid = new Grid(50, 50);
    }

    @Test
    void defaultCellValueTest() {
        for(int i = 0; i < 50*50; i++){
            assertEquals(0, grid.getCell(0,0), "The cells do not contain their default value of 0");
        }
    }

    @Test
    void setInitialCellValueTest() {
        grid = new Grid(50, 50, 1);

        for(int i = 0; i < 50*50; i++){
            assertEquals(1, grid.getCell(0,0), "The cells do not contain their specified initial value of 1");
        }
    }

    @Test
    void getAllNeighbors() {
    }

    @Test
    void getFourNeighbors() {
    }

    @Test
    void updateGrid() {
    }

    @Test
    void getWidth() {
    }

    @Test
    void getHeight() {
    }
}