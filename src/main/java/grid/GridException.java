package grid;

public class GridException extends Exception {

  private static final long serialVersionUID = 1L;

  public GridException() {
  }

  public GridException(String message) {
    super(message);
  }

  public GridException(Throwable cause) {
    super(cause);
  }

  public GridException(String message, Throwable cause) {
    super(message, cause);
  }

}
