package com.demo.ship.common.cache;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * NOT a DAO. It has a selectList(String) method with the same name as CommonDao.
 */
@Component
public class LocalCodeCache {

    public List<String> selectList(String key) {
        return Collections.emptyList();
    }
}
