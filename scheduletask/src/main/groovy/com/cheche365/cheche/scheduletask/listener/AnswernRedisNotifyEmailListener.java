package com.cheche365.cheche.scheduletask.listener;

import com.cheche365.cheche.core.message.AnswernNotifyEmailMessage;
import com.cheche365.cheche.core.util.CacheUtil;
import com.cheche365.cheche.scheduletask.task.BaseTask;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by mahong on 2016/5/20.
 */
@Component
public class AnswernRedisNotifyEmailListener extends BaseTask implements MessageListener {

    Logger logger = LoggerFactory.getLogger(AnswernRedisNotifyEmailListener.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    protected static final String EMAIL_CONFIG_PATH_ANSWERN = "/emailconfig/answern_error_notify_email.yml";

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String messageJson = String.valueOf(message.toString());
        if (StringUtils.isBlank(messageJson)) {
            return;
        }

        Map value = CacheUtil.doJacksonDeserialize(messageJson, Map.class);
        if (null == value) {
            logger.error("send email error, can not deserialize messageJson ,messageJson is {}", messageJson);
            return;
        }
        try {
            if (redisTemplate.opsForSet().remove(AnswernNotifyEmailMessage.QUEUE_SET, value.get(AnswernNotifyEmailMessage.NOTIFY_UNIQUE_NAME)) > 0) {
                logger.debug("begin to send email, remove msg from redis,messageJson is {}", messageJson);
                sendErrorMessage(String.valueOf(value.get(AnswernNotifyEmailMessage.NOTIFY_MSG)), EMAIL_CONFIG_PATH_ANSWERN);
            }
        } catch (Exception e) {
            logger.error("处理监听到的待发送邮件出现异常", e);
            sendErrorMessage(String.valueOf(value.get(AnswernNotifyEmailMessage.NOTIFY_MSG)), EMAIL_CONFIG_PATH_ANSWERN);
        }
    }

    @Override
    protected void doProcess() throws Exception {

    }
}
