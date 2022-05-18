package com.chinesecooly.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("service-comment")
public interface CommentAPI {
}
