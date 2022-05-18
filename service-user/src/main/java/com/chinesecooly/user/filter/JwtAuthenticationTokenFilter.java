package com.chinesecooly.user.filter;

import com.chinesecooly.common.*;
import com.chinesecooly.redis.util.RedisUtil;
import com.chinesecooly.user.dto.LoginUser;
import com.chinesecooly.user.exception.UserExpiredException;
import io.jsonwebtoken.JwtException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private AuthenticationFailureHandler failureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, AccountExpiredException {
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        String userid = null;
        try {
            userid = JwtUtil.parseJWT(token).getSubject();
        } catch (JwtException e) {
            failureHandler.onAuthenticationFailure(request,response,new AccountExpiredException("登陆超时，请重新登录"));
            return;
        }
        String redisKey = "login:" + userid;
        LoginUser loginUser = redisUtil.getObject(redisKey);
        if (Objects.isNull(loginUser)) {
            failureHandler.onAuthenticationFailure(request,response,new AccountExpiredException("登陆超时，请重新登录"));
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}