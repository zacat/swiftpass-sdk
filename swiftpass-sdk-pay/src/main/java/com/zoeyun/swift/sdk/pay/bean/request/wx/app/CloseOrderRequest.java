package com.zoeyun.swift.sdk.pay.bean.request.wx.app;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zoeyun.swift.sdk.pay.bean.BasePayRequest;
import com.zoeyun.swift.sdk.pay.config.PayConfig;
import com.zoeyun.swift.sdk.pay.exception.PayException;
import lombok.*;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
public class CloseOrderRequest extends BasePayRequest {

    @XStreamAlias("out_trade_no")
    String outTradeNo;

    @Override
    public void checkAndSign(PayConfig config) throws PayException {
        this.service = "unified.trade.close";
        super.checkAndSign(config);
    }

    @Override
    protected void checkConstraints() throws PayException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("out_trade_no", outTradeNo);
    }
}
