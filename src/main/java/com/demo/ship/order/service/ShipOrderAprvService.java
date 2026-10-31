package com.demo.ship.order.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.ship.external.client.AuthUserClient;
import com.demo.ship.item.service.ItemCmmService;
import com.demo.ship.order.dto.ShipOrderAprvEvent;
import com.demo.ship.order.dto.ShipOrderListDTO;
import com.demo.ship.order.dto.ShipOrderRqstDDTO;
import com.demo.ship.order.entity.ShipOrderRqstDEntity;
import com.demo.ship.order.kafka.ShipOrderEventPublisher;
import com.lguplus.wafful.framework.service.dao.CommonDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * V1: private final CommonDao commonDao + Lombok @RequiredArgsConstructor.
 * MAIN golden flow: DB reads/writes + Kafka publish + external API call.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ShipOrderAprvService {

    private final CommonDao commonDao;
    private final ItemCmmService itemCmmService;
    private final AuthUserClient authUserClient;
    private final ShipOrderEventPublisher shipOrderEventPublisher;

    @Transactional
    public String saveOrderAppr(List<ShipOrderListDTO> uDTO) {
        log.debug("saveOrderAppr {}", uDTO);

        int result = 0;
        int addResult = 0;

        // 주문 기본, 배정 상세
        for (ShipOrderListDTO dto : uDTO) {

            Map<String, Object> userInfo = authUserClient.getUserInfo(dto.getUserId());

            List<ShipOrderRqstDDTO> rqstDDto = commonDao.selectList("O.ShipOrderM.selectOrderRqstD", dto);
            int chkCnt = 0;

            for (ShipOrderRqstDDTO row : rqstDDto) {
                if ("Y".equals(row.getOrgChange())) {
                    chkCnt++;
                }
                itemCmmService.selectItemM(row.getItemNo());
            }

            ShipOrderRqstDEntity entity = new ShipOrderRqstDEntity();
            entity.setOrderRegNo(dto.getOrderRegNo());
            entity.setOrderStusCd(dto.getOrderStusCd());

            if (chkCnt == 0) {
                result = commonDao.update("O.ShipOrderM.updateOrderAprvD", entity);
                addResult = addResult + result;

                // 상품 이력 등록
                for (ShipOrderRqstDDTO row : rqstDDto) {
                    itemCmmService.insertItemHst(row.getItemNo());
                }

                ShipOrderAprvEvent event = new ShipOrderAprvEvent();
                event.setOrderRegNo(dto.getOrderRegNo());
                event.setOrderStusCd(dto.getOrderStusCd());
                event.setAprvUserNm(userInfo == null ? null : String.valueOf(userInfo.get("userNm")));
                shipOrderEventPublisher.publishAprv(event);
            }
        }
        return addResult > 0 ? "SUCCESS" : "NO_CHANGE";
    }
}
