package car;

import static org.junit.Assert.assertSame;
import car.Direction;

import org.junit.Before;
import org.junit.Test;

public class DirectionTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testTurnRight() {
    assertSame(Direction.E, Direction.N.turnRight());
    assertSame(Direction.S, Direction.E.turnRight());
    assertSame(Direction.W, Direction.S.turnRight());
    assertSame(Direction.N, Direction.W.turnRight());
  }

  @Test
  public void testTurnLeft() {
    assertSame(Direction.N, Direction.E.turnLeft());
    assertSame(Direction.E, Direction.S.turnLeft());
    assertSame(Direction.S, Direction.W.turnLeft());
    assertSame(Direction.W, Direction.N.turnLeft());
  }

}
