package markup;

public class ProductDecorator implements Product {

  protected Product item;
  
  public ProductDecorator(Product item) {
    this.item = item;
  }

  public double getMarkup() {
    return item.getMarkup();
  }
}
