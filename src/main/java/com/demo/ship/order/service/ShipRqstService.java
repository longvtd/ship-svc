package com.demo.ship.order.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.ship.common.constant.ShipQueryIds;
import com.demo.ship.order.dto.ShipOrderListDTO;
import com.lguplus.wafful.framework.service.dao.CommonDao;

import lombok.RequiredArgsConstructor;

/**
 * V4: typed local variable receiver. V6: static final namespace concatenation + interface constant.
 */
@Service
@RequiredArgsConstructor
public class ShipRqstService {

    private static final String NS = "O.ShipOrderM.";

    private final CommonDao shipDao;

    public int insertShipRqst(ShipOrderListDTO dto) {
        CommonDao d = this.shipDao;
        return d.insert(NS + "insertShipRqstD", dto);
    }

    public int updateOrderBatch(String orderRegNo, String orderStusCd) {
        Map<String, Object> param = new HashMap<>();
        param.put("orderRegNo", orderRegNo);
        param.put("orderStusCd", orderStusCd);
        return shipDao.update(ShipQueryIds.UPDATE_ORDER_BATCH, param);
    }
}
