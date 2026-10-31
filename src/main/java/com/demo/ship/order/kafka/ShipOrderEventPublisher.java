package com.demo.ship.order.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.demo.ship.common.constant.KafkaTopics;
import com.demo.ship.order.dto.ShipOrderAprvEvent;

import lombok.RequiredArgsConstructor;

/**
 * Publishes order approval events.
 */
@Component
@RequiredArgsConstructor
public class ShipOrderEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishAprv(ShipOrderAprvEvent event) {
        kafkaTemplate.send(KafkaTopics.SHIP_ORDER_APRV, event.getOrderRegNo(), event);
    }
}
