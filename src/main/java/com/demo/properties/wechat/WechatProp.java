package com.demo.properties.wechat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:properties/wechat/wechat.properties")
public class WechatProp {

    @Value("${applet.appid}")
    private String appletAppid;

    @Value("${wxpay.mchid}")
    private String mchid;

    @Value("${wxpay.notify.url}")
    private String notifyUrl;

    @Value("${wxpay.sign.type}")
    private String signType;

    @Value("${wxpay.sign.key}")
    private String signKey;

    @Value("${applet.secret}")
    private String appletSecret;

    @Value("${wxpay.cert}")
    private String cert;

    public String getAppletAppid() {
        return appletAppid;
    }

    public void setAppletAppid(String appletAppid) {
        this.appletAppid = appletAppid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getAppletSecret() {
        return appletSecret;
    }

    public void setAppletSecret(String appletSecret) {
        this.appletSecret = appletSecret;
    }

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }
}
