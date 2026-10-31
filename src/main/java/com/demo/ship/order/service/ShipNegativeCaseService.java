package com.demo.ship.order.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.ship.common.cache.LocalCodeCache;
import com.lguplus.wafful.framework.service.dao.CommonDao;

import lombok.RequiredArgsConstructor;

/**
 * Negative cases. None of these calls may create a table edge (N1 depends on the resolution policy).
 */
@Service
@RequiredArgsConstructor
public class ShipNegativeCaseService {

    private final CommonDao commonDao;
    private final LocalCodeCache localCodeCache;

    /** N1: same method name, NOT a CommonDao receiver. */
    public List<String> selectFromCache() {
        return localCodeCache.selectList("O.ShipOrderM.selectOrderRqstD");
    }

    /** N2: key not in any mapper -> KEY_NOT_FOUND. */
    public List<Object> selectMissingStatement() {
        return commonDao.selectList("O.ShipOrderM.selectNotExists", new HashMap<String, Object>());
    }

    /** N3: runtime key -> DYNAMIC_ID. */
    public List<Object> selectDynamic(String queryId) {
        return commonDao.selectList(queryId, new HashMap<String, Object>());
    }

    /** N4: namespace without "O." prefix -> KEY_NOT_FOUND (no fuzzy match). */
    public List<Object> selectWrongNamespace() {
        return commonDao.selectList("ShipOrderM.selectOrderRqstD", new HashMap<String, Object>());
    }
}
