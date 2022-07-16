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
public class QueryOrderResult extends BasePayResult {

    @XStreamAlias("trade_type")
    String tradeType;

    @XStreamAlias("device_info")
    String deviceInfo;

    @XStreamAlias("trade_state")
    String tradeState;

    @XStreamAlias("trade_state_desc")
    String tradeStateDesc;

    @XStreamAlias("sub_appid")
    String subAppid;

    @XStreamAlias("openid")
    String openid;


    @XStreamAlias("sub_openid")
    String subOpenid;

    @XStreamAlias("is_subscribe")
    String isSubscribe;

    @XStreamAlias("sub_is_subscribe")
    String subIsSubscribe;


    @XStreamAlias("transaction_id")
    String transactionId;

    @XStreamAlias("out_transaction_id")
    String outTransactionId;

    @XStreamAlias("out_trade_no")
    String outTradeNo;

    @XStreamAlias("pay_scene")
    String payScene;

    @XStreamAlias("total_fee")
    Integer totalFee;

    @XStreamAlias("cash_fee")
    Integer cashFee;

    @XStreamAlias("cash_fee_type")
    String cashFeeType;
    @XStreamAlias("coupon_fee")
    Integer couponFee;

    @XStreamAlias("buyer_logon_id")
    String buyerLogonId;

    @XStreamAlias("buyer_user_id")
    String buyerUserId;

    @XStreamAlias("receipt_amount")
    String receiptAmount;

    @XStreamAlias("fund_bill_list")
    String fundBillList;
    @XStreamAlias("point_amount")
    String pointAmount;

    @XStreamAlias("invoice_amount")
    String invoiceAmount;

    @XStreamAlias("fee_type")
    String feeType;

    @XStreamAlias("promotion_detail")
    String promotionDetail;

    @XStreamAlias("discount_goods_detail")
    String discountGoodsDetail;

    @XStreamAlias("unionpay_discount")
    String unionpayDiscount;

    @XStreamAlias("buyer_pay_amount")
    String buyerPayAmount;


    @XStreamAlias("attach")
    String attach;

    @XStreamAlias("bank_type")
    String bankType;


    @XStreamAlias("bank_billno")
    String bankBillno;

    @XStreamAlias("time_end")
    String timeEnd;

    @XStreamAlias("gmt_payment")
    String gmtPayment;

    @XStreamAlias("mdiscount")
    Integer mdiscount;

    @XStreamAlias("settlement_total_fee")
    Integer settlementTotalFee;

    @XStreamAlias("risk_info ")
    String riskInfo;


    @Override
    protected void loadXml(Document d) {

        tradeType = readXmlString(d, "trade_type");
        deviceInfo = readXmlString(d, "device_info");
        tradeState = readXmlString(d, "trade_state");
        tradeStateDesc = readXmlString(d, "trade_state_desc");


        subAppid = readXmlString(d, "sub_appid");
        openid = readXmlString(d, "openid");
        subOpenid = readXmlString(d, "sub_openid");
        isSubscribe = readXmlString(d, "is_subscribe");
        subIsSubscribe = readXmlString(d, "sub_is_subscribe");
        transactionId = readXmlString(d, "transaction_id");
        outTransactionId = readXmlString(d, "out_transaction_id");
        outTradeNo = readXmlString(d, "out_trade_no");
        payScene = readXmlString(d, "pay_scene");
        totalFee = readXmlInteger(d, "total_fee");
        cashFee = readXmlInteger(d, "cash_fee");
        cashFeeType = readXmlString(d, "cash_fee_type");
        couponFee = readXmlInteger(d, "coupon_fee");
        buyerLogonId = readXmlString(d, "buyer_logon_id");
        buyerUserId = readXmlString(d, "buyer_user_id");
        receiptAmount = readXmlString(d, "receipt_amount");
        fundBillList = readXmlString(d, "fund_bill_list");
        pointAmount = readXmlString(d, "point_amount");
        invoiceAmount = readXmlString(d, "invoice_amount");
        feeType = readXmlString(d, "fee_type");
        promotionDetail = readXmlString(d, "promotion_detail");
        discountGoodsDetail = readXmlString(d, "discount_goods_detail");
        unionpayDiscount = readXmlString(d, "unionpay_discount");
        buyerPayAmount = readXmlString(d, "buyer_pay_amount");
        attach = readXmlString(d, "attach");
        bankType = readXmlString(d, "bank_type");
        bankBillno = readXmlString(d, "bank_billno");
        timeEnd = readXmlString(d, "time_end");
        gmtPayment = readXmlString(d, "gmt_payment");
        mdiscount = readXmlInteger(d, "mdiscount");
        settlementTotalFee = readXmlInteger(d, "settlement_total_fee");
        riskInfo = readXmlString(d, "risk_info");

    }
}
