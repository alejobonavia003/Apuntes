package skyline;

/**
 * Class representing a building in the Skyline problem.
 * A building is defined by its left side, right side, and height.
 * 
 * @author Agustín Borda
 * @author Vale Bengolea
 */

public class Building {
  private int left;
  private int right;
  private int heigth;

  /**
   * Constructs a Building with specified left side, right side, and height.
   * 
   * @param l The left side of the building.
   * @param r The right side of the building.
   * @param h The height of the building.
   */

  public Building(int l, int r, int h) {
    left = l;
    right = r;
    heigth = h;
  }

  /**
  * Returns the left side of the building.
  * 
  * @return The left side of the building.
  */
  public int left() {
    return left;
  }

  /**
   * Returns the right side of the building.
   * @return The right side of the building.
   */
  public int right() {
    return right;
  }

  
  /**
   * Returns the height of the building.
   * @return The height of the building.
   */
  public int height() {
    return heigth;
  }

 

}
