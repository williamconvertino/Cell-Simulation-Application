package cellsociety.logic.simulations;

import cellsociety.errors.MissingSimulationArgumentError;

import cellsociety.logic.grid.Cell;
import cellsociety.logic.grid.Grid;
import cellsociety.logic.neighborhoodpatterns.NeighborhoodPattern;

import java.util.*;

/**
 * @author Quentin MacFarlane
 *
 * @since 0.0.2
 */
public class WaTorWorld extends Simulation {

    private int initEnergy;
    private int reproductionTime;
    private int energyPerFish;

    public WaTorWorld(Grid grid, NeighborhoodPattern np, Map<String, String> metadata) throws MissingSimulationArgumentError {
        super(grid, np, metadata);
        this.initEnergy = Integer.parseInt(metadata.get("InitialEnergy"));
        this.reproductionTime = Integer.parseInt(metadata.get("ReproductionTime"));
        this.energyPerFish = Integer.parseInt(metadata.get("EnergyPerFish"));
//        changeToWatorCells();
    }

//    private void changeToWatorCells() {
//        // setting the cells with '1' to a WaTorCell w/ a Fish object and the cells with '2' to a WaTorCell w/ a Shark object
//        for (int r = 0; r < getGrid().getHeight(); r++) {
//            for (int c = 0; c < getGrid().getWidth(); c++) {
//                if (getGrid().getCell(r,c).getState() == 1) { // if the cell's state is a 1 (meaning it's a fish)
//                    getGrid().setCell(r, c, new WaTorCell(r,c,getGrid().getCellState(r,c), new Fish()));
//                }
//                else if (getGrid().getCell(r,c).getState() == 2) { // if the cell's state is a 2 (meaning it's a shark)
//                    getGrid().setCell(r, c, new WaTorCell(r,c,getGrid().getCellState(r,c), new Shark(initEnergy)));
//                }
//            }
//        }
//    }

    @Override
    protected void updateNextGridFromCell(Cell cell) {
        // if the cell is just water, do nothing
        if (cell.getCurrentState() == 0) {
            return;
        } else if (cell.getCurrentState() == 1) { // if the cell is a fish
            List<Cell> neighbors = getGrid().getNeighbors(cell, getNeighborhoodPattern());
            neighbors.removeIf(Objects::isNull);
            // increase the time survived for the fish by 1
            if (cell.getAltStates() == null) {
                cell.addState("Life", 1);
            } else {
                cell.addState("Life", cell.getAltStates().get("Life") + 1);
            }

            // find only the empty water around the fish
            neighbors.removeIf(e->e.getCurrentState() == 1 || e.getCurrentState() == 2);

            // if there is a water spot next to the fish, move it there
            moveFish(neighbors, cell);


        } else if (cell.getCurrentState() == 2) { // if the cell is a shark
            if (cell.getAltStates() == null) {
                cell.addState("Life", 1);
                cell.addState("Life", initEnergy);
            } else {
                cell.addState("Life", cell.getAltStates().get("Life") + 1);
            }

            List<Cell> neighborsFish = getGrid().getNeighbors(cell, getNeighborhoodPattern());
            neighborsFish.removeIf(e->e.getCurrentState() == 0 || e.getCurrentState() == 2); // find only the fish around the shark

            // if there are no fish around the shark, look for empty water
            List<Cell> neighborsEmpty = getGrid().getNeighbors(cell, getNeighborhoodPattern());
            neighborsEmpty.removeIf(e->e.getCurrentState() == 1 || e.getCurrentState() == 2); // find the empty water around the shark

            // eats a fish, if it can, or moves to empty water spot
            eatFishOrMove(neighborsFish, neighborsEmpty, cell);

            // updates the shark based on how much energy it has
//            checkEnergy(currentShark, neighborsEmpty, cell);
        }
    }

    private void moveFish(List<Cell> neighbors, Cell cell) {
        boolean reproduce = false;
        // reproduce a new fish if the fish has survived for "reproductionTime" amount of time
        if (cell.getAltStates().get("Life") == reproductionTime) {
            reproduce = true;
        }

        if (neighbors.size() > 0) {
            // first, figure out where to move the fish (random spot from the adjacent water spots)
            Collections.shuffle(neighbors);

            // check to see if the grid has an empty water spot for the cell we want to move to
//        if (getGrid().getCell(neighbors.get(0).getCoordinates().r(), neighbors.get(0).getCoordinates().c()).getCurrentState() == 0) {
            // change the neighbor cell to have a fish
            getGrid().moveCellTo(cell, neighbors.get(0));
            // sets the previous spot where the fish just was to empty water
//                nextGrid.setCellState(cell.getRow(), cell.getColumn(), 0);
//        }
            if (reproduce) {
                getGrid().changeCell(cell, 1);
                cell.addState("Life", 1);
            }
        } else {
            getGrid().changeCell(cell, cell.getCurrentState());
        }
    }

