import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Amelia Vrieze
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void emptyArrayTest() {
    String[] original = {};
    String[] expected = {};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }

  @Test 
  public void sortReversedIntsTest() {
    Integer[] original = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }

  @Test 
  public void sortOneElement() {
    Integer[] original = {1};
    Integer[] expected = {1};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }

  @Test
  public void randomArraySort() {
    Integer[] randArr = new Integer[20];
    for (int i = 0; i < 20; i++) {
      randArr[i] = (int)(Math.random() * 20);
    }
    sorter.sort(randArr, (x, y) -> x.compareTo(y));
    boolean sorted = true;
    for (int i = 0; i < randArr.length - 1; i++) {
      if (randArr[i] > randArr[i + 1]) {
        sorted = false;
      }
    }
    assertEquals(sorted, true);
  }

  //Test 5
  @Test
  public void bigArraySort() {
    Integer[] bigArray = new Integer[1000];
    Integer[] expected = new Integer[1000];
    for (int i = 0; i < 1000; i++) {
      bigArray[i] = 1000 - i;
    }
    for (int i = 1; i < 1001; i++) {
      expected[i - 1] = i;
    }
    sorter.sort(bigArray, (x,y) -> x.compareTo(y));
    assertArrayEquals(bigArray, expected);
  }


} // class SortTester
