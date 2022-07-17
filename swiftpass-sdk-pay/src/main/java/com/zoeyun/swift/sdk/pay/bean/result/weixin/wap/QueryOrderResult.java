package com.zoeyun.swift.sdk.pay.bean.result.weixin.wap;

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
public class QueryOrderResult extends BasePayResult {

    @XStreamAlias("trade_type")
    String tradeType;

    @XStreamAlias("openid")
    String openid;

    @XStreamAlias("is_subscribe")
    String isSubscribe;

    @XStreamAlias("transaction_id")
    String transactionId;


    @XStreamAlias("out_trade_no")
    String outTradeNo;

    @XStreamAlias("total_fee")
    Integer totalFee;


    @XStreamAlias("coupon_fee")
    Integer couponFee;

    @XStreamAlias("fee_type")
    String feeType;


    @XStreamAlias("attach")
    String attach;

    @XStreamAlias("bank_type")
    String bankType;


    @XStreamAlias("bank_billno")
    String bankBillno;

    @XStreamAlias("time_end")
    String timeEnd;


    @XStreamAlias("out_transaction_id")
    String outTransactionId;


    @Override
    protected void loadXml(Document d) {

        tradeType = readXmlString(d, "trade_type");
        openid = readXmlString(d, "openid");
        isSubscribe = readXmlString(d, "is_subscribe");
        transactionId = readXmlString(d, "transaction_id");
        outTradeNo = readXmlString(d, "out_trade_no");
        totalFee = readXmlInteger(d, "total_fee");
        couponFee = readXmlInteger(d, "coupon_fee");
        feeType = readXmlString(d, "fee_type");
        attach = readXmlString(d, "attach");
        bankType = readXmlString(d, "bank_type");
        bankBillno = readXmlString(d, "bank_billno");
        timeEnd = readXmlString(d, "time_end");
        outTransactionId = readXmlString(d, "out_transaction_id");

    }
}
