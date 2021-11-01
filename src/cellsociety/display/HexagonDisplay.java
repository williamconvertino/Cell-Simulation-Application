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


/**
 * @author Tim Jang
 */
public class HexagonDisplay extends Display {
    Map<Coordinate, Polygon> cellMap;

    public HexagonDisplay(Stage stage, Color background) {
        super(stage, background);
        cellOffset += 20;
        cellLength -= 10;
    }

    public void initializeGrid(List<Cell> cells) {
        resetGrid();

        cellMap = new HashMap<>();

        for (int i = 0; i < cells.size(); i++) {
            Polygon hexagon = new Polygon();
            double startX = cells.get(i).getCoordinates().r() * (cellLength + cellOffset) + gridLeftOffset;
            double startY = cells.get(i).getCoordinates().c() * (cellLength + cellOffset) + gridTopOffset;
            //*Math.sin(Math.toRadians(60))
            hexagon.getPoints().addAll(new Double[]{
                    startX, startY,
                    startX + cellLength, startY,
                    startX + cellLength + cellLength * Math.cos(Math.toRadians(60)), startY + cellLength * Math.sin(Math.toRadians(60)),
                    startX + cellLength, startY + 2 * cellLength * Math.sin(Math.toRadians(60)),
                    startX, startY + 2 * cellLength * Math.sin(Math.toRadians(60)),
                    startX - cellLength * Math.cos(Math.toRadians(60)), startY + cellLength * Math.sin(Math.toRadians(60)),
            });

            cellMap.put(cells.get(i).getCoordinates(), hexagon);

            root.getChildren().add(hexagon);
        }

        updateScene(cells);
    }

    /**
     * Removes all elements of the rectangle objects from the display.
     */
    public void resetGrid() {
        if (cellMap != null) {
            for (Coordinate coordinate : cellMap.keySet()) {
                root.getChildren().remove(cellMap.get(coordinate));
            }
        }
    }

    /**
     * Update Scene
     *
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
