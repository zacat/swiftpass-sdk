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
public class UnifiedRawOrderResult extends BasePayResult {

    @XStreamAlias("code")
    private String code;

    @XStreamAlias("device_info")
    private String deviceInfo;


    @XStreamAlias("token_id")
    private String tokenId;

    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @XStreamAlias("pay_info")
    private String payInfo;

    @XStreamAlias("transaction_id")
    private String transactionId;

    @XStreamAlias("appid")
    private String appid;

    @Override
    protected void loadXml(Document d) {
        this.code = readXmlString(d, "code");
        this.tokenId = readXmlString(d, "token_id");
        this.outTradeNo = readXmlString(d, "out_trade_no");
        this.deviceInfo = readXmlString(d, "device_info");
        this.payInfo = readXmlString(d, "pay_info");
        this.transactionId = readXmlString(d, "transaction_id");
        this.appid = readXmlString(d, "appid");
    }
}
