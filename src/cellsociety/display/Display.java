package cellsociety.display;

import cellsociety.io.FilePickerEventHandler;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.css.Rect;


public class Display {

    public static Map<Integer, Color> COLOR_MAP = new HashMap();
    static {
        COLOR_MAP.put(0, Color.WHITE);
        COLOR_MAP.put(1, Color.BLUE);
        COLOR_MAP.put(2, Color.RED);
    }
    public final static int LEFT_OFFSET_GRID = 200;
    public final static int TOP_OFFSET_GRID = 50;
    public final static double CELL_LENGTH = 29;
    public final static double CELL_OFFSET = 1.5;
    public final static int BUTTON_OFFSET = 50;
    public final static int BUTTON_OFFSET_TOP = 30;
    private Stage myStage;
    private Rectangle[][] displayGrid;

    private Group root;

    /**
     * Create display based on given background color and Grid Cell length.
     */
    public Display (Stage myStage, Color background) {
        this.myStage = myStage;
        root = (Group)myStage.getScene().getRoot();
        myStage.getScene().setFill(background);

    }

    public void initializeGrid(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }
        displayGrid = new Rectangle[grid.length][grid[0].length];

        for(int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                Rectangle cell = new Rectangle(x*(CELL_LENGTH + CELL_OFFSET) + LEFT_OFFSET_GRID,
                    y*(CELL_OFFSET + CELL_LENGTH) + TOP_OFFSET_GRID , CELL_LENGTH, CELL_LENGTH);
                displayGrid[x][y] = cell;
                root.getChildren().add(cell);
            }
        }
        updateScene(grid);
    }

    /**
     * Update Scene
     */
    public void updateScene (int[][] grid) {
        if (displayGrid == null || grid.length != displayGrid.length) {
            initializeGrid(grid);
            return;
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                displayGrid[i][j].setFill(COLOR_MAP.get(grid[i][j]));
            }
        }
    }

    public void addButtons(Button saveButton, Button playButton, Button pauseButton, Button resetButton){
        saveButton.setLayoutX(BUTTON_OFFSET);
        saveButton.setLayoutY(BUTTON_OFFSET);

        playButton.setLayoutX(BUTTON_OFFSET);
        playButton.setLayoutY(BUTTON_OFFSET_TOP + BUTTON_OFFSET);

        pauseButton.setLayoutX(BUTTON_OFFSET);
        pauseButton.setLayoutY(BUTTON_OFFSET_TOP + BUTTON_OFFSET*2);

        resetButton.setLayoutX(BUTTON_OFFSET);
        resetButton.setLayoutY(BUTTON_OFFSET_TOP + BUTTON_OFFSET*3);

        root.getChildren().add(saveButton);
        root.getChildren().add(playButton);
        root.getChildren().add(pauseButton);
        root.getChildren().add(resetButton);
    }

    public void addFileChoser(FilePickerEventHandler fileChosenHandler) {
        Button fileChooserButton = new Button("Choose a file");

        fileChooserButton.setOnAction(new EventHandler<ActionEvent>() {
            FileChooser myFileChoser = new FileChooser();
            @Override
            public void handle(ActionEvent event) {
                myFileChoser.setInitialDirectory(new File(Paths.get(".").toAbsolutePath().normalize().toString() + "/data"));
                File file = myFileChoser.showOpenDialog(myStage);
                fileChosenHandler.sendFile(file);
            }
        });

        fileChooserButton.setLayoutX(BUTTON_OFFSET);
        fileChooserButton.setLayoutY(0);

        root.getChildren().add(fileChooserButton);
    }
}
