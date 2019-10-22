package com.oxit.flox.openex;

import org.apache.camel.PropertyInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.metrics.routepolicy.MetricsRoutePolicyFactory;

/**
 * Route Jms to log.
 *
 * @author bemon
 * @since 13/01/18.
 */
public class JmsToLog extends RouteBuilder {

    @PropertyInject("jms.input.queue")
    private String inputQueue;

    @PropertyInject("jms.concurrentConsumers")
    private String jmsConcurrentConsumers;

    @PropertyInject("jms.maxConcurrentConsumers")
    private String jmsMaxConcurrentConsumers;

    @Override
    public void configure() throws Exception {
        getContext().addRoutePolicyFactory(new MetricsRoutePolicyFactory());
        from("jms:" + inputQueue
                + "?concurrentConsumers=" + jmsConcurrentConsumers
                + "&maxConcurrentConsumers=" + jmsMaxConcurrentConsumers)
            .log("Message read from " + inputQueue + " with id ${id}")
            .onCompletion().wireTap("direct-vm:traceMessage");
    }
}
