package com.cheche365.cheche.operationcenter.test.sms;

import com.cheche365.cheche.core.model.PurchaseOrder;
import com.cheche365.cheche.core.model.ScheduleCondition;
import com.cheche365.cheche.core.service.sms.SmsCodeConstant;
import org.junit.Test;

/**
 * Created by xu.yelong on 2016-06-22.
 * 人工报价提交订单-普通线上支付
 */
public class CustomerQuoteOrderNormalOnlineTest extends BaseTest {
    @Test
    public void test() {
        PurchaseOrder purchaseOrder = purchaseOrderService.findById(1L);
        paramMap.put(SmsCodeConstant.TYPE, ScheduleCondition.Enum.CUSTOMER_QUOTE_ORDER_NORMAL_ONLINE.getId().toString());
        paramMap.put(SmsCodeConstant.ORDER_ORDER_NO, purchaseOrder.getOrderNo());
        paramMap.put(SmsCodeConstant.M_PAYMENT_LINK, purchaseOrder.getOrderNo());
        process();
    }
}
