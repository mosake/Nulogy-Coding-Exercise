package markup;

/**
 * Pharmacutical concrete product type.
 * @author Kelly Mo
 */

public class Pharmacy extends ProductDecorator {

  public Pharmacy(Product item) {
    super(item);
  }

  @Override
  public double getMarkup() {
    return item.getMarkup() + 0.075;
  }
}
