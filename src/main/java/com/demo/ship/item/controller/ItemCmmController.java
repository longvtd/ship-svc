package com.demo.ship.item.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ship.item.service.ItemCmmService;
import com.demo.ship.item.service.ItemSearchService;
import com.lguplus.wafful.framework.model.map.LowerCamelCaseMap;

import lombok.RequiredArgsConstructor;

/**
 * Item common APIs.
 */
@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemCmmController {

    private final ItemCmmService itemCmmService;
    private final ItemSearchService itemSearchService;

    @GetMapping("/mdl/v1")
    public List<LowerCamelCaseMap> selectItemMdlList() {
        return itemCmmService.selectItemMdlList();
    }

    @PostMapping("/hst/v1/{itemNo}")
    public int insertItemHst(@PathVariable String itemNo) {
        return itemCmmService.insertItemHst(itemNo);
    }

    @GetMapping("/status/v1/{itemStusCd}")
    public List<LowerCamelCaseMap> selectItemByStatus(@PathVariable String itemStusCd) {
        return itemSearchService.selectItemByStatus(itemStusCd);
    }
}
