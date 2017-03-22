package markup;

public class Food extends ProductDecorator {

  public Food(Product item) {
    super(item);
  }

  @Override
  public double getMarkup() {
    return item.getMarkup() + 0.13;
  }
}
