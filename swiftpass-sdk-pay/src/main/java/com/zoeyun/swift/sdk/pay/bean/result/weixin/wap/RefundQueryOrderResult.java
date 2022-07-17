package com.zoeyun.swift.sdk.pay.bean.result.weixin.wap;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zoeyun.swift.sdk.pay.bean.BasePayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class RefundQueryOrderResult extends BasePayResult {


    @XStreamAlias("device_info")
    private String deviceInfo;

    @XStreamAlias("out_trade_no")
    String outTradeNo;

    @XStreamAlias("transaction_id")
    String transactionId;

    @XStreamAlias("refund_count")
    Integer refundCount;


    @Data
    static class Refund {
        @XStreamAlias("out_trade_no")
        String outTradeNo;

        @XStreamAlias("refund_id")
        String refundId;

        @XStreamAlias("refundChannel")
        String refundChannel;

        @XStreamAlias("refund_fee")
        Integer refundFee;

        @XStreamAlias("coupon_refund_fee")
        Integer couponRefundFee;

        @XStreamAlias("refund_time")
        String refundTime;

        @XStreamAlias("refund_status")
        String refundStatus;

        @XStreamAlias("refund_status_info")
        String refundStatusInfo;
    }

    List<Refund> refunds;

    @Override
    protected void loadXml(Document d) {

        deviceInfo = readXmlString(d, "device_info");
        transactionId = readXmlString(d, "transaction_id");
        outTradeNo = readXmlString(d, "out_trade_no");
        refundCount = readXmlInteger(d, "refund_count");

        refunds = new ArrayList<>();
        for (int i = 0; i <= refundCount - 1; i++) {
            Refund refund = new Refund();
            refund.outTradeNo = readXmlString(d, "out_trade_no_" + i);
            refund.refundId = readXmlString(d, "refund_id_" + i);
            refund.refundChannel = readXmlString(d, "refund_channel_" + i);
            refund.refundFee = readXmlInteger(d, "refund_fee" + i);
            refund.couponRefundFee = readXmlInteger(d, "coupon_refund_fee" + i);
            refund.refundTime = readXmlString(d, "refund_time_" + i);
            refund.refundTime = readXmlString(d, "refund_status_" + i);
            refund.refundStatusInfo = readXmlString(d, "refund_status_info_" + i);
            refunds.add(refund);
        }


    }
}
