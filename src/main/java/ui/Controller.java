package ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import car.Car;
import commands.Command;
import commands.CommandException;
import commands.FCommand;
import commands.LCommand;
import commands.RCommand;
import grid.GridException;
import grid.RemoteControl;

public class Controller {

  private int row;

  private int column;

  private char[] commands;

  /**
   * Validates the user input. It takes a String and uses a regular expression to validate and extract the
   * required info: the row and column of the initial position and the set of commands to move the car.
   */
  public boolean validateInput(String s) {
    boolean isInputValid = false;
    Pattern p = Pattern.compile("[1-9][0-5]?,[1-9][0-5]?:[RLF]*");
    Matcher m = p.matcher(s);
    isInputValid = m.matches();
    return isInputValid;
  }

  /**
   * Once the user input has been validated, this method instantiates the car in the initial position and
   * executes the set of instructions given by the user.
   */
  public String executeInstruction(String instruction) throws GridException {
    String output = "";
    parseInstruction(instruction);
    Car car = new Car(row, column);
    RemoteControl remoteControl = new RemoteControl();
    remoteControl.setCommands(commands);
    Command command = null;
    for (char c : remoteControl.getCommands()) {
      switch (c) {
      case 'R':
        command = new RCommand();
        break;
      case 'L':
        command = new LCommand();
        break;
      case 'F':
        command = new FCommand();
        break;
      default:
        break;
      }
      if (command != null) {
        try {
          command.move(car);
        }
        catch (CommandException e) {
          e.getMessage();
        }
      }
    }
    output = "The new positioni is: row= " + car.getY() + " - column= " + car.getX();
    return output;
  }

  /**
   * Parses the user input String and extracts the 3 pieces of information required: row, column and commands.
   */
  private void parseInstruction(String instruction) {
    String coordinatesString = instruction.substring(0, instruction.indexOf(":"));
    String commandString = instruction.substring(instruction.indexOf(":") + 1);
    String[] coordinates = coordinatesString.split(",");
    row = Integer.parseInt(coordinates[0]);
    column = Integer.parseInt(coordinates[1]);
    commands = commandString.toCharArray();
  }
}
