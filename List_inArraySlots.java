/**
  Implement a list of integer elements, including
  both data and operations.
 */

public class List_inArraySlots {

  // declare fields here
  private int[] array;
  private int filledElements;

  /**
    Construct an empty list with a small initial capacity.
  */
  public List_inArraySlots() {
	array = new int[8];
  }

  /**
    @return the number of elements in this list
  */
  public int size() {
	return filledElements;
  }

  /**
    @return a string representation of this list,
    in [a,b,c,] format
  */
  public String toString() {
	String ans = new String();
	ans += "[";
	for (int element : array)
		ans += element + ",";
	ans += "]";
	return ans;
  }

  /**
    Appends @value to the end of this list.

    @return true, in keeping with conventions yet to be discussed
  */
  public boolean add( int value) {
	if (filledElements >= array.length)
		expand();
    array[filledElements++] = value;
    return true;
  }

  /**
    Double the capacity of the List_inArraySlots,
    preserving existing data
  */
  private void expand() {
    // System.out.println( "expand... (for debugging)");
    int[] temp = array;
	array = new int[temp.length * 2];
	for (int i = 0; i < temp.length; i++)
		array[i] = temp[i];
  }
}
