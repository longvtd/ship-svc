package com.demo.ship.common.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.lguplus.wafful.framework.service.dao.CommonDao;

/**
 * Base class that holds the CommonDao field. Subclasses use the inherited field.
 */
public abstract class AbstractDemoService {

    @Autowired
    protected CommonDao dao;

    protected CommonDao getDao() {
        return dao;
    }
}
