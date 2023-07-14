package com.gmarket.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MoaSampleController {

  @GetMapping("/test/moaErrorLog")
  public String getMoaErrorLog() {
    log.error("test error");
    log.error("test error");
    log.error("test error");
    return "moa 에서 에러로그를 확인하세요";
  }
}

