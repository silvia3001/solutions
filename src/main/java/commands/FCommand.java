/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.logging.Level;
import java.util.logging.Logger;

import car.Car;
import car.Direction;
import grid.Grid;

/**
 * Implementation of the Command interface that moves the car forward in the grid by 1 space.
 * The direction of movement depends on the direction the car is facing.
 */

public class FCommand implements Command {

  private static final Logger logger = Logger.getLogger(FCommand.class.getName());

  public void move(Car c) throws CommandException {
    Direction d = c.getD();
    switch (d) {
    case N:
      if (c.getY() + 1 > Grid.MAX_ROWS) {
        logger.log(Level.SEVERE, "Unable to move forward. Reached the " + Direction.N + " edge of the grid");
        throw new CommandException("Attempted to move outside the grid");
      }
      c.setY(c.getY() + 1);
      logger.log(Level.INFO, "Moved to (" + c.getY() + "," + c.getX() + ")");
      break;
    case E:
      if (c.getX() + 1 > Grid.MAX_COLUMNS) {
        logger.log(Level.SEVERE, "Unable to move forward. Reached the " + Direction.E + " edge of the grid");
        throw new CommandException("Attempted to move outside the grid");
      }
      c.setX(c.getX() + 1);
      logger.log(Level.INFO, "Moved to (" + c.getY() + "," + c.getX() + ")");
      break;
    case S:
      if (c.getY() - 1 < 1) {
        logger.log(Level.SEVERE, "Unable to move forward. Reached the " + Direction.S + " edge of the grid");
        throw new CommandException("Attempted to move outside the grid");
      }
      c.setY(c.getY() - 1);
      logger.log(Level.INFO, "Moved to (" + c.getY() + "," + c.getX() + ")");
      break;
    case W:
      if (c.getX() - 1 < 1) {
        logger.log(Level.SEVERE, "Unable to move forward. Reached the " + Direction.W + " edge of the grid");
        throw new CommandException("Attempted to move outside the grid");
      }
      c.setX(c.getX() - 1);
      logger.log(Level.INFO, "Moved to (" + c.getY() + "," + c.getX() + ")");
      break;
    default:
      break;
    }
  }
}
