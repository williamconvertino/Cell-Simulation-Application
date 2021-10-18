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
    void getGrid() {
    }
}