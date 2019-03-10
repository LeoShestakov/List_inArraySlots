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
	if (filledElements == array.length)
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
	
	// --------- end of "code that worked in v0" ---------
	
	/**
	accessor
	@return element @index from this list
	precondition: @index is within the bounds of the array.
		(Having warned the user about this precondition,
		you should NOT complicate your code to check
		whether user violated the condition.)
	*/
    public int get( int index ) {
		return array[index];
    }

    /**
    Set value at @index to @newValue

    @return old value at @index
    @precondition: @index is within the bounds of this list.
    */
    public int set( int index, int newValue ) {
		int oldValue = array[index];
		array[index] = newValue;
		return oldValue;
    }

    /**
    Insert @value at position @index in this list.

    Shift the element currently at that position (if any)
    and any subsequent elements to the right
    (that is, increase the index associated with each).
    */
    public void add( int index, int value) {
		int oldValue;
		int newValue = value;
		if (filledElements == array.length)
			expand();
		for (int i = index; i < size(); i++) {
			oldValue = array[i];
			array[i] = newValue;
			newValue = oldValue;
		}
    }

    /**
    Remove the element at position @index in this list.

    Shift any subsequent elements to the left (that is,
    decrease the index associated with each).

    @return the value that was removed from the list
    */
    public int remove( int index) {
		int i;
		int removed = array[index];
		for (i = index; i < size(); i++) {
			array[i] = array[i + 1];
		}
		array[i] = 0;
		return removed;
    }
}
