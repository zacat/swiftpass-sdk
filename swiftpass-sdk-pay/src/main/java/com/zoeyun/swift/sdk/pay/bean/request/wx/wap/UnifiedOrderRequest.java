package com.zoeyun.swift.sdk.pay.bean.request.wx.wap;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.zoeyun.swift.sdk.common.annotation.Required;
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
public class UnifiedOrderRequest extends BasePayRequest {

    @XStreamAlias("merchant_name")
    String merchantName;

    @XStreamAlias("groupno")
    String groupno;

    @Required
    @XStreamAlias("out_trade_no")
    String outTradeNo;

    @Required
    @XStreamAlias("body")
    String body;

    @XStreamAlias("attach")
    String attach;

    @XStreamAlias("op_user_id")
    String opUserId;

    @XStreamAlias("op_shop_id")
    String opShopId;

    @Required
    @XStreamAlias("total_fee")
    Integer totalFee;

    @Required
    @XStreamAlias("mch_create_ip")
    String mchCreateIp;


    @XStreamAlias("extend_params")
    String extendParams;

    @XStreamAlias("device_location")
    String deviceLocation;

    @Required
    @XStreamAlias("notify_url")
    String notifyUrl;


    @XStreamAlias("callback_url")
    String callbackUrl;

    @XStreamAlias("time_start")
    String timeStart;

    @XStreamAlias("time_expire")
    String timeExpire;

    @XStreamAlias("goodsTag")
    String goodsTag;

    @XStreamAlias("device_info")
    String deviceInfo;

    @XStreamAlias("mch_app_name")
    String mchAppName;

    @XStreamAlias("mch_app_id")
    String mchAppId;

    @Override
    public void checkAndSign(PayConfig config) throws PayException {
        this.service = "pay.weixin.wappay";
        super.checkAndSign(config);
    }

    @Override
    protected void checkConstraints() throws PayException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("merchant_name", merchantName);
        map.put("groupno", groupno);
        map.put("out_trade_no", outTradeNo);
        map.put("body", body);
        map.put("attach", attach);
        map.put("op_user_id", opUserId);
        map.put("op_shop_id", opShopId);
        map.put("total_fee", totalFee.toString());
        map.put("mch_create_ip", mchCreateIp);
        map.put("extend_params", extendParams);
        map.put("device_location", deviceLocation);
        map.put("notify_url", notifyUrl);
        map.put("callback_url", callbackUrl);
        map.put("time_start", timeStart);
        map.put("time_expire", timeExpire);
        map.put("goods_tag", goodsTag);
        map.put("device_info", deviceInfo);
        map.put("mch_app_name", mchAppName);
        map.put("mch_app_id", mchAppId);
    }
}
