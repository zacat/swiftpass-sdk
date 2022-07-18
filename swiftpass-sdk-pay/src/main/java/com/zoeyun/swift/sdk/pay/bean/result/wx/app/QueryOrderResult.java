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
public class QueryOrderResult extends BasePayResult {

    @XStreamAlias("trade_type")
    String tradeType;

    @XStreamAlias("trade_state")
    String tradeState;

    @XStreamAlias("trade_state_desc")
    String tradeStateDesc;

    @XStreamAlias("appid")
    String appid;
    @XStreamAlias("openid")
    String openid;

    @XStreamAlias("sub_appid")
    String subAppid;
    @XStreamAlias("sub_openid")
    String subOpenid;
    @XStreamAlias("is_subscribe")
    String isSubscribe;
    @XStreamAlias("transaction_id")
    String transactionId;

    @XStreamAlias("out_transaction_id")
    String outTransactionId;
    @XStreamAlias("out_trade_no")
    String outTradeNo;
    @XStreamAlias("total_fee")
    Integer totalFee;
    @XStreamAlias("coupon_fee")
    Integer couponFee;

    @XStreamAlias("promotion_detail")
    String promotionDetail;
    @XStreamAlias("fee_type")
    String feeType;
    @XStreamAlias("attach")
    String attach;
    @XStreamAlias("bank_type")
    String bankType;
    @XStreamAlias("bank_billno")
    String bankBillno;

    @XStreamAlias("gmt_payment")
    String gmtPayment;
    @XStreamAlias("time_end")
    String timeEnd;

    @XStreamAlias("mdiscount")
    Integer mdiscount;

    @XStreamAlias("risk_info")
    String riskInfo;

    @Override
    protected void loadXml(Document d) {
        tradeType = readXmlString(d, "trade_type");
        tradeState = readXmlString(d, "trade_state");
        tradeStateDesc = readXmlString(d, "trade_state_desc");
        openid = readXmlString(d, "openid");
        appid = readXmlString(d, "appid");
        subOpenid = readXmlString(d, "sub_openid");
        subAppid = readXmlString(d, "sub_appid");
        isSubscribe = readXmlString(d, "is_subscribe");
        transactionId = readXmlString(d, "transaction_id");
        outTradeNo = readXmlString(d, "out_trade_no");
        totalFee = readXmlInteger(d, "total_fee");
        couponFee = readXmlInteger(d, "coupon_fee");
        promotionDetail = readXmlString(d, "promotion_detail");
        feeType = readXmlString(d, "fee_type");
        attach = readXmlString(d, "attach");
        bankType = readXmlString(d, "bank_type");
        bankBillno = readXmlString(d, "bank_billno");
        gmtPayment = readXmlString(d, "gmtPayment");
        timeEnd = readXmlString(d, "time_end");
        outTransactionId = readXmlString(d, "out_transaction_id");
        riskInfo = readXmlString(d, "risk_info");
        mdiscount = readXmlInteger(d, "mdiscount");

    }
}
