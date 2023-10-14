/**
 * A basic implementation of ....
 *
 * @author Lydia Ye
 */

public class AACMappings {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+


  
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new empty category with the given name
   */
  public AACMappings(String name) {
    //STUB
  } // AACMappings()

  // +------------------+--------------------------------------------
  // | Standard methods |
  // +------------------+

  /*
   * Given the image location selected, it determines the associated text with 
   * the image. If the image provided is a category, it also updates the AAC's 
   * current category to be the category associated with that image.
   */
  public String getText(String imageLoc) {
    return ""; //STUB
  } // getText()

  /*
   * Provides as array of all the images in the current category.
   */
  public String[] getImagesLocs() {
    return ""; //STUB
  } // getImageLocs()

  /*
   * Resets the current categroy of the AAC back to the default category.
   */
  public void reset() {
    return;
  } // reset()

  /*
   * Gets the current category.
   * Returns the current category or the empty string if on the default category.
   */
  public String getCurrentCategory() {
    return ""; //STUB
  } // getCurrentCategory()

  /*
   * Determines if the image represents a category or text to speak.
   */
  public boolean isCategory(String imageLoc) {
    return true; //STUB
  } // isCategory()

  /*
   * 
   */
  public void writeToFile(String filename) {
    return; //STUB
  } //writeToFile(String)

  /*
   * Adds the mapping to current category (or the default category if that is 
   * the current category).
   */
  public void add(String imageLoc, String text) {
    return; //STUB
  } // add(String, String)
} // class AACMappings

