package commands;

import static org.junit.Assert.assertEquals;
import car.Car;
import car.Direction;
import commands.Command;
import commands.CommandException;
import commands.RCommand;

import org.junit.Before;
import org.junit.Test;

public class RCommandTest {

  Command command;
  Car car;

  @Before
  public void setUp() throws Exception {
    command = new RCommand();
    car = new Car();
  }

  @Test
  public void testMove() throws CommandException {
    car.setD(Direction.N);
    command.move(car);
    assertEquals(Direction.E, car.getD());
    command.move(car);
    assertEquals(Direction.S, car.getD());
    command.move(car);
    assertEquals(Direction.W, car.getD());
  }

}
