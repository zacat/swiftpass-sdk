package com.zoeyun.swift.sdk.pay.service;

import com.zoeyun.swift.sdk.pay.bean.request.wx.app.*;
import com.zoeyun.swift.sdk.pay.bean.result.wx.app.*;
import com.zoeyun.swift.sdk.pay.exception.PayException;

public interface WxAppPayService {

    UnifiedOrderResult unifiedOrder(UnifiedOrderRequest request) throws PayException;

    UnifiedRawOrderResult unifiedRawOrder(UnifiedRawOrderRequest request) throws PayException;

    QueryOrderResult queryOrder(QueryOrderRequest request) throws PayException;

    CloseOrderResult closeOrder(CloseOrderRequest request) throws PayException;

    RefundOrderResult refundOrder(RefundOrderRequest request) throws PayException;

    RefundQueryOrderResult refundQueryOrder(RefundQueryOrderRequest request) throws PayException;
}
