package cellsociety.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {
    private GameOfLife gol;

    @BeforeEach
    void setUp(){
        gol = new GameOfLife(100, 100);
    }

    @Test
    void updateTest(){

    }
}