package skyline;

/**
* Class that represents a key point of a skyline.
* The skyline should be represented as a list of "key points" sorted by their 
* x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left
*  endpoint of some horizontal segment in the skyline except the last point in 
*  the list, which always has a y-coordinate 0 and is used to mark the skyline's 
*  termination where the rightmost building ends
*/
public class KeyPoint {
	
  private int xCoord;
  private int yCoord;

  /**
  * Default constructor.
  */
  public KeyPoint() {
    xCoord = 0;
    yCoord = 0;
  }

  /**
   * Constructs a KeyPoint with specified coordinates.
   * @param x The x-coordinate of the key point.
   * @param y The y-coordinate (height) of the key point.
   */
  public KeyPoint(int x, int y) {
    xCoord = x;
    yCoord = y;
  }

 
  public int getX() {
    return xCoord;
  }

  
  public int getY() {
    return yCoord;
  }

  

  /**
   * Compares this KeyPoint with another object for equality.
   * Two KeyPoint instances are considered equal if they have the same x and y coordinates.
   *
   * @param obj The object to compare with this KeyPoint.
   * @return {@code true} if the given object is a KeyPoint with the same coordinates, {@code false} otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    KeyPoint st = (KeyPoint)obj;
    return (this.getX() == st.getX()) && (this.getY() == st.getY());
  }

  /**
  * Converts the current object to a String.
  * @return The Object as a String.
  */
  @Override
  public String toString() {
    return "(" + this.getX() + "," + this.getY() + ")";
  }
}
