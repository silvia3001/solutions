package car;

/**
 * Car to be placed on the grid.
 */
public class Car {

  /**
   * x coordinate. Corresponds to the column number in the grid.
   */
  private int x;

  /**
   * y coordinate. Corresponds to the row number in the grid.
   */
  private int y;

  /**
   * The direction in which the car is oriented: N, E, S or W.
   */
  private Direction d;

  public Car() {
    this(1, 1);
  }

  public Car(int x, int y) {
    this(x, y, Direction.N);
  }

  public Car(int x, int y, Direction d) {
    this.x = x;
    this.y = y;
    this.d = d;
  }

  /** GETTERS AND SETTERS */

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Direction getD() {
    return d;
  }

  public void setD(Direction d) {
    this.d = d;
  }
}
