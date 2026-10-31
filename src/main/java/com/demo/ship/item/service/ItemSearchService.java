package com.demo.ship.item.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.lguplus.wafful.framework.service.dao.*;
import com.lguplus.wafful.framework.model.map.*;

/**
 * G1: CommonDao visible only through wildcard imports, together with java.util.*.
 */
@Service
public class ItemSearchService {

    private final CommonDao commonDao;

    public ItemSearchService(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    public List<LowerCamelCaseMap> selectItemByStatus(String itemStusCd) {
        Map<String, Object> param = new HashMap<>();
        param.put("itemStusCd", itemStusCd);
        param.put("sortColumn", "item_no");
        return commonDao.selectList("O.ItemCmm.selectItemByStatus", param);
    }
}
