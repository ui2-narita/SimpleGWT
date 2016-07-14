package jp.co.ui2.shared;

import org.fusesource.restygwt.client.JsonEncoderDecoder;

import com.google.gwt.core.client.GWT;

public class OrderConfirmation {

  public long order_id;
  public PizzaOrder order;
  public double price;
  public Long ready_time;

  /**
   * Example of how to create an instance of a JsonEncoderDecoder for a data
   * transfer object.
   */
  public interface OrderConfirmationJED extends JsonEncoderDecoder<OrderConfirmation> {
  }

  @Override
  public String toString() {
    if (GWT.isClient()) {
      // Shows how to access the code generated json encoder/decoder.
      // Only works in client code, won't work on the server side.
      OrderConfirmationJED jed = GWT.create(OrderConfirmationJED.class);
      return jed.encode(this).toString();
    }
    return super.toString();
  }
}
