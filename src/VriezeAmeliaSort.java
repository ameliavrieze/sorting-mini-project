import java.util.Comparator;


/**
 * A sorting method created by Amelia Vrieze
 * @author Amelia Vrieze
 * 
 */
public class VriezeAmeliaSort implements Sorter{


   public <T> void sort(T[] values, Comparator<? super T> order){
    
    int[] timeout = new int[values.length];
    int j = 0;
    for (int i = 0; i < values.length; i++) {
      if (order.compare(values[i], values[i + 1]) > 0) {
        timeout[j] = i;
      }
    }
    for(int i = 0; i < j; i++) {
      
    }
   }
  
}
