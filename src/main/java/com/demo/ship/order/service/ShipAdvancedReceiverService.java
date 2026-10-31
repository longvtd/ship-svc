package com.demo.ship.order.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.ship.common.base.AbstractDemoService;
import com.lguplus.wafful.framework.model.map.LowerCamelCaseMap;

/**
 * G3: receivers via getter, super.field and var.
 */
@Service
public class ShipAdvancedReceiverService extends AbstractDemoService {

    public List<LowerCamelCaseMap> selectItemMdlByGetter() {
        return getDao().selectList("O.ItemCmm.selectItemMdlList", new HashMap<String, Object>());
    }

    public int insertItemHstBySuper(String itemNo) {
        Map<String, Object> param = new HashMap<>();
        param.put("itemNo", itemNo);
        return super.dao.insert("O.ItemCmm.insertItemHst", param);
    }

    public int updateOrderBatchByVar(String orderRegNo) {
        var localDao = this.dao;
        Map<String, Object> param = new HashMap<>();
        param.put("orderRegNo", orderRegNo);
        return localDao.update("O.ShipOrderM.updateOrderBatch", param);
    }
}
