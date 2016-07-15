package jp.co.ui2.shared;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.ToString;

@ToString
@Data @XmlRootElement
public class Pizza {
  public int quantity;
  public int size;
  public String crust;
  public List<String> toppings = new LinkedList<String>();
}
