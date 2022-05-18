package com.chinesecooly.user.deniedHandler;

import com.chinesecooly.common.Code;
import com.chinesecooly.common.JSONUtil;
import com.chinesecooly.common.Result;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Code code=Code.FAILED;
        if (exception instanceof AccountExpiredException) {
            code=Code.LOGIN_TIMEOUT;
        }
        Result result = Result.newInstance().code(code).message(exception.getMessage());
        String json = JSONUtil.toJSON(result);
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(json);
    }
}
