package structures;

/**
 * Exceptions that indicate that a key is not in an associative array
 * (dictionary, map, etc.).
 *
 * @author Samuel A. Rebelsky
 */
public class KeyNotFoundException extends Exception {
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new exception.
   */
  public KeyNotFoundException() {
    super("key not found");
  } // KeyNotFoundException()

  /**
   * Create a new exception with a particular message.
   */
  public KeyNotFoundException(String message) {
    super(message);
  } // KeyNotFoundException(String)
} // KeyNotFoundException
