package structures;

import static java.lang.reflect.Array.newInstance;

/**
 * A basic implementation of Associative Arrays with keys of type K
 * and values of type V. Associative Arrays store key/value pairs
 * and permit you to look up values by key.
 *
 * @author Lydia Ye
 * @author Samuel A. Rebelsky
 */
public class AssociativeArray<K, V> {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The default capacity of the initial array.
   */
  static final int DEFAULT_CAPACITY = 16;

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The size of the associative array (the number of key/value pairs).
   */
  int size;

  /**
   * The array of key/value pairs.
   */
  public KVPair<K, V> pairs[];

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new, empty associative array.
   */
  @SuppressWarnings({ "unchecked" })
  public AssociativeArray() {
    // Creating new arrays is sometimes a PITN.
    this.pairs = (KVPair<K, V>[]) newInstance((new KVPair<K, V>()).getClass(),
        DEFAULT_CAPACITY);
    this.size = 0;
  } // AssociativeArray()

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /**
   * Create a copy of this AssociativeArray.
   */
  public AssociativeArray<K, V> clone() {
    AssociativeArray<K,V> copy = new AssociativeArray<K,V>();
    copy.pairs = this.pairs;
    copy.size = this.size;
    return copy;
  } // clone()

  /**
   * Convert the array to a string.
   */
  public String toString() {
    String AAStr = "";
    // this for loop turns every KV pairs in the associative array to an string
    for (int i = 0; i < this.pairs.length - 1; i++) {
      if (pairs[i] != null) {
        AAStr = AAStr + this.pairs[i].key.toString() + " : " + this.pairs[i].value.toString() + ", "; 
      } // if
    } // for 
    AAStr = AAStr.substring(0, AAStr.length() - 2);
    return "{" + AAStr + "}"; 
  } // toString()

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /**
   * Set the value associated with key to value. Future calls to
   * get(key) will return value.
   */
  public void set(K key, V value) {
    boolean hasFirstNull = false;
    int firstNullAt = 0;

    for (int i = 0; i < this.size; i++) {
      // check if key is already in the array
      if (this.pairs[i] == null) {
        if (hasFirstNull == false) {
          firstNullAt = i;
        hasFirstNull = true;
        } //
        i++;
      } else if (this.pairs[i].key == key) {
        this.pairs[i].value = value;
        return;
      // find the index of the first null if key is not in the array
      } // if
    } // for

    // put key and value in the position of first null if key is not already 
    // in the array
    this.pairs[firstNullAt] = new KVPair<K,V>(key, value);

    // inncrement size
    size++;

    return;
  } // set(K,V)

  /**
   * Get the value associated with key.
   *
   * @throws KeyNotFoundException
   *                              when the key does not appear in the associative
   *                              array.
   */
  public V get(K key) throws KeyNotFoundException {
    // Check if key is in the array; if yes, return the corresponding value
    for (int i = 0; i < this.size; i++) {
      if (this.pairs[i].key == key) {
        return this.pairs[i].value;
      } // if
    } // for

    // Throw exception if key is not found in array
    throw new KeyNotFoundException();
  } // get(K)

  /**
   * Determine if key appears in the associative array.
   */
  public boolean hasKey(K key) {
    for (int i = 0; i < this.size; i++) {
      // return true if key if found in the array
      if (this.pairs[i] == null) {
        i++;
      } else if (this.pairs[i].key == key) {
        return true;
      } // if
    } // for

    // return false if key is not found in the array
    return false; 
  } // hasKey(K)

  /**
   * Remove the key/value pair associated with a key. Future calls
   * to get(key) will throw an exception. If the key does not appear
   * in the associative array, does nothing.
   */
  public void remove(K key) {
    for (int i = 0; i < this.size; i++) {
      if (this.pairs[i] == null) {
        i++;
      } else if (this.pairs[i].key == key) {
        // if key is found in the array, then remove key and the corresponding 
        // value by setting them to null
        this.pairs[i] = null;
        return;
      } // if
    } // for

    // Do nothing if key is not found
    return;
  } // remove(K)

  /**
   * Determine how many values are in the associative array.
   */
  public int size() {
    return this.size;
  } // size()

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * Expand the underlying array.
   */
  public void expand() {
    this.pairs = java.util.Arrays.copyOf(this.pairs, this.pairs.length * 2);
  } // expand()

  /**
   * Find the index of the first entry in `pairs` that contains key.
   * If no such entry is found, throws an exception.
   */
  public int find(K key) throws KeyNotFoundException {
    for (int i = 0; i < size; i++) {
      if (this.pairs[i].key == key) {
        return i;
      } // if
    } // for
    throw new KeyNotFoundException(); 
  } // find(K)

} // class AssociativeArray
