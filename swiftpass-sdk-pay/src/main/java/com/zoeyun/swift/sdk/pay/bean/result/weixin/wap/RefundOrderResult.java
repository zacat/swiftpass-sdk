package com.zoeyun.swift.sdk.pay.bean.result.weixin.wap;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zoeyun.swift.sdk.common.annotation.Required;
import com.zoeyun.swift.sdk.pay.bean.BasePayResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class RefundOrderResult extends BasePayResult {

    @XStreamAlias("device_info")
    private String deviceInfo;

    @XStreamAlias("out_trade_no")
    String outTradeNo;


    @XStreamAlias("transaction_id")
    String transactionId;

    @XStreamAlias("out_refund_no")
    String outRefundNo;

    @XStreamAlias("refund_fee")
    Integer refundFee;

    @XStreamAlias("refund_id")
    String refundId;

    @XStreamAlias("refundChannel")
    String refundChannel;

    @Override
    protected void loadXml(Document d) {

        deviceInfo = readXmlString(d, "device_info");
        transactionId = readXmlString(d, "transaction_id");
        outTradeNo = readXmlString(d, "out_trade_no");
        outRefundNo = readXmlString(d, "out_refund_no");
        refundId = readXmlString(d, "refund_id");
        refundChannel = readXmlString(d, "refund_channel");
        refundFee = readXmlInteger(d, "refund_fee");
    }
}
