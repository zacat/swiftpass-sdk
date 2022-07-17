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
public class UnifiedOrderResult extends BasePayResult {

    @XStreamAlias("code")
    String code;

    @XStreamAlias("device_info")
    String deviceInfo;

    @XStreamAlias("code_url")
    String codeUrl;

    @XStreamAlias("code_img_url")
    String codeImgUrl;

    @XStreamAlias("uuid")
    String uuid;

    @Override
    protected void loadXml(Document d) {
        code = readXmlString(d,"code");
        deviceInfo = readXmlString(d,"device_info");
        codeUrl = readXmlString(d,"code_url");
        codeImgUrl = readXmlString(d,"code_img_url");
        uuid = readXmlString(d,"uuid");
    }
}
