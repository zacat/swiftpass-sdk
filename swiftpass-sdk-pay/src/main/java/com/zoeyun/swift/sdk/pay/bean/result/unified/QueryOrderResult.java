package com.zoeyun.swift.sdk.pay.bean.result.unified;

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

    @XStreamAlias("buyer_pay_amount")
    String buyerPayAmount;

    @XStreamAlias("buyer_logon_id")
    String buyerLogonId;

    @XStreamAlias("buyer_user_id")
    String buyerUserId;

    @XStreamAlias("fund_bill_list")
    String fundBillList;

    @XStreamAlias("point_amount")
    String pointAmount;

    @XStreamAlias("invoice_amount")
    String invoiceAmount;

    @XStreamAlias("openid")
    String openid;

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

    @XStreamAlias("fee_type")
    String feeType;

    @XStreamAlias("promotion_detail")
    String promotionDetail;

    @XStreamAlias("discount_goods_detail")
    String discountGoodsDetail;

    @XStreamAlias("unionpay_discount")
    String unionpayDiscount;


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

    @XStreamAlias("risk_info ")
    String riskInfo;


    @Override
    protected void loadXml(Document d) {

        tradeType = readXmlString(d, "trade_type");
        tradeState = readXmlString(d, "trade_state");
        tradeStateDesc = readXmlString(d, "trade_state_desc");
        buyerPayAmount = readXmlString(d, "buyer_pay_amount");
        buyerLogonId = readXmlString(d, "buyer_logon_id");
        buyerUserId = readXmlString(d, "buyer_user_id");
        fundBillList = readXmlString(d, "fund_bill_list");
        pointAmount = readXmlString(d, "point_amount");
        invoiceAmount = readXmlString(d, "invoice_amount");
        openid = readXmlString(d, "openid");
        isSubscribe = readXmlString(d, "is_subscribe");
        transactionId = readXmlString(d, "transaction_id");
        outTransactionId = readXmlString(d, "out_transaction_id");
        outTradeNo = readXmlString(d, "out_trade_no");
        totalFee = readXmlInteger(d, "total_fee");
        couponFee = readXmlInteger(d, "coupon_fee");
        feeType = readXmlString(d, "fee_type");
        promotionDetail = readXmlString(d, "promotion_detail");
        discountGoodsDetail = readXmlString(d, "discount_goods_detail");
        unionpayDiscount = readXmlString(d, "unionpay_discount");
        attach = readXmlString(d, "attach");
        bankType = readXmlString(d, "bank_type");
        bankBillno = readXmlString(d, "bank_billno");
        timeEnd = readXmlString(d, "time_end");
        gmtPayment = readXmlString(d, "gmt_payment");
        mdiscount = readXmlInteger(d, "mdiscount");
        riskInfo = readXmlString(d, "risk_info");
    }
}
