package com.example.demoopentracing.rest;

import io.opentracing.ActiveSpan;
import java.util.Random;
import javax.inject.Inject;

/**
 * @author Pavol Loffay
 */
public class BackendService {

  @Inject
  private io.opentracing.Tracer tracer;

  public String action() throws InterruptedException {

    int random = new Random().nextInt(200);

    try (ActiveSpan span = tracer.buildSpan("action").startActive()) {
      action2();
      Thread.sleep(random);
    }

    return String.valueOf(random);
  }

  private void action2() {
    tracer.activeSpan().setTag("action2", "data");
  }
}

