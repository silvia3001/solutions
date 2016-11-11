package grid;

import static org.junit.Assert.assertEquals;
import grid.GridException;
import grid.RemoteControl;

import org.junit.Before;
import org.junit.Test;

public class RemoteControlTest {

  RemoteControl remoteControl;

  @Before
  public void setUp() throws Exception {
    remoteControl = new RemoteControl();
  }

  @Test
  public void testSetBeginXWithinGrid() throws GridException {
    remoteControl.setBeginX(1);
    assertEquals(1, remoteControl.getBeginX());
    remoteControl.setBeginX(7);
    assertEquals(7, remoteControl.getBeginX());
  }

  @Test(expected = GridException.class)
  public void testSetBeginXOutsideOfGrid() throws GridException {
    remoteControl.setBeginX(16);
  }

  @Test
  public void testSetBeginYWithinGrid() throws GridException {
    remoteControl.setBeginY(1);
    assertEquals(1, remoteControl.getBeginY());
    remoteControl.setBeginY(8);
    assertEquals(8, remoteControl.getBeginY());
  }

  @Test(expected = GridException.class)
  public void testSetBeginYOutsideOfGrid() throws GridException {
    remoteControl.setBeginY(0);
  }

  @Test
  public void testSetCommandsValid() throws GridException {
    remoteControl.setCommands("RFLFFFRL".toCharArray());
    assertEquals("RFLFFFRL".toCharArray()[0], remoteControl.getCommands()[0]);
    assertEquals("RFLFFFRL".toCharArray()[4], remoteControl.getCommands()[4]);
  }

  @Test(expected = GridException.class)
  public void testSetCommandsInValid() throws GridException {
    remoteControl.setCommands("RFLFAFRL".toCharArray());
  }

}
