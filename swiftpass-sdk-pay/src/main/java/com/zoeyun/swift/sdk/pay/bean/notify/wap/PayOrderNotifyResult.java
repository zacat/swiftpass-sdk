package com.zoeyun.swift.sdk.pay.bean.notify.wap;

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
public class PayOrderNotifyResult extends BasePayResult {

    @XStreamAlias("device_info")
    private String deviceInfo;


    @XStreamAlias("openid")
    private String openid;

    @XStreamAlias("trade_type")
    private String tradeType;

    @XStreamAlias("is_subscribe")
    private String isSubscribe;

    @XStreamAlias("pay_result")
    private Integer payResult;

    @XStreamAlias("pay_info")
    private String payInfo;

    @XStreamAlias("transaction_id")
    private String transactionId;

    @XStreamAlias("out_transaction_id")
    private String outTransactionId;

    @XStreamAlias("sub_is_subscribe")
    private String subIsSubscribe;

    @XStreamAlias("sub_appid")
    private String subAppid;


    @XStreamAlias("sub_openid")
    private String subOpenid;

    @XStreamAlias("out_trade_no")
    private String outTradeNo;


    @XStreamAlias("total_fee")
    private Integer totalFee;

    @XStreamAlias("cash_fee")
    private Integer cashFee;


    @XStreamAlias("coupon_fee")
    private Integer couponFee;

    @XStreamAlias("fee_type")
    private String feeType;


    @XStreamAlias("attach")
    private String attach;


    @XStreamAlias("bank_type")
    private String bankType;


    @XStreamAlias("bank_billno")
    private String bankBillno;


    @XStreamAlias("time_end")
    private String timeEnd;

    @Override
    protected void loadXml(Document d) {
        this.deviceInfo = readXmlString(d, "device_info");
        this.openid = readXmlString(d, "openid");
        this.tradeType = readXmlString(d, "trade_type");
        this.isSubscribe = readXmlString(d, "is_subscribe");
        this.payResult = readXmlInteger(d, "pay_result");
        this.payInfo = readXmlString(d, "pay_info");
        this.transactionId = readXmlString(d, "transaction_id");
        this.outTransactionId = readXmlString(d, "out_transaction_id");
        this.subIsSubscribe = readXmlString(d, "sub_is_subscribe");
        this.subAppid = readXmlString(d, "sub_appid");
        this.subOpenid = readXmlString(d, "sub_openid");
        this.outTradeNo = readXmlString(d, "out_trade_no");
        this.totalFee = readXmlInteger(d, "total_fee");
        this.cashFee = readXmlInteger(d, "cash_fee");
        this.couponFee = readXmlInteger(d, "coupon_fee");
        this.feeType = readXmlString(d, "fee_type");
        this.attach = readXmlString(d, "attach");
        this.bankType = readXmlString(d, "bank_type");
        this.bankType = readXmlString(d, "bank_type");
        this.timeEnd = readXmlString(d, "time_end");
    }
}
