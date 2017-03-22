package markup;

public class Food extends ProductDecorator {

  public Food(Product item) {
    super(item);
  }

  @Override
  public double getMarkup() {
    return 0.13;
  }
}
