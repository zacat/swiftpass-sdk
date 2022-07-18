package com.zoeyun.swift.sdk.pay.service;


import com.zoeyun.swift.sdk.pay.bean.request.weixin.wap.*;
import com.zoeyun.swift.sdk.pay.bean.result.weixin.wap.*;
import com.zoeyun.swift.sdk.pay.exception.PayException;

public interface WxWapPayService {

    UnifiedOrderResult unifiedOrder(UnifiedOrderRequest request) throws PayException;

    QueryOrderResult queryOrder(QueryOrderRequest request) throws PayException;

    CloseOrderResult closeOrder(CloseOrderRequest request) throws PayException;

    RefundOrderResult refundOrder(RefundOrderRequest request) throws PayException;

    RefundQueryOrderResult refundQueryOrder(RefundQueryOrderRequest request) throws PayException;
}
