package jp.co.ui2.server;

import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fusesource.restygwt.client.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.ui2.shared.OrderConfirmation;
import jp.co.ui2.shared.PizzaOrder;
import jp.co.ui2.shared.Topping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PizzaServlet extends HttpServlet {

  /** シリアル */
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    log.info("Processing Pizza Order...");

    try {
      ObjectMapper mapper = new ObjectMapper();
      PizzaOrder order = mapper.readValue(req.getInputStream(), PizzaOrder.class);

      StringWriter sw = new StringWriter();
      mapper.writeValue(sw, order);
      log.info("Request: {}", sw.toString());

      OrderConfirmation confirmation = new OrderConfirmation();
      confirmation.order_id = 123123;
      confirmation.order    = order;
      confirmation.price    = 27.54;
      confirmation.ready_time = System.currentTimeMillis() + 1000 * 60 * 30; // in  30 min.

      sw = new StringWriter();
      mapper.writeValue(sw, confirmation);
      log.info("Response: {}", sw.toString());

      resp.setContentType(Resource.CONTENT_TYPE_JSON);
      mapper.writeValue(resp.getOutputStream(), confirmation);
      log.info("Pizza Order Confirimed: {}", confirmation.toString());

    }
    catch (Throwable e) {
      e.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    log.info("Processing Toppings Listing");

    try {
      ObjectMapper mapper = new ObjectMapper();

      List<Topping> toppings = new LinkedList<Topping>();
      toppings.add(new Topping("pineapple", 0.50));
      toppings.add(new Topping("ham", 0.50));
      toppings.add(new Topping("peperoni", 0.50));

      StringWriter sw = new StringWriter();
      mapper.writeValue(sw, toppings);
      log.info("Response: {}", sw.toString());

      resp.setContentType(Resource.CONTENT_TYPE_JSON);
      mapper.writeValue(resp.getOutputStream(), toppings);

    }
    catch (Throwable e) {
        e.printStackTrace();
    }
  }

  protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info("Processing Ping");
  }

}
