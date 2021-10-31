package cellsociety.logic.simulations;

import cellsociety.io.CSVFileReader;
import cellsociety.io.SIMFileReader;
import cellsociety.logic.grid.Grid;
import cellsociety.logic.neighborhoodpatterns.NeighborhoodPattern;
import cellsociety.logic.shapes.ShapeManager;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static cellsociety.controller.LogicController.INITIAL_STATE_FILE;
import static org.junit.jupiter.api.Assertions.*;

class WaTorWorldTest {
    private WaTorWorld ww;
    @Test
    void simplePipeTest() {
        try {
            HashMap<String, String> metadata = (HashMap<String, String>) SIMFileReader.getMetadataFromFile(new File("data/wator/random_assortment.sim"));
            Class cls[] = new Class[]{int[][].class, ShapeManager.class};
            ShapeManager sm = (ShapeManager) Class.forName("cellsociety.logic.shapes." + metadata.get("Shape")).getConstructor().newInstance();
            Object[] params = {CSVFileReader.readFile(new File(metadata.get(INITIAL_STATE_FILE))),
                    sm};
            Grid grid = (Grid) Class.forName("cellsociety.logic.grid." + metadata.get("GridType")).getConstructor(cls).newInstance(params);

            ww = (WaTorWorld) WaTorWorld.class.getConstructor(Grid.class, NeighborhoodPattern.class, Map.class).newInstance(
                    grid,
                    (NeighborhoodPattern) Class.forName("cellsociety.logic.neighborhoodpatterns." + metadata.get("Neighborhood"))
                            .getConstructor().newInstance(),
                    metadata);
            ww.update();
            int x = 0;
            int y = 0;
            System.out.println(grid);
            assertEquals(2, ww.getGrid().getCell(x, y).getCurrentState());
            x = 0;
            y = 1;
            assertEquals(0, ww.getGrid().getCell(x, y).getCurrentState());
            x = 1;
            y = 2;
            assertEquals(0, ww.getGrid().getCell(x, y).getCurrentState());
        } catch (Exception e) {
            fail("File Not Found");
        }

    }

//    @Test
//    void longPipeTest() {
//        try {
//            Grid grid = new Grid(CSVFileReader.readFile(new File("data/wator/single_fish.csv")));
//            HashMap<String, String> metadata = (HashMap<String, String>) SIMFileReader.getMetadataFromFile(new File("data/wator/single_fish.sim"));
//            ww = new WaTorWorld(grid.getCellStates(), metadata);
//            ww.update();
//            int x = 0;
//            int y = 0;
//            assertEquals(1, ww.getGrid().getCell(x, y).getState());
//            x = 0;
//            y = 2;
//            assertEquals(1, ww.getGrid().getCell(x, y).getState());
//            x = 1;
//            y = 2;
//            assertEquals(1, ww.getGrid().getCell(x, y).getState());
//        } catch (Exception e) {
//            fail("File Not Found");
//        }
//
//    }
//
//    @Test
//    void volcanoTest() {
//        try {
//            Grid grid = new Grid(CSVFileReader.readFile(new File("data/wator/random_assortment.csv")));
//            HashMap<String, String> metadata = (HashMap<String, String>) SIMFileReader.getMetadataFromFile(new File("data/wator/random_assortment.sim"));
//            ww = new WaTorWorld(grid.getCellStates(), metadata);
//            ww.update();
//            int x = 0;
//            int y = 0;
//            assertEquals(1, ww.getGrid().getCell(x, y).getState());
//            x = 0;
//            y = 2;
//            assertEquals(1, ww.getGrid().getCell(x, y).getState());
//            x = 1;
//            y = 5;
//            assertEquals(2, ww.getGrid().getCell(x, y).getState());
//        } catch (Exception e) {
//            fail("File Not Found");
//        }

    }