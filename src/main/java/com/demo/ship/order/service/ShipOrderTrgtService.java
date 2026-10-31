package com.demo.ship.order.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.demo.ship.common.constant.ShipQueryIds;
import com.demo.ship.external.client.ItemPriceClient;
import com.demo.ship.order.dto.ShipOrderTrgtDTO;
import com.demo.ship.order.dto.ShipTrgtSrchPageDTO;
import com.lguplus.wafful.framework.service.dao.CommonDao;

/**
 * V2: explicit constructor injection, name "comDao".
 * selectListManualPage(data, count, page) carries 2 statement keys; selectMap mapKey is NOT a key.
 */
@Service
public class ShipOrderTrgtService {

    private static final String NS = "O.ShipOrderM.";

    private final CommonDao comDao;
    private final ItemPriceClient itemPriceClient;

    public ShipOrderTrgtService(CommonDao comDao, ItemPriceClient itemPriceClient) {
        this.comDao = comDao;
        this.itemPriceClient = itemPriceClient;
    }

    public Page<ShipOrderTrgtDTO> selectOrderTrgtList(ShipTrgtSrchPageDTO srch) {
        return comDao.selectListManualPage(NS + "selectOrderTrgtList", NS + "countOrderTrgtList", srch);
    }

    public Map<String, Object> selectItemMap(String itemNo) {
        Map<String, Object> param = new HashMap<>();
        param.put("itemNo", itemNo);
        Map<String, Object> result = this.comDao.selectMap("O.ItemCmm.selectItemM", param, "itemNo");
        result.put("price", itemPriceClient.selectItemPrice(param));
        return result;
    }

    public boolean existsOrder(String orderRegNo) {
        Map<String, Object> param = new HashMap<>();
        param.put("orderRegNo", orderRegNo);
        Integer cnt = comDao.selectOne(ShipQueryIds.SELECT_EXISTS_CHECK, param);
        return cnt != null && cnt > 0;
    }
}
