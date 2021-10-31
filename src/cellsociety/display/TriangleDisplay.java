package cellsociety.display;

import cellsociety.logic.grid.Cell;
import cellsociety.logic.grid.Coordinate;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TriangleDisplay extends Display{
    Map<Coordinate, Polygon> cellMap;

    public TriangleDisplay(Stage stage, Color background){
        super(stage, background);
    }

    public void initializeGrid(List<Cell> cells){
        resetGrid();

        cellMap = new HashMap<>();

        for(int i = 0; i < cells.size(); i++){
            resetGrid();

            Polygon triangleCell = new Polygon(cells.get(i).getCoordinates().r() * (cellLength + cellOffset) + gridLeftOffset,
                    cells.get(i).getCoordinates().c() * (cellOffset + cellLength) + gridTopOffset, cellLength, cellLength);

            cellMap.put(cells.get(i).getCoordinates(), triangleCell);

            root.getChildren().add(triangleCell);
        }

        updateScene(cells);
    }

    /**
     * Removes all elements of the rectangle objects from the display.
     */
    public void resetGrid(){
        if (cellMap != null) {
            for (Coordinate coordinate : cellMap.keySet()) {
                root.getChildren().remove(cellMap.get(coordinate));
            }
        }
    }

    /**
     * Update Scene
     * @param cells
     */
    public void updateScene(List<Cell> cells) {
        if (cellMap == null || cellMap.size() != cells.size()) {
//            for(Cell cell: cells){
//                System.out.println(cell.getCoordinates());
//            }
            initializeGrid(cells);
            return;
        }

        for (int i = 0; i < cells.size(); i++) {
            Coordinate cellCoordinate = cells.get(i).getCoordinates();
            int currentState = cells.get(i).getCurrentState();

            cellMap.get(cellCoordinate).setFill(COLOR_MAP.get(currentState));
        }

        //System.out.println(cellMap);
    }
}
