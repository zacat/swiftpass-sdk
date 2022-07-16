package com.zoeyun.swift.sdk.pay.bean.result.micropay;

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
public class UnifiedOrderResult extends BasePayResult {

    @XStreamAlias("code")
    String code;

    @XStreamAlias("need_query")
    String needQuery;

    @XStreamAlias("device_info")
    String deviceInfo;

    @XStreamAlias("openid")
    String openid;

    @XStreamAlias("sub_openid")
    String subOpenid;

    @XStreamAlias("trade_type")
    String tradeType;

    @XStreamAlias("is_subscribe")
    String isSubscribe;

    @XStreamAlias("pay_result")
    Integer payResult;

    @XStreamAlias("pay_scene")
    String payScene;

    @XStreamAlias("pay_info")
    String payInfo;

    @XStreamAlias("transaction_id")
    String transactionId;

    @XStreamAlias("out_transaction_id")
    String outTransactionId;


    @XStreamAlias("sub_is_subscribe")
    String subIsSubscribe;

    @XStreamAlias("sub_appid")
    String subAppid;

    @XStreamAlias("out_trade_no")
    String outTradeNo;

    @XStreamAlias("total_fee")
    Integer totalFee;

    @XStreamAlias("cash_fee")
    Integer cashFee;

    @XStreamAlias("invoice_amount")
    String invoiceAmount;

    @XStreamAlias("buyer_logon_id")
    String buyerLogonId;

    @XStreamAlias("buyer_user_id")
    String buyerUserId;

    @XStreamAlias("coupon_fee")
    Integer couponFee;

    @XStreamAlias("promotion_detail")
    String promotionDetail;

    @XStreamAlias("discount_goods_detail")
    String discountGoodsDetail;

    @XStreamAlias("fund_bill_list")
    String fundBillList;

    @XStreamAlias("receipt_amount")
    String receiptAmount;

    @XStreamAlias("buyer_pay_amount")
    String buyerPayAmount;

    @XStreamAlias("point_amount")
    String pointAmount;

    @XStreamAlias("fee_type")
    String feeType;

    @XStreamAlias("attach")
    String attach;

    @XStreamAlias("bank_type")
    String bankType;

    @XStreamAlias("uuid")
    String uuid;

    @XStreamAlias("bank_billno")
    String bankBillno;

    @XStreamAlias("time_end")
    String timeEnd;

    @XStreamAlias("mdiscount")
    Integer mdiscount;

    @XStreamAlias("cash_fee_type")
    String cashFeeType;

    @XStreamAlias("gmt_payment")
    String gmtPayment;

    @XStreamAlias("settlement_total_fee")
    Integer settlementTotalFee;

    @XStreamAlias("risk_info")
    String riskInfo;

    @Override
    protected void loadXml(Document d) {
        code = readXmlString(d, "code");
        needQuery = readXmlString(d, "need_query");
        deviceInfo = readXmlString(d, "device_info");
        openid = readXmlString(d, "openid");
        subOpenid = readXmlString(d, "sub_openid");
        tradeType = readXmlString(d, "trade_type");
        isSubscribe = readXmlString(d, "is_subscribe");
        deviceInfo = readXmlString(d, "device_info");
        payResult = readXmlInteger(d, "pay_result");
        payScene = readXmlString(d, "pay_scene");
        payInfo = readXmlString(d, "pay_info");
        transactionId = readXmlString(d, "transaction_id");
        outTransactionId = readXmlString(d, "out_transaction_id");
        subIsSubscribe = readXmlString(d, "sub_is_subscribe");
        subAppid = readXmlString(d, "sub_appid");
        outTradeNo = readXmlString(d, "out_trade_no");
        totalFee = readXmlInteger(d, "total_fee");
        cashFee = readXmlInteger(d, "cash_fee");
        invoiceAmount = readXmlString(d, "invoice_amount");
        buyerLogonId = readXmlString(d, "buyer_logon_id");
        buyerUserId = readXmlString(d, "buyer_user_id");
        couponFee = readXmlInteger(d, "coupon_fee");
        promotionDetail = readXmlString(d, "promotion_detail");
        discountGoodsDetail = readXmlString(d, "discount_goods_detail");
        fundBillList = readXmlString(d, "fund_bill_list");
        receiptAmount = readXmlString(d, "receipt_amount");
        buyerPayAmount = readXmlString(d, "buyer_pay_amount");
        pointAmount = readXmlString(d, "point_amount");
        feeType = readXmlString(d, "fee_type");
        attach = readXmlString(d, "attach");
        bankType = readXmlString(d, "bank_type");
        uuid = readXmlString(d, "uuid");
        bankBillno = readXmlString(d, "bank_billno");
        timeEnd = readXmlString(d, "time_end");
        mdiscount = readXmlInteger(d, "mdiscount");
        cashFeeType = readXmlString(d, "cash_fee_type");
        gmtPayment = readXmlString(d, "gmt_payment");
        settlementTotalFee = readXmlInteger(d, "settlement_total_fee");
        riskInfo = readXmlString(d, "risk_info");
    }
}
