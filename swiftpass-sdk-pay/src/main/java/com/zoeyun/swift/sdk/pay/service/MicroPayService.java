package com.zoeyun.swift.sdk.pay.service;


import com.zoeyun.swift.sdk.pay.bean.request.micropay.*;
import com.zoeyun.swift.sdk.pay.bean.result.micropay.*;
import com.zoeyun.swift.sdk.pay.exception.PayException;

public interface MicroPayService {

    AuthCodeResult authCode(AuthCodeRequest request) throws PayException;

    UnifiedOrderResult unifiedOrder(UnifiedOrderRequest request) throws PayException;

    QueryOrderResult queryOrder(QueryOrderRequest request) throws PayException;

    ReverseOrderResult reverseOrder(ReverseOrderRequest request) throws PayException;

    RefundOrderResult refundOrder(RefundOrderRequest request) throws PayException;

    RefundQueryOrderResult refundQueryOrder(RefundQueryOrderRequest request) throws PayException;
}
