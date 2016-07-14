package jp.co.ui2.shared;

import java.util.ArrayList;
import java.util.List;

import org.fusesource.restygwt.client.Json;
import org.fusesource.restygwt.client.JsonEncoderDecoder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gwt.core.client.GWT;


public class PizzaOrder {

  public String phone_number;
  public boolean delivery;
  
  @Json(name="delivery-address")
  @JsonProperty("delivery-address")
  public List<String> delivery_address = new ArrayList<String>(4);

  public List<Pizza> pizzas = new ArrayList<Pizza>(10);

  /**
   * Example of how to create an instance of a JsonEncoderDecoder for a data
   * transfer object.
   */
  public interface PizzaOrderJED extends JsonEncoderDecoder<PizzaOrder> {
  }

  @Override
  public String toString() {
    if (GWT.isClient()) {
      PizzaOrderJED jed = GWT.create(PizzaOrderJED.class);
      return jed.encode(this).toString();
    }
    return super.toString();
  }
}