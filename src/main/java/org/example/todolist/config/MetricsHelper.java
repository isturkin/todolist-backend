package org.example.todolist.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MetricsHelper {

    private final MeterRegistry meterRegistry;

    public Counter buildTaskCounter() {
        return Counter.builder("tasks.counter").register(meterRegistry);
    }
}
