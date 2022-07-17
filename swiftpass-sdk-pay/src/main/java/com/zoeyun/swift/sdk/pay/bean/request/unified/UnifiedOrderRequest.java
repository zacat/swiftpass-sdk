package com.zoeyun.swift.sdk.pay.bean.request.unified;

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

    @Required
    @XStreamAlias("out_trade_no")
    String outTradeNo;

    @XStreamAlias("device_info")
    String deviceInfo;

    @XStreamAlias("op_user_id")
    String opUserId;

    @XStreamAlias("op_shop_id")
    String opShopId;

    @Required
    @XStreamAlias("body")
    String body;


    @XStreamAlias("sub_appid")
    String subAppid;

    @XStreamAlias("attach")
    String attach;

    @XStreamAlias("goods_detail")
    String goodsDetail;

    @Required
    @XStreamAlias("total_fee")
    Integer totalFee;

    @XStreamAlias("need_receipt")
    Boolean needReceipt;

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

    @XStreamAlias("time_start")
    String timeStart;

    @XStreamAlias("time_expire")
    String timeExpire;

    @XStreamAlias("goods_tag")
    String goodsTag;

    @XStreamAlias("product_id")
    String productId;

    @XStreamAlias("limit_credit_pay")
    String limitCreditPay;

    @XStreamAlias("terminal_info")
    String terminalInfo;


    @Override
    public void checkAndSign(PayConfig config) throws PayException {
        this.service = "unified.trade.native";
        super.checkAndSign(config);
    }

    @Override
    protected void checkConstraints() throws PayException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {

        map.put("merchant_name", merchantName);
        map.put("out_trade_no", outTradeNo);
        map.put("device_info", deviceInfo);
        map.put("op_user_id", opUserId);
        map.put("op_shop_id", opShopId);
        map.put("body", body);
        map.put("sub_appid", subAppid);
        map.put("attach", attach);
        map.put("goods_detail", goodsDetail);
        map.put("total_fee", totalFee.toString());
        map.put("need_receipt", needReceipt.toString());
        map.put("mch_create_ip", mchCreateIp);
        map.put("extend_params", extendParams);
        map.put("device_location", deviceLocation);
        map.put("notify_url", notifyUrl);
        map.put("time_start", timeStart);
        map.put("time_expire", timeExpire);
        map.put("goods_tag", goodsTag);
        map.put("limit_credit_pay", limitCreditPay);
        map.put("terminal_info", terminalInfo);


    }
}
