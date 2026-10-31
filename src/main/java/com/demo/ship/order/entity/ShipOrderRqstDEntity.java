package com.demo.ship.order.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Update parameter for O.ShipOrderM.updateOrderAprvD.
 */
@Getter
@Setter
public class ShipOrderRqstDEntity {
    private String orderRegNo;
    private Integer orderRegSno;
    private String orderStusCd;
    private String updUserId;
}
