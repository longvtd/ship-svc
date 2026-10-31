package com.demo.ship.order.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Result of O.ShipOrderM.selectOrderTrgtList.
 */
@Getter
@Setter
public class ShipOrderTrgtDTO {
    private String orderRegNo;
    private String itemNo;
    private String shipKdNm;
    private String itemMdlNm;
    private Integer cnfmQt;
}
