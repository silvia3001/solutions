package commands;

import car.Car;

/**
 * Interface for a Command class for the cars on a grid problem.
 * All implementations must provide a move method.
 */

public interface Command {
  public void move(Car c) throws CommandException;
}