    private void eatFishOrMove(List<Cell> neighborsFish, List<Cell> neighborsEmpty, Cell cell) {
        boolean reproduce = false;
        // reproduce a new shark if the shark has survived for "reproductionTime" amount of time
        if (cell.getAltStates().get("Life") == reproductionTime) {
            reproduce = true;
        }

        if (neighborsFish.size() > 0) { // if there is a fish next to the shark
            // first, figure out which fish to eat
            Collections.shuffle(neighborsFish);

            int prevEnergy = cell.getAltStates().get("Energy");
            // increase the energy for the shark by "energy" amount
            cell.addState("Energy", prevEnergy + energyPerFish - 1);

            // checking to see if a shark has occupied the next spot already, or if the fish already moved away
//            if (nextGrid.getCell(neighborsFish.get(0).getRow(), neighborsFish.get(0).getColumn()).getState() != 2
//                    || nextGrid.getCell(neighborsFish.get(0).getRow(), neighborsFish.get(0).getColumn()).getState() == 0) {
                // move the shark to the spot identified
            getGrid().moveCellTo(cell, neighborsFish.get(0));
                // sets the previous spot where the shark just was to empty water
//                nextGrid.setCellState(cell.getRow(), cell.getColumn(), 0);
            if (reproduce) {
                getGrid().changeCell(cell, 1);
                cell.addState("Life", 1);
                cell.addState("Energy", initEnergy);
            }
//            }
        } else if (neighborsEmpty.size() > 0) { // if there is an empty water spot next to the shark
            // first, figure out which water spot to move to
            Collections.shuffle(neighborsEmpty);

            int prevEnergy = cell.getAltStates().get("Energy");
            cell.addState("Energy", prevEnergy - 1);
            if (cell.getAltStates().get("Energy") == 0) {
                getGrid().moveCellTo(cell, cell);
            } else {
                getGrid().moveCellTo(cell, neighborsEmpty.get(0));
            }

            if (reproduce) {
                getGrid().changeCell(cell, 1);
                cell.addState("Life", 1);
                cell.addState("Energy", initEnergy);
            }
            // check to see if the nextGrid has an empty water spot for the cell we want to move to
//            if (nextGrid.getCell(neighborsFish.get(0).getRow(), neighborsFish.get(0).getColumn()).getState() == 0) {
                // move the shark to the spot identified
                // sets the previous spot where the shark just was to empty water
//                nextGrid.setCellState(cell.getRow(), cell.getColumn(), 0);
//            }
        } else {
            int prevEnergy = cell.getAltStates().get("Energy");
            cell.addState("Energy", prevEnergy - 1);
            if (cell.getAltStates().get("Energy") == 0) {
                getGrid().moveCellTo(cell, cell);
            } else {
                getGrid().changeCell(cell, cell.getCurrentState());
            }
        }
    }

//    private void checkEnergy(Shark currentShark, List<Cell> neighborsEmpty, Cell cell) {
//        // if the shark ran out of energy and moved, set it to empty water space
//        if (currentShark.getEnergy() == 0 && neighborsEmpty.size() > 0) {
//            nextGrid.setCellState(neighborsEmpty.get(0).getRow(), neighborsEmpty.get(0).getColumn(), 0);
//        }
//        // else if the shark ran out of energy but didn't move, set it to empty water space
//        else if (currentShark.getEnergy() == 0 && neighborsEmpty.isEmpty()) {
//            nextGrid.setCellState(cell.getRow(), cell.getColumn(), 0);
//        }
//        else if (currentShark.getEnergy() != 0){ // if shark didn't run out of energy, increase the time survived by 1
//            // increase the time survived for the shark by 1
//            ((WaTorCell) cell).getAnimal().setTimeSurvived(((WaTorCell) cell).getAnimal().getTimeSurvived() + 1);
//
//            // reproduce a new shark if the shark has survived for "reproductionTime" amount of time
//            if (((WaTorCell) cell).getAnimal().getTimeSurvived() == reproductionTime) {
//                nextGrid.setCell(cell.getRow(), cell.getColumn(),
//                        new WaTorCell(cell.getRow(),cell.getColumn(),
//                                getGrid().getCellState(cell.getRow(),cell.getColumn()), new Shark(initEnergy)));
//            }
//        }
//    }


}
