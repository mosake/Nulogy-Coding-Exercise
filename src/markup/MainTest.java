package markup;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * JUnit test for Main.java's main method.
 * Catching stdout was annoying :(
 * @author Kelly Mo
 */

public class MainTest {
  // map of input strings and expected output strings
  private Map<String, String> tests = new HashMap<String, String>();
  
  /** Constructor for setting up the test map.
   */
  public MainTest() {
    this.tests.put("$1,299.99, 3 people, food", "$1,591.58");
    this.tests.put("$5,432.00, 1 person, drugs", "$6,199.81");
    this.tests.put("$12,456.95, 4 people, books", "$13,707.63");
  }
  
  @Test
  public void test() {
    // run all tests in map
    for (String i : this.tests.keySet()) {
      String input = i;
      final String output = this.tests.get(i);
      // toilet... to catch the pstream :P
      final ByteArrayOutputStream toilet = new ByteArrayOutputStream();

      // setup pstream to redirect stdout

      PrintStream pstream = new PrintStream(toilet);
      Main test = new Main();
      // save old stream + set as final to satisfy checkstyle
      final PrintStream old = System.out;
      // redirect output stream + return to normal
      System.setOut(pstream);
      Main.main(new String[] {input});
      System.out.flush();
      System.setOut(old);
      assertEquals(output, toilet.toString());
    }
  }
}
