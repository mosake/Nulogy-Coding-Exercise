package markup;

/**
 * Product decorator (just in case of multiple product types).
 * @author Kelly Mo
 */

public class ProductDecorator implements Product {

  protected Product item;
  
  public ProductDecorator(Product item) {
    this.item = item;
  }

  public double getMarkup() {
    return item.getMarkup();
  }
}
