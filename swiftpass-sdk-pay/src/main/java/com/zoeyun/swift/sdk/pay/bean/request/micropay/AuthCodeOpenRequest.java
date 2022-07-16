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
public class AuthCodeOpenRequest extends BasePayRequest {

    @XStreamAlias("sub_appid")
    String subAppid;

    @Required
    @XStreamAlias("auth_code")
    String authCode;

    @Override
    public void checkAndSign(PayConfig config) throws PayException {
        this.service = "unified.tools.authcodetoopenid";
        super.checkAndSign(config);
    }

    @Override
    protected void checkConstraints() throws PayException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("sub_appid",authCode);
        map.put("auth_code",subAppid);
    }
}
