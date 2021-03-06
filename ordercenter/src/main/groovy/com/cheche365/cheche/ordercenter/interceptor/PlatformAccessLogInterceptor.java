package com.cheche365.cheche.ordercenter.interceptor;

import com.cheche365.cheche.common.util.ServletUtils;
import com.cheche365.cheche.core.model.MoPlatformAccessLog;
import com.cheche365.cheche.core.service.DoubleDBService;
import com.cheche365.cheche.ordercenter.service.user.OrderCenterInternalUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xu.yelong on 2016-05-19.
 */
public class PlatformAccessLogInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    DoubleDBService doubleDBService;

    @Autowired
    OrderCenterInternalUserManageService orderCenterInternalUserManageService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url=request.getRequestURL().toString();
        if(url.contains("/upload") || ServletUtils.getParameters(request).contains("columns[")){
            return true;
        }
        doubleDBService.savePlatformAccessLog(request, orderCenterInternalUserManageService.getCurrentInternalUser(), MoPlatformAccessLog.PLATEFORM.ORDER_CENTER);
        return super.preHandle(request, response, handler);
    }

}
