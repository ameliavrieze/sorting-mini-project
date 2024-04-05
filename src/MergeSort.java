import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Amelia Vrieze
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sortHelper(0, values.length, values, order);
    merge(values, 0, values.length / 2, values.length, order);
  } // sort(T[], Comparator<? super T>





  public <T> void sortHelper(int lo, int hi, T[] values, Comparator<? super T> order) {
    int mid = (hi + lo) / 2;
    if (mid > lo) {
      sortHelper(lo, mid, values, order);
      merge(values, lo, (lo + mid) / 2, mid, order);
      sortHelper(mid, hi, values, order);
      merge(values, mid, (mid + hi) / 2, hi, order);
    } 
  }



  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    T[] scratch = vals.clone();
    int i = lo;
    int j = mid;
    for (int k = lo; k < hi; k++) {
      if (i >= mid) {
        for (k = k; k < hi; k++) {
          vals[k] = scratch[j++];
        }
      } else if (j >= hi) {
        for (k = k; k < hi; k++) {
          vals[k] = scratch[i++];
        }
      } else {
        if (comparator.compare(scratch[i], scratch[j]) < 0) {
          vals[k] = scratch[i];
          i++;
        } else {
          vals[k] = scratch[j];
          j++;
        }
      }
    }   
  } // merge



} // class MergeSort
