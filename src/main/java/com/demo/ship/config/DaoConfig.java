package com.demo.ship.config;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lguplus.wafful.framework.rest.ApimRestTemplate;
import com.lguplus.wafful.framework.rest.WaffulRestTemplete;
import com.lguplus.wafful.framework.service.dao.CommonDao;
import com.lguplus.wafful.framework.service.dao.MyBatisCommonDao;

/**
 * Registers the framework CommonDao facade and REST clients.
 */
@Configuration
public class DaoConfig {

    @Bean
    public MyBatisCommonDao myBatisCommonDao(SqlSessionTemplate sqlSessionTemplate) {
        return new MyBatisCommonDao(sqlSessionTemplate);
    }

    @Bean
    public CommonDao commonDao(MyBatisCommonDao myBatisCommonDao) {
        return new CommonDao(myBatisCommonDao);
    }

    @Bean
    public WaffulRestTemplete waffulRestTemplete() {
        return new WaffulRestTemplete();
    }

    @Bean
    public ApimRestTemplate apimRestTemplate() {
        return new ApimRestTemplate();
    }
}
