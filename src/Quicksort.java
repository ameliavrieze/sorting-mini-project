import java.util.Comparator;

/**
 * Sort using Quicksort.
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
    int pivIndx = (int) (Math.random() * (values.length));
    T pivVal = values[pivIndx];
    values[pivIndx] = values[0];
    values[0] = pivVal;
    int lb = 1; 
    int ub = values.length;
    while (lb < ub) {
      while (order.compare(values[lb], pivVal) < 0) {
        lb++;
      } 
      while (order.compare(values[ub - 1], pivVal) > 0) {
        ub--;
      }
      T temp = values[lb];
      values[lb] = values[ub];
      values[ub] = temp;
      for (int i = 0; i < values.length; i++) {
        System.out.println(values[i]);
      }
      System.out.println("---");
    }
    values[0] = values[lb - 1];
    values[lb - 1] = pivVal;
    sortHelper(1, lb - 1, values, order);
    sortHelper(lb, values.length, values, order);

    // STUB
  } // sort(T[], Comparator<? super T>

  public <T> void sortHelper(int lo, int hi, T[] values, Comparator<? super T> order) {
    int pivIndx = (int) (Math.random() * (hi - lo) + lo);
    T pivVal = values[pivIndx];
    values[pivIndx] = values[lo];
    values[lo] = pivVal;
    int lb = lo + 1; 
    int ub = hi;
    while (lb < ub) {
      while (order.compare(values[lb], pivVal) < 0) {
        lb++;
      } 
      ub--;
      T temp = values[lb];
      values[lb] = values[ub];
      values[ub] = temp;
      for (int i = 0; i < values.length; i++) {
        System.out.println(values[i]);
      }
      System.out.println("---");
    }
    values[lo] = values[lb - 1];
    values[lb - 1] = pivVal;
    if (hi - lo > 1) {
      sortHelper(lo + 1, lb - 1, values, order);
      sortHelper(lb, hi, values, order);
    }

  }



  public <T> void partition(T[] values, Comparator<? super T> order) {
    int pivot = partition(values, order, 0, values.length);
    
  } // partition(T[], Comparator<? super T>)

  public static <T> int partition(T[] values, Comparator<? super T> order, int lo, int hi) {
    
    int pivIndx = (int) (Math.random() * (hi - lo) + lo);
    T pivVal = values[pivIndx];
    values[pivIndx] = values[lo];
    values[lo] = pivVal;
    int lb = lo + 1; 
    int ub = hi;
    while (lb < ub) {
      while (order.compare(values[lb], pivVal) < 0) {
        lb++;
      } 
      while (order.compare(values[ub - 1], pivVal) > 0) {
        ub--;
      }
      T temp = values[lb];
      values[lb] = values[ub];
      values[ub] = temp;
    }
    values[lo] = values[ub - 1];
    values[ub - 1] = pivVal;
    for (int i = 0; i < values.length; i++) {
      System.out.println(values[i]);
    }
    System.out.println("---");
    return pivIndx;
    // STUB
  } // partition(T[], Comparator<? super T>, lb, ub)


} // class Quicksort
