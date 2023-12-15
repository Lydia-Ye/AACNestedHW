import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import structures.AssociativeArray;

/**
 * A basic implementation of ....
 *
 * @author Lydia Ye
 */

public class AACMappings {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * Stores the mappings between images and their corresponding categories
   */
  AACCategory categories;

  /**
   * Th category that is currently in
   */
  AACCategory currentCategory;



  /**
   * Stores the mappings betweeen categories' items and categories
   */
  AssociativeArray<String, AACCategory>  categoryMappings;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new empty category with the given name
   * @throws FileNotFoundException
   */
  public AACMappings(String filename) throws Exception {
    File inputFile = new File(filename);
    Scanner readInput = new Scanner(inputFile);
    String input = "";
    this.currentCategory = categories;

    while(readInput.hasNextLine()) {
      input = readInput.nextLine();
      String[] inputs = input.split(" ");

      if (input.charAt(0) != '>') {
        String categoryImg = inputs[0];
        String categoryName = inputs[1];
        // add a category to the home page
        this.categories.addItem(categoryImg, categoryName);
        // create a current category
        this.currentCategory = new AACCategory(categoryName);
        // add the maping between this category image and name to the category 
        // it belongs to
        this.categoryMappings.set(categoryImg, this.categories);
        this.categoryMappings.set(categoryName, this.categories);
      } else {
        String itemImg = inputs[0];
        String itemName = input.substring(inputs[0].length() + 1);
        // add the new item into current category
        currentCategory.addItem(itemImg, itemName);
        // add the mappings between the item imageLoc and the item name to the
        // catogory they belong to
        this.categoryMappings.set(itemImg, this.currentCategory);
        this.categoryMappings.set(itemName, this.currentCategory);
      } // if
    } // while

    readInput.close();
  } // AACMappings()

  // +------------------+--------------------------------------------
  // | Standard methods |
  // +------------------+

  /*
   * Given the image location selected, it determines the associated text with 
   * the image. If the image provided is a category, it also updates the AAC's 
   * current category to be the category associated with that image.
   */
  public String getText(String imageLoc) throws Exception {
    // if this is an image for a category
    if (this.categories.hasImage(imageLoc)){
      // get the category name
      String currentCategoryName = this.categories.getText(imageLoc);
      // update it to current category
      this.currentCategory = this.categoryMappings.get(imageLoc);
      return currentCategoryName;
    } else if (this.currentCategory.hasImage(imageLoc)) {
      // it this is an image for an item in the current category
      return this.currentCategory.getText(imageLoc);
    } else {
      throw new Exception("The image is not in the current category.");
    }// if
  } // getText()

  /*
   * Provides as array of all the images in the current category.
   */
  public String[] getImageLocs() {
    return this.currentCategory.getImages(); 
  } // getImageLocs()

  /*
   * Resets the current categroy of the AAC back to the default category.
   */
  public void reset() throws Exception {
    // reset the current category to the home category
    this.currentCategory = this.categories;
  } // reset()

  /*
   * Gets the current category.
   * Returns the current category or the empty string if on the default category.
   */
  public String getCurrentCategory() {
    return this.currentCategory.getCategory(); 
  } // getCurrentCategory()

  /*
   * Determines if the image represents a category or text to speak.
   */
  public boolean isCategory(String imageLoc) {
    // return true if the home category has contains the input image
    return this.categories.hasImage(imageLoc); 
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
    currentCategory.addItem(imageLoc, text);
  } // add(String, String)
} // class AACMappings

