package com.demo.ship.order.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.demo.ship.common.constant.KafkaTopics;
import com.demo.ship.item.service.ItemCmmService;
import com.demo.ship.order.dto.ShipOrderAprvEvent;

import lombok.RequiredArgsConstructor;

/**
 * Consumes order approval events and writes the item history.
 */
@Component
@RequiredArgsConstructor
public class ShipOrderEventListener {

    private final ItemCmmService itemCmmService;

    @KafkaListener(topics = KafkaTopics.SHIP_ORDER_APRV, groupId = "ship-svc")
    public void onOrderAprv(ShipOrderAprvEvent event) {
        itemCmmService.insertItemHst(event.getOrderRegNo());
    }
}
