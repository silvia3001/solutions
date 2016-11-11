package grid;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents the remote control to the cars on a grid problem.
 */
public class RemoteControl {

  /**
   * List of available commands for the current implementation.
   */
  public static List<Character> commandTypes = Arrays.asList('F', 'L', 'R');

  /**
   * x coordinate of the initial position of the car on the grid.
   */
  private int beginX;

  /**
   * y coordinate of the initial position of the car on the grid.
   */
  private int beginY;

  /**
   * Commands issued to the car.
   */
  private char[] commands;

  private static final Logger logger = Logger.getLogger(RemoteControl.class.getName());

  public int getBeginX() {
    return beginX;
  }

  public void setBeginX(int beginX) throws GridException {
    if (beginX < 1 || beginX > Grid.MAX_COLUMNS) {
      logger.log(Level.SEVERE, "Invalid column number. The car can only be positioned" +
          " between columns 1 and " + Grid.MAX_COLUMNS);
      throw new GridException("Invalid starting position");
    }
    this.beginX = beginX;
  }

  public int getBeginY() {
    return beginY;
  }

  public void setBeginY(int beginY) throws GridException {
    if (beginY < 1 || beginY > Grid.MAX_ROWS) {
      logger.log(Level.SEVERE, "Invalid row number. The car can only be positioned" +
          " between rows 1 and " + Grid.MAX_ROWS);
      throw new GridException("Invalid starting position");
    }
    this.beginY = beginY;
  }

  public char[] getCommands() {
    return commands;
  }

  public void setCommands(char[] commands) throws GridException {
    for(int i = 0; i < commands.length; i++){
      if (!commandTypes.contains(commands[i])) {
        logger.log(Level.SEVERE, "Invalid Command. The only available commands are  " + commandTypes.toString());
        throw new GridException("Invalid Command");
      }
    }
    this.commands = commands;
  }
}
