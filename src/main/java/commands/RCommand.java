/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.logging.Level;
import java.util.logging.Logger;

import car.Car;
import car.Direction;

/**
 * Implementation of the Command interface that moves the car in place changing its direction
 * clockwise by a 90 degree angle.
 */
public class RCommand implements Command {

  private static final Logger logger = Logger.getLogger(RCommand.class.getName());

public void move(Car c) {
    Direction d = c.getD();
    c.setD(d.turnRight());
    logger.log(Level.INFO, "Moved direction to " + c.getD());	
}


}
