package cellsociety.logic.shapes;

import cellsociety.logic.grid.Coordinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexagonShapeManagerTest extends ShapeManagerTest {

    Coordinate cl1 = new Coordinate(-1,-1);
    Coordinate cl2 = new Coordinate(0,-1);

    Coordinate cr = new Coordinate(-2,1);
    Coordinate cu = new Coordinate(-1,0);

    Coordinate cd = new Coordinate(1,0);

    Coordinate cul = new Coordinate(-1,-1);
    Coordinate cur = new Coordinate(-1,1);
    Coordinate cdl = new Coordinate(1,-1);
    Coordinate cdr = new Coordinate(1,1);



    @Test
    void testCardinalDirections() {
        //System.out.println(myShapeManager.getNeighborsLeft(c0));
        assertUpNeighbors(cu);
        assertDownNeighbors(cd);
        assertLeftNeighbors(cl1, cl2);
        //assertRightNeighbors(cr);
    }

    @Test
    void testCorners() {
        assertUpRightNeighbors(cur);
        assertDownRightNeighbors(cdr);
        assertUpLeftNeighbors(cul);
        assertDownLeftNeighbors(cdl);
    }

    @Test
    void testAllDirections() {
        assertAllLeftNeighbors(cl1, cl2,cul,cdl);
        assertAllRightNeighbors(cr,cur,cdr);
        assertAllUpNeighbors(cul,cu,cur);
        assertAllDownNeighbors(cd,cdr,cdl);
    }

    @BeforeEach
    public void initialize() {
        myShapeManager = new HexagonShapeManager();
    }
}