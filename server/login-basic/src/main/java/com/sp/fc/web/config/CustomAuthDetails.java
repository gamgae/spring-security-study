package com.sp.fc.web.config;

import org.springframework.security.authentication.AuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;
import com.sp.fc.web.config.RequestInfo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class CustomAuthDetails implements AuthenticationDetailsSource<HttpServletRequest,RequestInfo> {
    @Override
    public RequestInfo buildDetails(HttpServletRequest request) {
        return RequestInfo.builder()
                .remoteIp(request.getRemoteAddr())
                .sessionId(request.getSession().getId())
                .loginTime(LocalDateTime.now())
                .build();
    }
}
