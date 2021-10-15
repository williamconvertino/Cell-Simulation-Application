package cellsociety.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;

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
    void getAllNeighborsBoundsChecking() {
        int xPos = 0;
        int yPos = 0;
        assertEquals(5, Collections.frequency(grid.getAllNeighbors(xPos, yPos), -1));
        assertEquals(3, Collections.frequency(grid.getAllNeighbors(xPos, yPos), 0));

        xPos = grid.getWidth() - 1;
        yPos = grid.getHeight() - 1;
        assertEquals(5, Collections.frequency(grid.getAllNeighbors(xPos, yPos), -1));
        assertEquals(3, Collections.frequency(grid.getAllNeighbors(xPos, yPos), 0));

        xPos = grid.getWidth()/2;
        yPos = grid.getHeight()/2;
        assertEquals(0, Collections.frequency(grid.getAllNeighbors(xPos, yPos), -1));
        assertEquals(8, Collections.frequency(grid.getAllNeighbors(xPos, yPos), 0));
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