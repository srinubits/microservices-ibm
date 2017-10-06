package com.demo.spring.client;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("emp-service")
public interface EmpFeignClient extends EmpService {

}
