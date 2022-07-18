package com.zoeyun.swift.sdk.pay.service.impl;

import com.zoeyun.swift.sdk.pay.bean.BasePayResult;

import com.zoeyun.swift.sdk.pay.bean.request.weixin.wap.*;
import com.zoeyun.swift.sdk.pay.bean.result.weixin.wap.*;
import com.zoeyun.swift.sdk.pay.exception.PayException;
import com.zoeyun.swift.sdk.pay.service.PayService;
import com.zoeyun.swift.sdk.pay.service.WxWapPayService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WxWapPayServiceImpl implements WxWapPayService {

    private final PayService payService;


    @Override
    public UnifiedOrderResult unifiedOrder(UnifiedOrderRequest request) throws PayException {
        request.checkAndSign(payService.getConfig());
        String responseContent = this.payService.post(payService.getPayBaseUrl(), request.toXML());
        UnifiedOrderResult result = BasePayResult.fromXML(responseContent, UnifiedOrderResult.class);
        result.checkResult(payService, true);
        return result;
    }

    @Override
    public QueryOrderResult queryOrder(QueryOrderRequest request) throws PayException {
        request.checkAndSign(payService.getConfig());
        String responseContent = this.payService.post(payService.getPayBaseUrl(), request.toXML());
        QueryOrderResult result = BasePayResult.fromXML(responseContent, QueryOrderResult.class);
        result.checkResult(payService, true);
        return result;
    }

    @Override
    public CloseOrderResult closeOrder(CloseOrderRequest request) throws PayException {
        request.checkAndSign(payService.getConfig());
        String responseContent = this.payService.post(payService.getPayBaseUrl(), request.toXML());
        CloseOrderResult result = BasePayResult.fromXML(responseContent, CloseOrderResult.class);
        result.checkResult(payService, true);
        return result;
    }

    @Override
    public RefundOrderResult refundOrder(RefundOrderRequest request) throws PayException {
        request.checkAndSign(payService.getConfig());
        String responseContent = this.payService.post(payService.getPayBaseUrl(), request.toXML());
        RefundOrderResult result = BasePayResult.fromXML(responseContent, RefundOrderResult.class);
        result.checkResult(payService, true);
        return result;
    }

    @Override
    public RefundQueryOrderResult refundQueryOrder(RefundQueryOrderRequest request) throws PayException {
        request.checkAndSign(payService.getConfig());
        String responseContent = this.payService.post(payService.getPayBaseUrl(), request.toXML());
        RefundQueryOrderResult result = BasePayResult.fromXML(responseContent, RefundQueryOrderResult.class);
        result.checkResult(payService, true);
        return result;
    }
}
