import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Amelia Vrieze
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    int pointer;
    for (pointer = 1; pointer < values.length; pointer++) {
      T current = values[pointer];
      int i = pointer - 1;
      while (i >=0 && order.compare(values[i], current) > 0) {
        values[i + 1] = values[i];
        values[i] = current;
        i--;
      }
    }
  } // sort(T[], Comparator<? super T>
} // class InsertionSort
