package com.zoeyun.swift.sdk.pay.bean.request.micropay;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zoeyun.swift.sdk.pay.bean.BasePayRequest;
import com.zoeyun.swift.sdk.pay.config.PayConfig;
import com.zoeyun.swift.sdk.pay.exception.PayException;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
public class QueryOrderRequest extends BasePayRequest {

    @XStreamAlias("out_trade_no")
    String outTradeNo;


    @XStreamAlias("transaction_id")
    String transactionId;

    @Override
    public void checkAndSign(PayConfig config) throws PayException {
        this.service = "unified.trade.query";
        super.checkAndSign(config);
    }
    @Override
    protected void checkConstraints() throws PayException {
        if ((StringUtils.isBlank(transactionId) && StringUtils.isBlank(outTradeNo)) ||
                (StringUtils.isNotBlank(transactionId) && StringUtils.isNotBlank(outTradeNo))) {
            throw new PayException("transaction_id 和 out_trade_no 不能同时存在或同时为空，必须二选一");
        }
    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("transaction_id", transactionId);
        map.put("out_trade_no", outTradeNo);
    }
}
