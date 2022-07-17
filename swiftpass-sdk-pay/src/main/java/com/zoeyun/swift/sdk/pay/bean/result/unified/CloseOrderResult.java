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
public class CloseOrderResult extends BasePayResult {

    @XStreamAlias("code")
    String code;

    @Override
    protected void loadXml(Document d) {
        code = readXmlString(d, "code");
    }
}
