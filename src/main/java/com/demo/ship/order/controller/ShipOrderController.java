package com.demo.ship.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ship.order.dto.ShipOrderListDTO;
import com.demo.ship.order.dto.ShipOrderTrgtDTO;
import com.demo.ship.order.dto.ShipTrgtSrchPageDTO;
import com.demo.ship.order.service.ShipAssgService;
import com.demo.ship.order.service.ShipOrderAprvService;
import com.demo.ship.order.service.ShipOrderTrgtService;
import com.demo.ship.order.service.ShipRqstService;

import lombok.RequiredArgsConstructor;

/**
 * Order shipping APIs.
 */
@RestController
@RequestMapping("/order/ship")
@RequiredArgsConstructor
public class ShipOrderController {

    private final ShipOrderAprvService shipOrderAprvService;
    private final ShipOrderTrgtService shipOrderTrgtService;
    private final ShipRqstService shipRqstService;
    private final ShipAssgService shipAssgService;

    @PostMapping("/aprv/v1")
    public String saveOrderAppr(@RequestBody List<ShipOrderListDTO> uDTO) {
        return shipOrderAprvService.saveOrderAppr(uDTO);
    }

    @PostMapping("/trgt/v1")
    public Page<ShipOrderTrgtDTO> selectOrderTrgtList(@RequestBody ShipTrgtSrchPageDTO srch) {
        return shipOrderTrgtService.selectOrderTrgtList(srch);
    }

    @GetMapping("/item/v1/{itemNo}")
    public Map<String, Object> selectItemMap(@PathVariable String itemNo) {
        return shipOrderTrgtService.selectItemMap(itemNo);
    }

    @GetMapping("/exists/v1/{orderRegNo}")
    public boolean existsOrder(@PathVariable String orderRegNo) {
        return shipOrderTrgtService.existsOrder(orderRegNo);
    }

    @PostMapping("/rqst/v1")
    public int insertShipRqst(@RequestBody ShipOrderListDTO dto) {
        return shipRqstService.insertShipRqst(dto);
    }

    @PutMapping("/batch/v1")
    public int updateOrderBatch(@RequestBody Map<String, String> body) {
        return shipRqstService.updateOrderBatch(body.get("orderRegNo"), body.get("orderStusCd"));
    }

    @DeleteMapping("/assg/v1")
    public int deleteOrderAssg(@RequestParam String orderRegNo, @RequestParam List<String> assgNo) {
        return shipAssgService.deleteOrderAssg(orderRegNo, assgNo);
    }
}
