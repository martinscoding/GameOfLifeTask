package life;

import java.util.List;

/**
 * Das Interface {@code Cell} beschreibt die grundlegenden Operationen einer
 * Zelle im Spiel des Lebens.
 */
public interface Cell {

	void setupNeighbours(Cell[][] cellGrid);

	void changeState();

	void calculateNextState();

	void beBorn();

	void die();

	boolean isAlive();

	int getX();

	int getY();

	List<Cell> getNeighbours();
}
