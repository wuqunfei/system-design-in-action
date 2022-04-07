package com.systemdesign.web;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.prometheus.client.Histogram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.Thread.sleep;

/***
 * https://tomgregory.com/the-four-types-of-prometheus-metrics/
 */
@RestController
public class GreetingController {

    private MeterRegistry meterRegistry;
    private CollectorRegistry collectorRegistry;

    private Counter counter;
    private Gauge gauge;
    private Histogram histogram;

    @Autowired
    public GreetingController(MeterRegistry meterRegistry, CollectorRegistry collectorRegistry) {

        this.meterRegistry = meterRegistry;
        this.collectorRegistry = collectorRegistry;
        this.counter = this.meterRegistry.counter("greeting.counter");
        this.gauge = Gauge.build()
                .name("greeting_gauge")
                .help("greeting gauge example")
                .register(this.collectorRegistry);
        this.histogram = Histogram.build()
                .name("greeting_duration")
                .help("Time for HTTP request.")
                .register(collectorRegistry);
    }

    @GetMapping("/greetings")
    @Timed(value = "greeting.time", histogram = true, description = "greeting time in spring")
    public List<String> greetings() {
        this.counter.increment();
        this.gauge.inc();
        return List.of("Hello", "Hallo");
    }

    @GetMapping("/goodbye")
    public String goodbye() throws InterruptedException {
        Histogram.Timer timer = histogram.startTimer();
        long sleepDuration = Double.valueOf(Math.floor(Math.random() * 10 * 1000)).longValue();
        sleep(sleepDuration);
        timer.observeDuration();
        this.gauge.dec();
        return "Bye: sleeping" + sleepDuration;
    }
}
