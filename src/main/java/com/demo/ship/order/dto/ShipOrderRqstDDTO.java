package com.demo.ship.order.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Result of O.ShipOrderM.selectOrderRqstD.
 */
@Getter
@Setter
public class ShipOrderRqstDDTO {
    private String orderRegNo;
    private Integer orderRegSno;
    private String itemNo;
    private String lastInptDt;
    private String centerCd;
    private String lastOrgCd;
    private String orgChange;
    private String itemKdCd;
}
