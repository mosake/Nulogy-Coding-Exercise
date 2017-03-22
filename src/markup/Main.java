package markup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Main class for MarkupCalc.
 * @author Kelly Mo
 */

public class Main {
  
  private Map<String, String> materials = new HashMap<String, String>();
  
  // add new string references here
  private List<String> foodWords = new ArrayList<String>(Arrays.asList("food", "apple"));
  private List<String> pharmaWords = new ArrayList<String>(Arrays.asList("drugs"));
  private List<String> electWords = new ArrayList<String>(Arrays.asList("electronics", 
          "TV", "phone"));

  /** Initializes the Main class.
   * this.materials contains the string references to the type of material used
   *  A map with dynamically sized list in case additional mark up materials are added
   *    key: type of material
   *    value: Product name of material
   * i.e
   *   Pharmacy <- drugs
   *   Food <- food
   *   Electronics <- electronics
   * new strings can be added in the constants above
   */
  public Main() {
    for (String temp : pharmaWords) {
      this.materials.put(temp, "Pharmacy");
    }
    for (String temp : foodWords) {
      this.materials.put(temp, "Food");
    }
    for (String temp : electWords) {
      this.materials.put(temp, "Electronics");
    }
  }
  
  /** Creates a new product with additional mark up categories.
   * The purpose of this is to have a product that will return 
   * the total additional mark ups on one product call.
   * New categories can be added here as an additional switch statement.
   * 
   * @param type list of mark up categories
   * @return Decorated Product
   */
  
  public Product makeProduct(List<String> type) {
    Product myProduct = new NoProductType();
    if (type != null) {
      for (String temp : type) {
        String typeProd = this.materials.get(temp);
        if (typeProd != null) {
          switch (typeProd) {
            case "Electronics":
              myProduct = new Electronics(myProduct);
              break;
            case "Food":
              myProduct = new Food(myProduct);
              break;
            case "Pharmacy":
              myProduct = new Pharmacy(myProduct);
              break;
            default:
              break;
          }  
        }
        
      }
    }
    return (myProduct);
  }
  
  /** White box testing
   * change vars:
   *   args.length == 0
   *   String in = "$1,299.99, 3 people, food";
   * add:
   *   System.out.println(base + "\t" + numPeople + "\t" +  input.toString());
   * expected output:
   *      1299.99    3   [food]

   */
  public static void main(String[] args) {
    if (args.length != 0) {
      String in = args[0];
      List<String> input = new ArrayList<String>(Arrays.asList(in.split(", ")));
      
      // format base number to double
      double base = Double.parseDouble(input.get(0).replace("$", "").replace(",", ""));
      input.remove(0);
      
      // format number of people to an int, extract int using first three chars and regex
      int numPeople = Integer.parseInt(input.get(0).substring(0,3).replaceAll("[^0-9]", ""));
      input.remove(0);
      
      // format mark up type as a list in case of multiple inputs
      List<String> type = new ArrayList<String>(input);
      Main myMain = new Main();
      Product myProduct = myMain.makeProduct(type);
      
      // set output
      MarkupCalc output = new MarkupCalc(base, numPeople, myProduct);
      
      // return output using stdout
      System.out.print(output);
    }
  }
}
