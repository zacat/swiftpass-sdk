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
public class AuthCodeResult extends BasePayResult {

    @XStreamAlias("openid")
    String openid;

    @XStreamAlias("sub_appid")
    String subAppid;

    @XStreamAlias("sub_openid")
    String subOpenid;

    @Override
    protected void loadXml(Document d) {
        openid = readXmlString(d, "openid");
        subAppid = readXmlString(d, "sub_appid");
        subOpenid = readXmlString(d, "sub_openid");
    }
}
