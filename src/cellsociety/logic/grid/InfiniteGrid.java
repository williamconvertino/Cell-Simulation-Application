package cellsociety.logic.grid;

import cellsociety.logic.neighborhoodpatterns.NeighborhoodPattern;
import cellsociety.logic.shapes.ShapeManager;

import java.util.LinkedList;
import java.util.List;

public class InfiniteGrid extends Grid{


    /**
     * Constructs a new grid with a specified array of states
     *
     * @param states
     * @param shapeManager
     */
    public InfiniteGrid(int[][] states, ShapeManager shapeManager) {
        super(states, shapeManager);
    }

    @Override
    public List<Cell> getNeighbors(Cell cell, NeighborhoodPattern myPattern) {
        List<Coordinate> potentialNeighbors = generateNeighborCoordinates(cell, myPattern);
        potentialNeighbors.forEach(coord ->{
            if(coord.c() > getWidth() || coord.r() > getHeight()){
                addCellIfAbsent(coord.r(), coord.c(), 0);
            }
        });
        List<Cell> myNeighbors = new LinkedList<>();
        for (Coordinate coord: potentialNeighbors) {
            myNeighbors.add(getCell(coord.r(), coord.c()));
        }
        return myNeighbors;
    }
}
