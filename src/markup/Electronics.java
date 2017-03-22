package markup;

public class Electronics extends ProductDecorator {
  public Electronics(Product item) {
    super(item);
  }

  @Override
  public double getMarkup() {
    return 0.02;
  }
}
