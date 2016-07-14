package jp.co.ui2.shared;

import java.util.LinkedList;
import java.util.List;

import lombok.ToString;

@ToString
public class Pizza {
  public int quantity;
  public int size;
  public String crust;
  public List<String> toppings = new LinkedList<String>();
}
