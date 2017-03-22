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
    this.markup = 0.05;
    this.numWorkers = workers;
    this.basePrice = base;
    this.product = item;
  }

  public double getMarkup() {
    this.markup += this.product.getMarkup();
    return (this.markup + this.numWorkers * 0.012);
  }

  public double calcCost() {
    return this.basePrice + (this.basePrice * getMarkup());
  }
  
  @Override
  public String toString() {
    return (String.format("$%,.2f", calcCost()));
  }
}
