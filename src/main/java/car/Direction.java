package car;

/**
 * Directions in which the cars can be moved on the grid.
 */
public enum Direction {
  N,
  E,
  S,
  W;

  /**
   * Returns the direction resulting when the car is turned clockwise.
   */
  public Direction turnRight() {
    return values()[(ordinal() + 1) % 4];
  }

  /**
   * Returns the direction resulting when the car is turned counterclockwise.
   */
  public Direction turnLeft() {
    return values()[(ordinal() + 3) % 4];
  }
}

