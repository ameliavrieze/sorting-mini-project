import java.util.Comparator;


/**
 * A sorting method created by Amelia Vrieze. 
 * Decides whether to use InsertionSort, QuickSort, or return immediately 
 * depending on the size of the array to be sorted.
 * @author Amelia Vrieze
 * 
 */
public class VriezeAmeliaSort implements Sorter{
  public static Sorter SORTER = new VriezeAmeliaSort();

  public VriezeAmeliaSort(){}


   public <T> void sort(T[] values, Comparator<? super T> order){
    int size = values.length;
    if (size < 2) {
      return;
    }
    if (size < 20) {
      InsertionSort.SORTER.sort(values, order);
    } else {
      MergeSort.SORTER.sort(values, order);
    }

   }
  
}
