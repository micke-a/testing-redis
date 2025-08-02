package me.mikael.testing.redis.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;


@RequiredArgsConstructor
@Slf4j
public class Receiver {

    private final ObjectMapper objectMapper;

    private final AtomicInteger counter = new AtomicInteger();

    public void receiveMessage(String message) {
        var msg = objectMapper.convertValue(message, String.class);
        log.info("Received raw:{}, parsed:{}", message, msg);
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}
