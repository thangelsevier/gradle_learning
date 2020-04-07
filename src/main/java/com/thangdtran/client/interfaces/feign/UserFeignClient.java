package com.thangdtran.client.interfaces.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="user-services", url = "http://localhost:9000/services")
public interface UserFeignClient {
    @GetMapping(path = "/user/{id}")
    String getUserInfo(@PathVariable("id") String id);

    @PostMapping(path = "/user/{id}/{name}")
    String updateUsername(@PathVariable("id") String id, @PathVariable("name") String username);
}
