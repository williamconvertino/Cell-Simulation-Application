//package cellsociety.logic.grid_LEGACY;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class GridTest {
//    private Grid grid;
//
//    @BeforeEach
//    void setUp() {
//        grid = new Grid(10, 10);
//    }
//
//    @Test
//    void defaultCellValueTest() {
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                assertEquals(0, grid.getCell(i, j).getState(), "The cells do not contain their specified initial value of 1");
//            }
//        }
//    }
//
//    @Test
//    void setInitialCellValueTest() {
//        grid = new Grid(10, 10, 1);
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                assertEquals(1, grid.getCell(i, j).getState(), "The cells do not contain their specified initial value of 1");
//            }
//        }
//    }
//
//    void setCorners() {
//        grid.setCellState(0,0,1);
//        grid.setCellState(0,1,2);
//        grid.setCellState(1,0,3);
//
//        grid.setCellState(grid.getHeight()-1,0,1);
//        grid.setCellState(grid.getHeight() -2,0,2);
//        grid.setCellState(grid.getHeight() -1,1,3);
//
//        grid.setCellState(grid.getHeight()-1,grid.getWidth() -1,1);
//        grid.setCellState(grid.getHeight() -1,grid.getWidth() -2,2);
//        grid.setCellState(grid.getHeight() -2,grid.getWidth() -1,3);
//
//        grid.setCellState(0,grid.getWidth() -1,1);
//        grid.setCellState(0,grid.getWidth() -2,2);
//        grid.setCellState(1,grid.getWidth() -1,3);
//    }
//
//
//    @Test
//    void getNeighborsTest() {
//
//        setCorners();
//        System.out.println(grid);
//
//        //First testing the left and up bounds.
//        Cell c1_c = grid.getCell(0,0);
//        Cell c1_r = grid.getCell(0,1);
//        Cell c1_d = grid.getCell(1,0);
//        Cell c1_dr = grid.getCell(1,1);
//
//        assertEquals(c1_d, grid.getNeighborDown(c1_c));
//        assertEquals(c1_r, grid.getNeighborRight(c1_c));
//        assertEquals(c1_r, grid.getNeighborRight(c1_c));
//        assertEquals(c1_dr, grid.getNeighborDownRight(c1_c));
//        assertEquals(null, grid.getNeighborLeft(c1_c));
//        assertEquals(null, grid.getNeighborUp(c1_c));
//        assertEquals(null, grid.getNeighborUpLeft(c1_c));
//        assertEquals(null, grid.getNeighborDownLeft(c1_c));
//        assertEquals(null, grid.getNeighborUpRight(c1_c));
//
//    }
//
//    @Test
//    void getWidth() {
//        assertEquals(10, grid.getWidth());
//    }
//
//    @Test
//    void getHeight() {
//        assertEquals(10, grid.getHeight());
//    }
//}