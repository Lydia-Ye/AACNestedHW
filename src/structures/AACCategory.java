package structures;
/**
 * A basic implementation of ....
 *
 * @author Lydia Ye
 */

public class AACCategory {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  String name;
  AssociativeArray<String, String> mappings;

  
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new empty category with the given name
   */
  public AACCategory(String _name) {
    this.name = _name;
    this.mappings = new AssociativeArray<String, String>();
  } // AACCategory()

  // +------------------+--------------------------------------------
  // | Standard methods |
  // +------------------+

  /*
   * Adds the mapping of the imageLoc to the text to the category.
   */
  public void addItem(String imageLoc, String text) {
    this.mappings.set(imageLoc, text);
    return;
  } // addItem(String, String)

  /*
   * Returns the name of the category.
   */
  public String getCategory() {
    return this.name; 
  } // getCategory()

  /*
   * Returns the text associated with the given image loc in this category.
   */
  public String getText(String imageLoc) throws Exception{
    return this.mappings.get(imageLoc); 
  } // getText()

  /*
   * Determines if the provided image is stored in the category.
   */
  public boolean hasImage(String imageLoc) {
    return this.mappings.hasKey(imageLoc); 
  } // hasImage()

  /*
   * Returns an array of all the images in the category.
   */
  public String[] getImages() {
    String[] imageArr = new String[this.mappings.size()];
    for (int i = 0; i < this.mappings.size(); i++) {
      imageArr[i] = this.mappings.pairs[i].key;
    } // for
    return imageArr; 
  } // getImages()
} // class AACCategory

