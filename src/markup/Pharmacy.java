package markup;

public class Pharmacy extends ProductDecorator {

  public Pharmacy(Product item) {
    super(item);
  }

  @Override
  public double getMarkup() {
    return 0.075;
  }
}
