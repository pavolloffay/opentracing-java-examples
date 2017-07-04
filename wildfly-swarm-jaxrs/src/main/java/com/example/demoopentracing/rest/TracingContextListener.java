package com.example.demoopentracing.rest;

import com.uber.jaeger.Configuration;
import com.uber.jaeger.samplers.ProbabilisticSampler;
import io.opentracing.util.GlobalTracer;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Pavol Loffay
 */
@WebListener
public class TracingContextListener implements ServletContextListener {

  @Inject
  private io.opentracing.Tracer tracer;

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    GlobalTracer.register(tracer);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {}

  @Produces
  @Singleton
  public static io.opentracing.Tracer jaegerTracer() {
    return new Configuration("wildfly-swarm", new Configuration.SamplerConfiguration(
        ProbabilisticSampler.TYPE, 1),
        new Configuration.ReporterConfiguration())
        .getTracer();
  }
}
