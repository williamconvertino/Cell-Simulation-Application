package cellsociety.io;

import cellsociety.logic.Grid;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    /*
    @Test
    void saveGridToCsv() throws IOException {
        Grid grid = CSVFileReader.readFile("./data/game_of_life/still_life_square.csv");
        assertNotEquals(null, grid);
        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                System.out.print(grid.getCell(i,j));
            }
            System.out.println("");
        }

        String fileName = "testExample";
        FileHandler.saveFile(grid, fileName);

        assertTrue(new File("./data/game_of_life/testExample.csv").isFile());
    }*/
}
