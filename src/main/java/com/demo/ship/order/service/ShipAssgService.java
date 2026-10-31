package com.demo.ship.order.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.ship.common.base.AbstractDemoService;

/**
 * V5: CommonDao field "dao" inherited from AbstractDemoService.
 */
@Service
public class ShipAssgService extends AbstractDemoService {

    public int deleteOrderAssg(String orderRegNo, List<String> assgNoList) {
        Map<String, Object> param = new HashMap<>();
        param.put("orderRegNo", orderRegNo);
        param.put("assgNoList", assgNoList);
        return dao.delete("O.ShipOrderM.deleteOrderAssgD", param);
    }
}
