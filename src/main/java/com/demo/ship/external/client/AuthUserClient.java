package com.demo.ship.external.client;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.lguplus.wafful.framework.api.rest.WaffulRestTemplate;

import lombok.RequiredArgsConstructor;

/**
 * Outbound call to domain DMAU-SVC through WaffulRestTemplete.
 * Placeholder "{@dmau-svc.userInfo-cache-001}" = {@domain_id.url_id} (config/domain.yml + domain-api.yml).
 */
@Component
@RequiredArgsConstructor
public class AuthUserClient {

    private static final String USER_INFO_CACHE_URL = "{@dmau-svc.userInfo-cache-001}";

    private final WaffulRestTemplate waffulRestTemplate;


    @SuppressWarnings("unchecked")
    public Map<String, Object> getUserInfo(String userId) {
        return waffulRestTemplate.get(USER_INFO_CACHE_URL, Map.class, userId);
    }
}
