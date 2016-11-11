package ui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import grid.GridException;

public class ControllerTest {

  Controller controller;

  @Before
  public void setUp() throws Exception {
    controller = new Controller();
  }

  @Test
  public void testValidateInput() {
    String instruction = "5,5:RFLFRFLF";
    assertTrue(controller.validateInput(instruction));
    instruction = "15,15:RRRRRRR";
    assertTrue(controller.validateInput(instruction));
    instruction = "5,5:XFLFRFLF";
    assertFalse(controller.validateInput(instruction));
    instruction = "0,0:FLFRFLF";
    assertFalse(controller.validateInput(instruction));
    instruction = "abcde";
    assertFalse(controller.validateInput(instruction));
    instruction = ".";
    assertFalse(controller.validateInput(instruction));
    instruction = "x";
    assertFalse(controller.validateInput(instruction));
    instruction = "1,1:FFFFFFFFFFFFFFFFFF";
    assertTrue(controller.validateInput(instruction));
  }

  @Test
  public void testExecuteInstructionValid() {
    try {
      String output = controller.executeInstruction("5,5:RFLFRFLF");
      assertEquals("The new positioni is: row= 7 - column= 7", output);
      output = controller.executeInstruction("6,6:FFLFFLFFLFF");
      assertEquals("The new positioni is: row= 6 - column= 6", output);
      output = controller.executeInstruction("5,5:FLFLFFRFFF");
      assertEquals("The new positioni is: row= 4 - column= 1", output);
    }
    catch (GridException e) {
      e.printStackTrace();
    }
  }

  @Test(expected = GridException.class)
  public void testExecuteInstructionInValid() throws GridException {
    controller.executeInstruction("5,5:QFLFRFLF");
  }

}
