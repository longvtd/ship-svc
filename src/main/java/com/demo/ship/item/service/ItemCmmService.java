package com.demo.ship.item.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lguplus.wafful.framework.model.map.LowerCamelCaseMap;
import com.lguplus.wafful.framework.service.dao.CommonDao;

/**
 * V3: field injection with an arbitrary variable name "a".
 */
@Service
public class ItemCmmService {

    private static final String NAMESPACE = "O.ItemCmm";

    @Autowired
    private CommonDao a;

    public LowerCamelCaseMap selectItemM(String itemNo) {
        Map<String, Object> param = new HashMap<>();
        param.put("itemNo", itemNo);
        return a.selectOne("O.ItemCmm.selectItemM", param);
    }

    public List<LowerCamelCaseMap> selectItemMdlList() {
        return a.selectList("O.ItemCmm.selectItemMdlList", new HashMap<String, Object>());
    }

    public int insertItemHst(String itemNo) {
        Map<String, Object> param = new HashMap<>();
        param.put("itemNo", itemNo);
        return a.insert(NAMESPACE + ".insertItemHst", param);
    }
}
