import structures.AssociativeArray;
import structures.KVPair;

/**
 * A basic implementation of AACCategory which represents the mappings for a 
 * single page of items that should be displayed
 *
 * @author Lydia Ye
 */

public class AACCategory {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * Name of the category
   */
  String name;

  /**
   * A complete set of AAC mappings that map the images on the home page to 
   * the AACCategories
   */
  AssociativeArray<String, String> mappings;

  
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new empty category with the given name
   */
  public AACCategory(String name) {
    this.name = name;
    this.mappings = new AssociativeArray<String, String>();
  } // AACCategory(String)

  // +------------------+--------------------------------------------
  // | Standard methods |
  // +------------------+

  /*
   * Adds the mapping of the imageLoc to the text of the category.
   */
  public void addItem(String imageLoc, String text) {
    // add the mapping between given imageLoc and text
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
    // did not check whether the given imageLoc is existed in the mappings
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
    KVPair<String, String>[] pairs = this.mappings.pairs;
    for (int i = 0; i < this.mappings.size(); i++) {
      imageArr[i] = pairs[i].key();
    } // for
    return imageArr; 
  } // getImages()
} // class AACCategory

