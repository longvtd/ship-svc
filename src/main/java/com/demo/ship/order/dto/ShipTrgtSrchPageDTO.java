package com.demo.ship.order.dto;

import com.lguplus.wafful.framework.paging.model.Paging;

import lombok.Getter;
import lombok.Setter;

/**
 * Paging search condition (framework Paging, therefore PageablePaging).
 */
@Getter
@Setter
public class ShipTrgtSrchPageDTO extends Paging {
    private String makerCd;
    private String itemMdlCd;
    private String shipDivsCd;
}
