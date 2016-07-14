package jp.co.ui2.client;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import jp.co.ui2.shared.OrderConfirmation;
import jp.co.ui2.shared.PizzaOrder;
import jp.co.ui2.shared.Topping;

/**
 * Path Annotation は gwt.xml の &lt;servlet&gt; に合わせる
 * 
 * @author hideki.narita@ui2.co.jp
 *
 */
@Path("/pizza-service")
public interface PizzaService extends RestService {

  @POST public void order(PizzaOrder request, MethodCallback<OrderConfirmation> callback);

  @Path("/toppings")
  @Produces(MediaType.APPLICATION_JSON)
  @GET public void listToppings(MethodCallback<List<Topping>> callback);
  
  @Path("/ping")
  @DELETE public void ping(MethodCallback<java.lang.Void> callback);
}
