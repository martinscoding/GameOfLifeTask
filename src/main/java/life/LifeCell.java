package life;

import java.util.ArrayList;
import java.util.List;

/**
 * Eine konkrete Zelle für Conways Spiel des Lebens.
 */
public class LifeCell implements Cell {

    private final int x;
    private final int y;
    private boolean alive;
    private boolean nextAlive;
    private final List<Cell> neighbours = new ArrayList<>();

    public LifeCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.alive = false;
        this.nextAlive = false;
    }

    @Override
    public void setupNeighbours(Cell[][] cellGrid) {
        neighbours.clear();
        int xMax = cellGrid.length;
        int yMax = cellGrid[0].length;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                int nx = x + dx;
                int ny = y + dy;
                if (nx >= 0 && nx < xMax && ny >= 0 && ny < yMax) {
                    neighbours.add(cellGrid[nx][ny]);
                }
            }
        }
    }

    @Override
    public void changeState() {
        this.alive = this.nextAlive;
    }

    @Override
    public void calculateNextState() {
        long aliveNeighbours = neighbours.stream().filter(Cell::isAlive).count();

        if (alive) {
            nextAlive = (aliveNeighbours == 2 || aliveNeighbours == 3);
        } else {
            nextAlive = (aliveNeighbours == 3);
        }
    }

    @Override
    public void beBorn() {
        this.alive = true;
        this.nextAlive = true;
    }

    @Override
    public void die() {
        this.alive = false;
        this.nextAlive = false;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public List<Cell> getNeighbours() {
        return neighbours;
    }
}
