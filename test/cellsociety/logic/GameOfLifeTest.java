package cellsociety.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {
    private GameOfLife gol = new GameOfLife(10, 10);

    @Test
    void simulationOfBoatTest(){
        gol.initializeWithSimFile("data/game_of_life/boat.sim");
        gol.initializeWithCSVFile("data/game_of_life/boat.csv");
        gol.update();
        int x = 0;
        int y = 0;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 0;
        y = 1;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 1;
        y = 0;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 2;
        y = 1;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 1;
        y = 2;
        assertEquals(1, gol.getGrid().getCell(x, y));

    }

    @Test
    void simulationOfLightWeightShipTest(){
        gol.initializeWithSimFile("data/game_of_life/light_weight_ship.sim");
        gol.initializeWithCSVFile("data/game_of_life/light_weight_ship.csv");
        gol.update();

        int x = 0;
        int y = 5;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 0;
        y = 4;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 0;
        y = 3;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 0;
        y = 2;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 0;
        y = 1;
        assertEquals(0, gol.getGrid().getCell(x, y));
        x = 1;
        y = 1;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 1;
        y = 5;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 2;
        y = 5;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 3;
        y = 1;
        assertEquals(1, gol.getGrid().getCell(x, y));
    }

    @Test
    void simulationOfToadTest(){
        gol.initializeWithSimFile("data/game_of_life/oscillator_toad.sim");
        gol.initializeWithCSVFile("data/game_of_life/oscillator_toad.csv");
        gol.update();
        int x = 2;
        int y = 1;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 1;
        y = 3;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 3;
        y = 1;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 4;
        y = 2;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 2;
        y = 4;
        assertEquals(1, gol.getGrid().getCell(x, y));

    }
    @Test
    void simulationOfStillLifeBlockTest(){

        gol.initializeWithSimFile("data/game_of_life/still_life_square.sim");
        gol.initializeWithCSVFile("data/game_of_life/still_life_square.csv");
        gol.update();
        int x = 1;
        int y = 1;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 2;
        y = 2;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 1;
        y = 2;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 2;
        y = 1;
        assertEquals(1, gol.getGrid().getCell(x, y));
        x = 0;
        y = 0;
        assertEquals(0, gol.getGrid().getCell(x, y));
    }

}