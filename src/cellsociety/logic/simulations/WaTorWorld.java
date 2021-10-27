package cellsociety.logic.simulations;

import cellsociety.errors.MissingSimulationArgumentError;


import cellsociety.logic.grid.Cell;
import cellsociety.logic.grid.Grid;
import cellsociety.logic.grid.WaTorCell;
import cellsociety.logic.grid.*;

import java.util.*;

public class WaTorWorld extends Simulation {

    private int[][] originalGrid;
    private int energy;
    private int reproductionTime;

    public WaTorWorld(int[][] grid, Map<String, String> metadata) throws MissingSimulationArgumentError {
        super(grid, metadata);
        originalGrid = grid;
        energy = Integer.parseInt(metadata.get("Energy"));
        reproductionTime = Integer.parseInt(metadata.get("ReproductionTime"));
        changeToWatorCells(); // changes the grid to use WaTorCells instead of regular Cells
    }

    private void changeToWatorCells() {
        // setting the cells with '1' to a WaTorCell w/ a Fish object and the cells with '2' to a WaTorCell w/ a Shark object
        for (int r = 0; r < getGrid().getHeight(); r++) {
            for (int c = 0; c < getGrid().getWidth(); c++) {
                if (getGrid().getCell(r,c).getState() == 1) { // if the cell's state is a 1 (meaning it's a fish)
                    getGrid().setCell(r, c, new WaTorCell(r,c,getGrid().getCellState(r,c), new Fish()));
                }
                else if (getGrid().getCell(r,c).getState() == 2) { // if the cell's state is a 2 (meaning it's a shark)
                    getGrid().setCell(r, c, new WaTorCell(r,c,getGrid().getCellState(r,c), new Shark(energy)));
                }
            }
        }
    }

    @Override
    protected void updateNextGridFromCell(Cell cell) {
        // if the cell right now is just water, or if the original cell was just water, do nothing
        if (cell.getState() == 0 || originalGrid[cell.getRow()][cell.getColumn()] == 0) {
            return;
        } else if (cell.getState() == 1) { // if the cell is a fish
            // increase the time survived for the fish by 1
            ((WaTorCell) cell).getAnimal().setTimeSurvived(((WaTorCell) cell).getAnimal().getTimeSurvived() + 1);

            List<Cell> neighbors = currentGrid.getNeighbors_Four(cell);
            neighbors.removeIf(e->e.getState() == 1 || e.getState() == 2); // find only the empty water around the fish

            // moves the fish if it can move
            moveFish(neighbors, cell);

        } else if (cell.getState() == 2) { // if the cell is a shark
            List<Cell> neighborsFish = currentGrid.getNeighbors_Four(cell);
            neighborsFish.removeIf(e->e.getState() == 0 || e.getState() == 2); // find only the fish around the shark

            // if there are no fish around the shark, look for empty water
            List<Cell> neighborsEmpty = currentGrid.getNeighbors_Four(cell);
            neighborsEmpty.removeIf(e->e.getState() == 1 || e.getState() == 2); // find the empty water around the shark

            // eats a fish, if it can, or moves to empty water spot
            eatFishOrMove(neighborsFish, neighborsEmpty, cell);

            Shark currentShark = ((Shark) ((WaTorCell) cell).getAnimal());

            // shark loses one unit of energy every tick of the program
            currentShark.setEnergy(currentShark.getEnergy() - energy);

            // updates the shark based on how much energy it has
            checkEnergy(currentShark, neighborsEmpty, cell);
        }
    }

    private void moveFish(List<Cell> neighbors, Cell cell) {
        if (neighbors.size() > 0) { // if there is a (water) spot for the fish to move
            // first, figure out where to move the fish (random spot from the adjacent water spots)
            Collections.shuffle(neighbors);

            // move the fish to the spot identified
            currentGrid.setCell(neighbors.get(0).getRow(), neighbors.get(0).getColumn(), ((WaTorCell) cell));
            // sets the previous spot where the fish just was to empty water
            currentGrid.setCellState(cell.getRow(), cell.getColumn(), 0);

            // reproduce a new fish if the fish has survived for "reproductionTime" amount of time
            if (((WaTorCell) cell).getAnimal().getTimeSurvived() == reproductionTime) {
                currentGrid.setCell(cell.getRow(), cell.getColumn(),
                        new WaTorCell(cell.getRow(),cell.getColumn(),
                                getGrid().getCellState(cell.getRow(),cell.getColumn()), new Fish()));
            }
        }
    }

    private void eatFishOrMove(List<Cell> neighborsFish, List<Cell> neighborsEmpty, Cell cell) {
        if (neighborsFish.size() > 0) { // if there is a fish next to the shark
            // first, figure out which fish to eat
            Collections.shuffle(neighborsFish);

            // move the shark to the spot identified
            currentGrid.setCell(neighborsFish.get(0).getRow(), neighborsFish.get(0).getColumn(), ((WaTorCell) cell));
            // sets the previous spot where the shark just was to empty water
            currentGrid.setCellState(cell.getRow(), cell.getColumn(), 0);

            Shark currentShark = ((Shark) ((WaTorCell) cell).getAnimal());
            // increase the energy for the shark by "energy" amount
            currentShark.setEnergy(currentShark.getEnergy() + energy);
        }
        else if (neighborsEmpty.size() > 0) { // if there is an empty water spot next to the shark
            // first, figure out which water spot to move to
            Collections.shuffle(neighborsEmpty);

            // move the shark to the spot identified
            currentGrid.setCell(neighborsEmpty.get(0).getRow(), neighborsEmpty.get(0).getColumn(), ((WaTorCell) cell));
            // sets the previous spot where the shark just was to empty water
            currentGrid.setCellState(cell.getRow(), cell.getColumn(), 0);
        }
    }

    private void checkEnergy(Shark currentShark, List<Cell> neighborsEmpty, Cell cell) {
        // if the shark ran out of energy and moved, set it to empty water space
        if (currentShark.getEnergy() == 0 && neighborsEmpty.size() > 0) {
            currentGrid.setCellState(neighborsEmpty.get(0).getRow(), neighborsEmpty.get(0).getColumn(), 0);
        }
        // else if the shark ran out of energy but didn't move, set it to empty water space
        else if (currentShark.getEnergy() == 0 && neighborsEmpty.isEmpty()) {
            currentGrid.setCellState(cell.getRow(), cell.getColumn(), 0);
        }
        else { // if shark didn't run out of energy, increase the time survived by 1
            // increase the time survived for the shark by 1
            ((WaTorCell) cell).getAnimal().setTimeSurvived(((WaTorCell) cell).getAnimal().getTimeSurvived() + 1);

            // reproduce a new shark if the shark has survived for "reproductionTime" amount of time
            if (((WaTorCell) cell).getAnimal().getTimeSurvived() == reproductionTime) {
                currentGrid.setCell(cell.getRow(), cell.getColumn(),
                        new WaTorCell(cell.getRow(),cell.getColumn(),
                                getGrid().getCellState(cell.getRow(),cell.getColumn()), new Shark(energy)));
            }
        }
    }


}
