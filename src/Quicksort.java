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
    if (values.length == 0) {
      return;
    }
    int pivIn = partition(values, order, 0, values.length);
    for (int i = 0; i < values.length; i++) {
      System.out.println(values[i]);
      if (i == pivIn) {
        System.out.println("<");
      }
    }
    System.out.println("---");
    sortHelper(0, pivIn - 1, values, order);
    for (int i = 0; i < values.length; i++) {
      System.out.println(values[i]);
      if (i == pivIn) {
        System.out.println("<");
      }
    }
    System.out.println("---");
    sortHelper(pivIn + 1, values.length, values, order);
    for (int i = 0; i < values.length; i++) {
      System.out.println(values[i]);
      if (i == pivIn) {
        System.out.println("<");
      }
    }
    System.out.println("---");
    // int pivIndx = (int) (Math.random() * (values.length));
    // T pivVal = values[pivIndx];
    // values[pivIndx] = values[0];
    // values[0] = pivVal;
    // int lb = 1; 
    // int ub = values.length - 1;
    // while (lb < ub) {
    //   System.out.println("Lower bound: " + lb);
    //   System.out.println("Upper bound: " + ub);
    //   while (lb < ub && order.compare(values[lb], pivVal) < 0) {
    //     lb++;
    //   } 
    //   while (lb < ub && order.compare(values[ub], pivVal) > 0) {
    //     ub--;
    //   }
    //   T temp = values[lb];
    //   values[lb] = values[ub];
    //   values[ub] = temp;
    //   for (int i = 0; i < values.length; i++) {
    //     System.out.println(values[i]);
    //   }
    //   System.out.println("---");
    // }
    // values[0] = values[lb - 1];
    // values[lb - 1] = pivVal;
    // sortHelper(0, lb - 1, values, order);
    // sortHelper(lb, values.length, values, order);

    // STUB
  } // sort(T[], Comparator<? super T>

  public <T> void sortHelper(int lo, int hi, T[] values, Comparator<? super T> order) {
    if (lo < hi) {
      int pivIn = partition(values, order, lo, hi);
      for (int i = 0; i < values.length; i++) {
        System.out.println(values[i]);
        if (i == pivIn) {
          System.out.println("<");
        }
      }
      System.out.println("---");
      sortHelper(lo, pivIn - 1, values, order);
      for (int i = 0; i < values.length; i++) {
        System.out.println(values[i]);
        if (i == pivIn) {
          System.out.println("<");
        }
      }
      System.out.println("---");
      sortHelper(pivIn + 1, hi, values, order);
      for (int i = 0; i < values.length; i++) {
        System.out.println(values[i]);
        if (i == pivIn) {
          System.out.println("<");
        }
      }
      System.out.println("---");
    }
    // int pivIndx = (int) (Math.random() * (hi - lo) + lo);
    // System.out.println("Pivot index: " + pivIndx);
    // T pivVal = values[pivIndx];
    // values[pivIndx] = values[lo];
    // values[lo] = pivVal;
    // int lb = lo + 1; 
    // int ub = hi;
    // while (lb < ub) {
    //   System.out.println("Lower bound: " + lb);
    //   System.out.println("Upper bound: " + ub);
    //   while (lb < hi && order.compare(values[lb], pivVal) < 0 ) {
    //     lb++;
    //   } 
    //   while (ub > lo && order.compare(values[ub], pivVal) > 0) {
    //     ub--;
    //   }
    //   T temp = values[lb];
    //   values[lb] = values[ub];
    //   values[ub] = temp;
    //   for (int i = 0; i < values.length; i++) {
    //     System.out.println(values[i]);
    //   }
    //   System.out.println("---");
    // }
    // values[lo] = values[lb - 1];
    // values[lb - 1] = pivVal;
    // if (hi - lo > 1) {
    //   sortHelper(lo + 1, ub - 1, values, order);
    //   sortHelper(ub, hi, values, order);
    // }

  }



  // public <T> void partition(T[] values, Comparator<? super T> order) {
  //   int pivot = partition(values, order, 0, values.length);
    
  // } // partition(T[], Comparator<? super T>)

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
    T temp = values[lb + 1];
    values[lb + 1] = values[lo];
    values[lo] = temp;
    return lb + 1;
    
    // int pivIndx = (int) (Math.random() * (hi - lo) + lo);
    // T pivVal = values[pivIndx];
    // values[pivIndx] = values[lo];
    // values[lo] = pivVal;
    // int lb = lo + 1; 
    // int ub = hi;
    // while (lb < ub) {
    //   while (order.compare(values[lb], pivVal) < 0) {
    //     lb++;
    //   } 
    //   while (order.compare(values[ub - 1], pivVal) > 0) {
    //     ub--;
    //   }
    //   T temp = values[lb];
    //   values[lb] = values[ub];
    //   values[ub] = temp;
    // }
    // values[lo] = values[ub - 1];
    // values[ub - 1] = pivVal;
    // for (int i = 0; i < values.length; i++) {
    //   System.out.println(values[i]);
    // }
    // System.out.println("---");
    // return pivIndx;
    // STUB
  } // partition(T[], Comparator<? super T>, lb, ub)


} // class Quicksort
