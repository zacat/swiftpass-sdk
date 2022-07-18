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
public class CloseOrderResult extends BasePayResult {


    @XStreamAlias("code")
    String code;

    @XStreamAlias("appid")
    String appid;
    @Override
    protected void loadXml(Document d) {
        this.code = readXmlString(d,"code");
        this.appid = readXmlString(d,"appid");
    }
}
