package com.cheche365.cheche.scheduletask.model;

/**
 * Created by guoweifu on 2015/9/21.
 */
public class SmsConfig {

    private String content;
    private String[] toSms;
    private String template;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getToSms() {
        return toSms;
    }

    public void setToSms(String[] toSms) {
        this.toSms = toSms;
    }
}
