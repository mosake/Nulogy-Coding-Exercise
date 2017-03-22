package markup;

/**
 * Electronics concrete product type.
 * @author Kelly Mo
 */

public class Electronics extends ProductDecorator {

  public Electronics(Product item) {
    super(item);
  }

  @Override
  public double getMarkup() {
    return item.getMarkup() + 0.02;
  }
}
