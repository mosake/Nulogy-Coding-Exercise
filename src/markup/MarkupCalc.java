package markup;

public class MarkupCalc {
  private int numWorkers;
  private double markup;
  private double basePrice;
  private Product product;

  /**  Initializes the Mark up Calculator.
   * @param base cost original product
   * @param workers number of workers on the job
   */
  public MarkupCalc(double base, int workers, Product item) {
    this.markup = 0;
    this.numWorkers = workers;
    // "The flat markup is calculated first"
    this.basePrice = base + base*0.05;
    this.product = item;
  }

  public double markup() {
    this.markup = this.product.getMarkup();
    return (this.markup + (this.numWorkers * 0.012));
  }

  public double calcCost() {
    return this.basePrice + (this.basePrice * markup());
  }
  
  @Override
  public String toString() {
    return (String.format("$%,.2f", calcCost()));
  }
}
