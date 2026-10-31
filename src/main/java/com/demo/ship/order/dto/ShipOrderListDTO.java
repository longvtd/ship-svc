package com.demo.ship.order.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Request row for order approval.
 */
@Getter
@Setter
public class ShipOrderListDTO {
    private String orderRegNo;
    private String orderAssgNo;
    private String makerCd;
    private String rqstNo;
    private String orderStusCd;
    private String userId;
}
