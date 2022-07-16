package com.zoeyun.swift.sdk.pay.bean.notify;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.zoeyun.swift.sdk.common.utils.xml.XStreamInitializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PayNotifyResponse {

    @XStreamOmitField
    private static final transient String FAIL = "FAIL";
    @XStreamOmitField
    private static final transient String SUCCESS = "SUCCESS";

}
