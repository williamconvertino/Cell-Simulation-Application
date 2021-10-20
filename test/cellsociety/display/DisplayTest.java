package cellsociety.display;

import cellsociety.controller.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.util.Duration;
import org.junit.jupiter.api.Test;
import javafx.stage.Stage;


import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisplayTest extends DisplayApplication {
    //The Cell Society program to run.
    private Controller cellSocietyProgram;

    //The JFX scene of the program.
    private Scene cellSocietyScene;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(String.format("%s %s", "Cell Society Test", "0.0.1"));
        initializeWindow(primaryStage);
        cellSocietyProgram = new Controller(primaryStage, "English");
        initializeTimeline();
    }
    //Creates the JFX Timeline for our program, allowing the cellSocietyProgram to
    //update each tick.
    private void initializeTimeline() {
        Timeline myTimeline = new Timeline();
        myTimeline.setCycleCount(Timeline.INDEFINITE);
        myTimeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1.0/60), e -> cellSocietyProgram.update()));
        myTimeline.play();
    }

    //Initializes and displays the program window using the default window width and height.
    //Also gives the Controller access to the window's display group.
    private void initializeWindow(Stage myStage) {
        cellSocietyScene = new Scene(new Group(), 1280, 720);
        myStage.setScene(cellSocietyScene);
        myStage.show();
    }

    /**
     * Test a method from Display.
     */
    @Test
    void DisplayUpdateTest () {
        File file = new File("./blinkers.sim");
        cellSocietyProgram.loadFile(file);
        cellSocietyProgram.update();
    }
}
