package com.zoeyun.swift.sdk.pay.bean.result.weixin.wap;

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
    @Override
    protected void loadXml(Document d) {

    }
}
