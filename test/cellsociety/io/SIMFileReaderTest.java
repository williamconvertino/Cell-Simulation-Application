package cellsociety.io;

import cellsociety.errors.FileNotFoundError;
import cellsociety.errors.UnhandledExceptionError;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SIMFileReaderTest {
    @Test
    void configurationWithSimTest() throws FileNotFoundError, UnhandledExceptionError {
        HashMap test = (HashMap) SIMFileReader.getMetadataFromFile(new File("data/game_of_life/blinkers.sim"));
        assertNotEquals(null, test);

        assertEquals("GameOfLife", test.get("Type"));
        assertEquals("Blinkers", test.get("Title"));
        assertEquals("John Conway", test.get("Author"));
        assertEquals("Examples of a blinker, a line of cells 3 wide that switches back and forth from vertical to horizontal", test.get("Description"));
        assertEquals("data/game_of_life/blinkers.csv", test.get("InitialStates"));

    }

}