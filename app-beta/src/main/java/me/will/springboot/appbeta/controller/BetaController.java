package me.will.springboot.appbeta.controller;

import javax.annotation.Resource;
import me.will.springboot.model.User;
import me.will.springboot.service.RedissonTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beta")
public class BetaController {

  @Resource
  private RedissonTestService redissonTestService;

  @GetMapping("/test")
  public String test() {
    var user = redissonTestService.getUser();
    System.out.println(user);
    return "beta";
  }

}
