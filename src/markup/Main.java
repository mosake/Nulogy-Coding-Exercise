package markup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
  
  private Map<String, List<String>> materials = new HashMap<String, List<String>>();
  
  // add new string references here
  private List<String> foodWords = new ArrayList<String>(Arrays.asList("food"));
  private List<String> pharmaWords = new ArrayList<String>(Arrays.asList("drugs"));
  private List<String> electWords = new ArrayList<String>(Arrays.asList("electronics"));

  /** Initializes the Main class.
   * this.materials contains the string references to the type of material used
   *  A map with dynamically sized list in case additional mark up materials are added
   *    key: type of material
   *    value: string list of keywords
   * i.e
   *   pharmaceuticals -> drugs
   *   food -> food
   *   electronics -> electronics
   * new strings can be added in the constants above
   */
  public Main() {
    this.materials.put("pharmaceuticals" , pharmaWords);
    this.materials.put("food" , foodWords);
    this.materials.put("electronics" , electWords);
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
    String in = args[0];
    if (args.length != 0) {
      List<String> input = new ArrayList<String>(Arrays.asList(in.split(", ")));
      
      // format base number to double
      double base = Double.parseDouble(input.get(0).replace("$", "").replace(",", ""));
      input.remove(0);
      
      // format number of people to an int, extract int using first three chars and regex
      int numPeople = Integer.parseInt(input.get(0).substring(0,3).replaceAll("[^0-9]", ""));
      input.remove(0);
      
      // format mark up type as a list in case of multiple inputs
      List<String> type = input;
    }
  }
}
