package com.zoeyun.swift.sdk.pay.bean.request.micropay;

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
    String device_info;


    @Required
    @XStreamAlias("body")
    String body;

    @XStreamAlias("attach")
    String attach;

    @XStreamAlias("goods_detail")
    String goodsDetail;

    @XStreamAlias("business_params")
    String businessParams;

    @XStreamAlias("hb_fq_num")
    String hbFqNum;

    @XStreamAlias("hb_fq_seller_percent")
    String hbFqSellerPercent;

    @XStreamAlias("discountable_amount")
    Integer discountableAmount;

    @XStreamAlias("sub_appid")
    String subAppid;

    @Required
    @XStreamAlias("total_fee")
    Integer totalFee;

    @XStreamAlias("need_receipt")
    Boolean needReceipt;

    @Required
    @XStreamAlias("mch_create_ip")
    String mchCreateIp;

    @Required
    @XStreamAlias("auth_code")
    String authCode;

    @XStreamAlias("extend_params")
    String extendParams;

    @XStreamAlias("device_location")
    String deviceLocation;

    @XStreamAlias("time_start")
    String timeStart;

    @XStreamAlias("timeExpire")
    String timeExpire;

    @XStreamAlias("op_user_id")
    String opUserId;

    @XStreamAlias("op_shop_id")
    String opShopId;

    @XStreamAlias("op_device_id")
    String opDeviceId;

    @XStreamAlias("goods_tag")
    String goodsTag;

    @XStreamAlias("terminal_info")
    String terminalInfo;

    @Override
    public void checkAndSign(PayConfig config) throws PayException {
        this.service = "unified.trade.micropay";
        super.checkAndSign(config);
    }

    @Override
    protected void checkConstraints() throws PayException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("merchant_name", merchantName);
        map.put("out_trade_no", outTradeNo);
        map.put("device_info", device_info);
        map.put("body", body);
        map.put("attach", attach);
        map.put("goods_detail", goodsDetail);
        map.put("business_params", businessParams);
        map.put("hb_fq_num", hbFqNum);
        map.put("hb_fq_seller_percent", hbFqSellerPercent);
        map.put("discountable_amount", discountableAmount.toString());
        map.put("sub_appid", subAppid);
        map.put("total_fee", totalFee.toString());
        map.put("need_receipt", needReceipt.toString());
        map.put("mch_create_ip", mchCreateIp);
        map.put("auth_code", authCode);
        map.put("extend_params", extendParams);
        map.put("device_location", deviceLocation);
        map.put("time_start", timeStart);
        map.put("timeExpire", timeExpire);
        map.put("op_user_id", opUserId);
        map.put("op_shop_id", opShopId);
        map.put("op_device_id", opDeviceId);
        map.put("goods_tag", goodsTag);
        map.put("terminal_info", terminalInfo);
    }
}
