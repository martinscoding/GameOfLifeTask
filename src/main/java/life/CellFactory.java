package life;

/**
 * Fabrik zur Erstellung von Zellen im Spiel des Lebens.
 */
public class CellFactory {

    public static Cell createCell(int x, int y) {
        return new LifeCell(x, y);
    }
}
