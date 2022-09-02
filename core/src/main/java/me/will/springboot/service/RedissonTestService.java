package me.will.springboot.service;

import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import me.will.springboot.model.User;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

@Service
public class RedissonTestService {

  @Resource
  private RedissonClient redissonClient;

  public User getUser() {
    var key = "user1";
    var bucket = redissonClient.<User>getBucket(key);
    if (!bucket.isExists()) {
      var user = new User(1, "willdu");
      bucket.set(user, 1, TimeUnit.DAYS);
      return user;
    }
    return bucket.get();
  }

}
