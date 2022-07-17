package com.zoeyun.swift.sdk.pay.service.impl;

import com.zoeyun.swift.sdk.pay.bean.BasePayResult;
import com.zoeyun.swift.sdk.pay.bean.request.micropay.*;
import com.zoeyun.swift.sdk.pay.bean.result.micropay.*;
import com.zoeyun.swift.sdk.pay.exception.PayException;
import com.zoeyun.swift.sdk.pay.service.MicroPayService;
import com.zoeyun.swift.sdk.pay.service.PayService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MicroPayServiceImpl implements MicroPayService {

    private final PayService payService;

    @Override
    public AuthCodeResult authCode(AuthCodeRequest request) throws PayException {
        request.checkAndSign(payService.getConfig());
        String responseContent = this.payService.post(payService.getPayBaseUrl(), request.toXML());
        AuthCodeResult result = BasePayResult.fromXML(responseContent, AuthCodeResult.class);
        result.checkResult(payService, true);
        return result;
    }

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
    public ReverseOrderResult reverseOrder(ReverseOrderRequest request) throws PayException {
        request.checkAndSign(payService.getConfig());
        String responseContent = this.payService.post(payService.getPayBaseUrl(), request.toXML());
        ReverseOrderResult result = BasePayResult.fromXML(responseContent, ReverseOrderResult.class);
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
