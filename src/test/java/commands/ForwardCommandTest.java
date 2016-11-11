package commands;

import static org.junit.Assert.assertEquals;
import car.Car;
import car.Direction;
import commands.Command;
import commands.CommandException;
import commands.FCommand;
import grid.Grid;

import org.junit.Before;
import org.junit.Test;

public class ForwardCommandTest {

  Command command;

  Car car;

  @Before
  public void setUp() throws Exception {
    command = new FCommand();
    car = new Car();
  }

  @Test
  public void testMoveFromOrigin() throws CommandException {
    command.move(car);
    assertEquals(2, car.getY());
    assertEquals(1, car.getX());
    car.setD(car.getD().turnRight());
    command.move(car);
    assertEquals(2, car.getY());
    assertEquals(2, car.getX());
    car.setD(car.getD().turnLeft());
    command.move(car);
    assertEquals(3, car.getY());
    assertEquals(2, car.getX());
  }

  @Test(expected = CommandException.class)
  public void testMoveBeyondNorthEdge() throws CommandException {
    car.setY(Grid.MAX_ROWS);
    car.setD(Direction.N);
    command.move(car);
  }

  @Test(expected = CommandException.class)
  public void testMoveBeyondSouthEdge() throws CommandException {
    car.setY(1);
    car.setD(Direction.S);
    command.move(car);
  }

  @Test(expected = CommandException.class)
  public void testMoveBeyondEastEdge() throws CommandException {
    car.setX(Grid.MAX_COLUMNS);
    car.setD(Direction.E);
    command.move(car);
  }

  @Test(expected = CommandException.class)
  public void testMoveBeyondWestEdge() throws CommandException {
    car.setX(1);
    car.setD(Direction.W);
    command.move(car);
  }

}
