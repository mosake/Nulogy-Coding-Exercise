package markup;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit testing for MarkupCalc.java.
 * @author Kelly Mo
 */

public class MarkupCalcTest {
  MarkupCalc calc = new MarkupCalc(1299.99, 3, new Food(new NoProductType()));
  
  @Test
  public void testMarkup() {
    assertEquals(0.166, calc.markup(), 0.00000001);
  }
  
  @Test
  public void calcCost() {
    assertEquals(1591.58, calc.calcCost(), 0.01);
  }
}
