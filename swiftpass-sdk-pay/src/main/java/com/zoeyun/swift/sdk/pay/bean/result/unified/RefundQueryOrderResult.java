package com.zoeyun.swift.sdk.pay.bean.result.unified;

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

    @XStreamAlias("code")
    private String code;
    @XStreamAlias("device_info")
    private String deviceInfo;

    @XStreamAlias("out_trade_no")
    String outTradeNo;

    @XStreamAlias("transaction_id")
    String transactionId;

    @XStreamAlias("out_transaction_id")
    String outTransactionId;

    @XStreamAlias("refund_count")
    Integer refundCount;

    @XStreamAlias("promotion_detail")
    String promotionDetail;

    @XStreamAlias("discount_goods_detail")
    String discountGoodsDetail;

    @XStreamAlias("unionpay_discount")
    String unionpayDiscount;



    @Data
    static class Refund {
        @XStreamAlias("out_trade_no")
        String outTradeNo;

        @XStreamAlias("refund_id")
        String refundId;

        @XStreamAlias("out_refund_id")
        String outRefundId;
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
        code = readXmlString(d, "code");
        deviceInfo = readXmlString(d, "device_info");
        transactionId = readXmlString(d, "transaction_id");
        outTransactionId = readXmlString(d, "out_transaction_id");
        outTradeNo = readXmlString(d, "out_trade_no");
        refundCount = readXmlInteger(d, "refund_count");
        promotionDetail = readXmlString(d,"promotion_detail");
        discountGoodsDetail = readXmlString(d,"discount_goods_detail");
        unionpayDiscount = readXmlString(d,"unionpay_discount");

        refunds = new ArrayList<>();
        for (int i = 0; i <= refundCount - 1; i++) {
            Refund refund = new Refund();
            refund.outTradeNo = readXmlString(d, "out_trade_no_" + i);
            refund.outRefundId = readXmlString(d,"out_refund_id_" + i);
            refund.refundId = readXmlString(d, "refund_id_" + i);
            refund.refundChannel = readXmlString(d, "refund_channel_" + i);
            refund.refundFee = readXmlInteger(d, "refund_fee" + i);
            refund.couponRefundFee = readXmlInteger(d, "coupon_refund_fee" + i);
            refund.refundTime = readXmlString(d, "refund_time_" + i);
            refund.refundStatus = readXmlString(d, "refund_status_" + i);
            refund.refundStatusInfo = readXmlString(d, "refund_status_info_" + i);
            refunds.add(refund);
        }


    }
}
