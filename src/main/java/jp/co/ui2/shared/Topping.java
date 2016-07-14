package jp.co.ui2.shared;

import lombok.ToString;

@ToString
public class Topping {

  public final String name;
  public final Double price;
  
  public Topping() {
    this.name  = "";
    this.price = 0.0;
  }

  public Topping(final String name, final Double price) {
    this.name  = name;
    this.price = price;
  }
}
