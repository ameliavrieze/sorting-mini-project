import java.util.Comparator;


/**
 * A sorting method created by Amelia Vrieze
 * @author Amelia Vrieze
 * 
 */
public class VriezeAmeliaSort implements Sorter{

  public VriezeAmeliaSort(){}


   public <T> void sort(T[] values, Comparator<? super T> order){
    int size = values.length;
    if (size < 2) {
      return;
    }
    if (size < 10) {
      InsertionSort.SORTER.sort(values, order);
    } else {
      MergeSort.SORTER.sort(values, order);
    }

   }
  
}
