package com.zoeyun.swift.sdk.pay.bean.result.wx.app;

import com.thoughtworks.xstream.annotations.XStreamAlias;
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


    @XStreamAlias("code")
    private String code;
    @XStreamAlias("device_info")
    private String deviceInfo;

    @XStreamAlias("transaction_id")
    String transactionId;

    @XStreamAlias("out_transaction_id")
    String outTransactionId;

    @XStreamAlias("out_trade_no")
    String outTradeNo;

    @XStreamAlias("out_refund_no")
    String outRefundNo;

    @XStreamAlias("refund_fee")
    Integer refundFee;

    @XStreamAlias("refund_id")
    String refundId;

    @XStreamAlias("refundChannel")
    String refundChannel;

    @XStreamAlias("trade_type")
    String tradeType;

    @Override
    protected void loadXml(Document d) {
        code = readXmlString(d, "code");
        deviceInfo = readXmlString(d, "device_info");
        transactionId = readXmlString(d, "transaction_id");
        outTransactionId = readXmlString(d, "out_transaction_id");
        outTradeNo = readXmlString(d, "out_trade_no");
        outRefundNo = readXmlString(d, "out_refund_no");
        refundId = readXmlString(d, "refund_id");
        refundChannel = readXmlString(d, "refund_channel");
        refundFee = readXmlInteger(d, "refund_fee");
        tradeType = readXmlString(d, "trade_type");
    }
}
