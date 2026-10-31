package com.demo.ship.order.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Kafka payload published after order approval.
 */
@Getter
@Setter
public class ShipOrderAprvEvent {
    private String orderRegNo;
    private String orderStusCd;
    private String aprvUserNm;
}
