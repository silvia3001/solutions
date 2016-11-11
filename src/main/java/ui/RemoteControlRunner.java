package ui;

import java.util.Scanner;

import grid.GridException;

public class RemoteControlRunner {

  private static Scanner scanner;

public static void main(String args[]) {
    System.out.println("This is the interface to the cars on the grid problem.");
    System.out.println("Size of the grid: 15 by 15.");
    System.out
        .println("Set of commands available: F (forward), L (left), R (right). These must be in capital letters.");
    System.out.println("To move the car you need to enter the starting position on the grid and a sequence of");
    System.out.println("commands using this format: <row>,<column>:<commands>. Example: \"5,5:RFLFRFLF\"");

    Controller controller = new Controller();
    String userInput = "";
    boolean isValidInput = false;
    do {
      System.out.println("Please enter your instruction or Enter to exit: ");
      scanner = new Scanner(System.in);
      userInput = scanner.nextLine();
      isValidInput = controller.validateInput(userInput);
    }
    while (!isValidInput && !"".equals(userInput));

    try {
      if (isValidInput) {
        String response = controller.executeInstruction(userInput);
        System.out.println(response);
      }
      System.exit(0);
    }
    catch (GridException e) {
      e.getMessage();
    }
    finally {
      System.exit(1);
    }

  }

}
