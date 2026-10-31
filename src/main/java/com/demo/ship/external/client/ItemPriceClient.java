package com.demo.ship.external.client;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.lguplus.wafful.framework.api.rest.ApimRestTemplate;


import lombok.RequiredArgsConstructor;

/**
 * Outbound call to domain DMPR-SVC through ApimRestTemplate (inline placeholder literal).
 */
@Component
@RequiredArgsConstructor
public class ItemPriceClient {

    private final ApimRestTemplate apimRestTemplate;

    @SuppressWarnings("unchecked")
    public Map<String, Object> selectItemPrice(Map<String, Object> request) {
        return apimRestTemplate.post("{@dmpr-svc.itemPrice-select-001}", request, Map.class);
    }
}
