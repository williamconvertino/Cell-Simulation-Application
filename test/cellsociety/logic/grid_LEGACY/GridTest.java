//package cellsociety.logic.grid_LEGACY;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class GridTest {
//    private Grid grids;
//
//    @BeforeEach
//    void setUp() {
//        grids = new Grid(10, 10);
//    }
//
//    @Test
//    void defaultCellValueTest() {
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                assertEquals(0, grids.getCell(i, j).getState(), "The cells do not contain their specified initial value of 1");
//            }
//        }
//    }
//
//    @Test
//    void setInitialCellValueTest() {
//        grids = new Grid(10, 10, 1);
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                assertEquals(1, grids.getCell(i, j).getState(), "The cells do not contain their specified initial value of 1");
//            }
//        }
//    }
//
//    void setCorners() {
//        grids.setCellState(0,0,1);
//        grids.setCellState(0,1,2);
//        grids.setCellState(1,0,3);
//
//        grids.setCellState(grids.getHeight()-1,0,1);
//        grids.setCellState(grids.getHeight() -2,0,2);
//        grids.setCellState(grids.getHeight() -1,1,3);
//
//        grids.setCellState(grids.getHeight()-1,grids.getWidth() -1,1);
//        grids.setCellState(grids.getHeight() -1,grids.getWidth() -2,2);
//        grids.setCellState(grids.getHeight() -2,grids.getWidth() -1,3);
//
//        grids.setCellState(0,grids.getWidth() -1,1);
//        grids.setCellState(0,grids.getWidth() -2,2);
//        grids.setCellState(1,grids.getWidth() -1,3);
//    }
//
//
//    @Test
//    void getNeighborsTest() {
//
//        setCorners();
//        System.out.println(grids);
//
//        //First testing the left and up bounds.
//        Cell c1_c = grids.getCell(0,0);
//        Cell c1_r = grids.getCell(0,1);
//        Cell c1_d = grids.getCell(1,0);
//        Cell c1_dr = grids.getCell(1,1);
//
//        assertEquals(c1_d, grids.getNeighborDown(c1_c));
//        assertEquals(c1_r, grids.getNeighborRight(c1_c));
//        assertEquals(c1_r, grids.getNeighborRight(c1_c));
//        assertEquals(c1_dr, grids.getNeighborDownRight(c1_c));
//        assertEquals(null, grids.getNeighborLeft(c1_c));
//        assertEquals(null, grids.getNeighborUp(c1_c));
//        assertEquals(null, grids.getNeighborUpLeft(c1_c));
//        assertEquals(null, grids.getNeighborDownLeft(c1_c));
//        assertEquals(null, grids.getNeighborUpRight(c1_c));
//
//    }
//
//    @Test
//    void getWidth() {
//        assertEquals(10, grids.getWidth());
//    }
//
//    @Test
//    void getHeight() {
//        assertEquals(10, grids.getHeight());
//    }
//}