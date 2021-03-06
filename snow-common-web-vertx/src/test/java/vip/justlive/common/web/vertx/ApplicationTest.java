package vip.justlive.common.web.vertx;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import io.vertx.core.Vertx;

/**
 * Test
 * 
 * @author wubo
 *
 */
public class ApplicationTest {

  @Test
  public void testRoute() throws InterruptedException {

    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(VerticleDemo.class.getName());

    TimeUnit.SECONDS.sleep(12);

    vertx.createHttpClient().get(8080, "localhost", "/demo/test/1000?request=path")
        .putHeader("header", "true").handler(res -> {
          res.bodyHandler(System.out::println);
        }).exceptionHandler(System.out::println).end();

    TimeUnit.SECONDS.sleep(2);
  }

}
