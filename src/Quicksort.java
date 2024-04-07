import java.util.Comparator;

/**
 * Sort using Quicksort.
 * I couldn't make the indices math work for the "two-fingered approach" so I think this may be a 
 * "one-fingered" approach. 
 * Because of this and always choosing the first element as the pivot it probably doesn't
 * work as well as intended. 
 * I am now approaching 5 hours on this file alone so I decided at least it works now.
 *
 * @author Amelia Vrieze
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values.length < 2) {
      return;
    }
    int pivIn = partition(values, order, 0, values.length);
    sortHelper(0, pivIn, values, order);
    sortHelper(pivIn + 1, values.length, values, order);

  } // sort(T[], Comparator<? super T>

  public <T> void sortHelper(int lo, int hi, T[] values, Comparator<? super T> order) {
    if (lo < hi) {
      int pivIn = partition(values, order, lo, hi);
      sortHelper(lo, pivIn, values, order);
      sortHelper(pivIn + 1, hi, values, order);
    }

  }

  public static <T> int partition(T[] values, Comparator<? super T> order, int lo, int hi) {
    T pivot = values[lo];
    int lb = lo;
    for (int cursor = lo + 1; cursor < hi; cursor++) {
      if (order.compare(values[cursor], pivot) < 0) {
        lb++;
        T temp = values[lb];
        values[lb] = values[cursor];
        values[cursor] = temp;
      }
    }
    T temp = values[lb];
    values[lb] = values[lo];
    values[lo] = temp;
    return lb;
  } // partition(T[], Comparator<? super T>, lb, ub)

} // class Quicksort
