package cellsociety.logic;

import cellsociety.io.SIMFileReader;
import com.opencsv.CSVReader;
import org.apache.commons.logging.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {

    private Logic logic;

    @BeforeEach
    void setUp() {
        logic = new Logic(100, 100) {
            @Override
            public void update() {
            }
        };
    }

    @Test
    void initializeWithCSVFile() {
        assertEquals(true, logic.initializeWithCSVFile("data/game_of_life/blinkers.csv"));

        assertEquals(10, logic.getGrid().getWidth());
        assertEquals(10, logic.getGrid().getHeight());
        try {
            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader("data/game_of_life/blinkers.csv");

            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReader(filereader);
            int i = 0, j = 0;
            //this is merely to skip the line with the dimensions
            String[] nextRecord = csvReader.readNext();
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    assertEquals(Integer.parseInt(cell), logic.getGrid().getCell(i % logic.getGrid().getWidth(), j % logic.getGrid().getHeight()));
                    j++;
                }
                i++;
            }

        } catch (Exception e) {
        }

        int xPos = 0, yPos = 0;
        assertEquals(0, logic.getGrid().getCell(xPos, yPos));
        xPos = 0;
        yPos = logic.getGrid().getHeight() - 1;
        assertEquals(1, logic.getGrid().getCell(xPos, yPos));
        xPos = logic.getGrid().getWidth() - 1;
        yPos = 0;
        assertEquals(0, logic.getGrid().getCell(xPos, yPos));
        xPos = logic.getGrid().getWidth() - 1;
        yPos = logic.getGrid().getHeight() - 1;
        assertEquals(0, logic.getGrid().getCell(xPos, yPos));
    }



    @Test
    void getGrid() {
    }
}