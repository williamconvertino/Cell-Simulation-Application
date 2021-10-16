package cellsociety;


import java.lang.ModuleLayer.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * A class to organize and initialize our JFX Application.
 *
 * @author William Convertino
 * @since 0.0.1
 */
public class Main extends Application {

    /**The current version of our CellSociety program.**/
    public static final String CURRENT_VERSION = "0.0.1";

    /**The language our program should initialize with is {@value #INIT_LANGUAGE}**/
    public static final String INIT_LANGUAGE = "English";

    /**The name of our program's window is {@value #WINDOW_NAME}**/
    public static final String WINDOW_NAME = "Cell Society";


    /**
     * Starts our program as a JFX Application, giving the window a title
     * that contains our program name and the current version. Also initializes
     * our CellSociety program with a default language of {@value #INIT_LANGUAGE}.
     *
     * @param primaryStage the JFX stage of our application.
     * @throws Exception if there is some error during start-up.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(String.format("%s %s",WINDOW_NAME,CURRENT_VERSION));

    }
}
