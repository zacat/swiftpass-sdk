package com.zoeyun.swift.sdk.pay.bean.request.weixin.wap;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zoeyun.swift.sdk.common.annotation.Required;
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
public class RefundOrderRequest extends BasePayRequest {

    @XStreamAlias("out_trade_no")
    String outTradeNo;


    @XStreamAlias("transaction_id")
    String transactionId;

    @Required
    @XStreamAlias("out_refund_no")
    String outRefundNo;

    @Required
    @XStreamAlias("total_fee")
    Integer totalFee;

    @Required
    @XStreamAlias("refund_fee")
    Integer refundFee;

    @XStreamAlias("attach")
    String attach;


    @XStreamAlias("op_user_id")
    String opUserId;

    @XStreamAlias("refund_channel")
    String refundChannel;

    @XStreamAlias("device_location")
    String deviceLocation;


    @Override
    public void checkAndSign(PayConfig config) throws PayException {
        this.service = "unified.trade.refund";
        if (StringUtils.isBlank(this.getOpUserId())) {
            this.setOpUserId(config.getMchId());
        }
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
        map.put("out_trade_no", outTradeNo);
        map.put("transaction_id", transactionId);
        map.put("out_refund_no", outRefundNo);
        map.put("total_fee", totalFee.toString());
        map.put("refund_fee", refundFee.toString());
        map.put("attach", attach);
        map.put("op_user_id", opUserId);
        map.put("refund_channel", refundChannel);
        map.put("device_location", deviceLocation);
    }
}
