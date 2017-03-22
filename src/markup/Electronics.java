package markup;

public class Electronics extends ProductDecorator {
  private String name;

public Electronics(Product item) {
    super(item);
  }

  @Override
  public double getMarkup() {
    return item.getMarkup() + 0.02;
  }
  
}
