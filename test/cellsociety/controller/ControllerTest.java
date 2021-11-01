package cellsociety.controller;

import java.io.File;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import util.DukeApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A series of tests for the Controller class.
 *
 * @author William Convertino
 */
class ControllerTest extends DukeApplicationTest {

    public static final String ENGLISH = "English";

    //The controller to test on.
    Controller testController;


    @Override
    public void start (Stage stage) {
        stage.setScene(new Scene(new Group()));
        testController = new Controller(stage);
    }

    @Test
    void loadFile() {



    }

    void testButtons() {

    }

}