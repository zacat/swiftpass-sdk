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
public class UnifiedOrderResult extends BasePayResult {

    @XStreamAlias("code")
    private String code;

    @XStreamAlias("services")
    private String services;

    @XStreamAlias("token_id")
    private String tokenId;

    @XStreamAlias("statecheckhost")
    private String statecheckhost;
    @Override
    protected void loadXml(Document d) {
        this.code = readXmlString(d, "code");
        this.services = readXmlString(d, "services");
        this.tokenId = readXmlString(d, "token_id");
        this.statecheckhost = readXmlString(d, "statecheckhost");
    }
}
